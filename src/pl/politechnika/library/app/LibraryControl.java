package pl.politechnika.library.app;

import pl.politechnika.library.exception.*;
import pl.politechnika.library.io.ConsolPrinter;
import pl.politechnika.library.io.DataReader;
import pl.politechnika.library.io.file.FileManagerBulider;
import pl.politechnika.library.io.file.FileMenager;
import pl.politechnika.library.model.*;
import pl.politechnika.library.model.comparator.AlphabeticalTitleComparator;

import java.util.Comparator;
import java.util.InputMismatchException;

public class LibraryControl {

    // obiekty klasy dataReader do wczytywania dancyh oraz klasy biblioteka

    private Library library;
    private final ConsolPrinter printer = new ConsolPrinter();
    private final DataReader dataReader = new DataReader(printer);
    private final FileMenager fileMenager;

    LibraryControl() {
        fileMenager = new FileManagerBulider(printer,dataReader).build();
        try {
            library = fileMenager.importData(); // wczytujemy dane do biblioteki z pliku
            printer.printLine("Wczytano dane z pliku");
        }
        catch (DataImportException | InvalidDataException e){
            printer.printLine(e.getMessage());
            printer.printLine("Zainicjowano nową bazę ");
            library = new Library();
        }
        }

    // główna pętla aplikacji z możliwością wyboru opcji korzystamy z typu wyliczeniowego ENUM
    void controlLoop(){
        Option option;
        do{
            printOption();
            option = getOption();
            switch (option) {
                case ADD_BOOK -> addBook();
                case ADD_MAGAZINE -> addMagazine();
                case PRINT_BOOKS -> printBooks();
                case PRINT_MAGAZINES -> printMagazines();
                case DELETE_BOOK -> deleteBook();
                case DELETE_MAGAZINE -> deleteMagazine();
                case ADD_USERS -> addUsers();
                case PRINT_USERS -> printUsers();
                case FIND_BOOK -> findBook();
                case EXIT -> exit();
                default -> printer.printLine("Nie ma takiej opcji!!!");
            }
        }while (option != Option.EXIT);
    }

    private void findBook() {
        printer.printLine("Podaj tytuł publikacji: ");
        String title = dataReader.getString();
        String notFoundMessage = "Brak publikacji o takim tytule";
        library.findPublicationByTitle(title)
                .map(Publication::toString)
                .ifPresentOrElse(System.out::println, () -> System.out.println(notFoundMessage));
    }

    private void printUsers() {
        // wykorzystanie wyrażenia lambda
        printer.printUsers(library.getSortedUsers(
                (o1, o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName()))
        );
    }

    private void addUsers() {
        try {
            LibraryUser user = dataReader.createLibraryUser();
            library.addUser(user);
        }catch (UserAlreadyExistsException e){
            printer.printLine(e.getMessage());
        }
        }

    private void deleteMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            if (library.removePublication(magazine)) {
                printer.printLine("Usunięto magazyn");
            } else {
                printer.printLine("Brak magazynu w bibliotece");
            }
        }catch (InputMismatchException e){
            printer.printLine("Nie udało się uzunąć magazynu");
        }
    }

    private void deleteBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            if (library.removePublication(book)) {
                printer.printLine("Usunięto książkę");
            } else {
                printer.printLine("Brak książki w bibliotece");
            }
        }catch (InputMismatchException e){
            printer.printLine("Nie udało się uzunąć książkę");
        }
    }

    private Option getOption() { // metoda która pobiera opcję od użytkowanika i sprawdza czy jest poprawna
        boolean optionOK = false;
        Option option = null;
        while (!optionOK){
            try{
                option = Option.createFromInt(dataReader.getInt());
                optionOK=true;

            }catch(NoSuchOptionException e){ // obsługa wyjątku jeśli liczba z poza zakresu
                printer.printLine(e.getMessage());
            } catch (InputMismatchException e){ // obsługa wyjątku jeśli nie liczba
                printer.printLine("Wprowaszona wartość nie jest liczbą");
            }
        }
        return option;
    }

    private void printMagazines() {

        printer.printMagazines(library.getSortedPublication(new AlphabeticalTitleComparator())); // wykorzystanie własnej klasy comperatora
    }


    private void addMagazine() {
        try {
            Magazine magazin = dataReader.readAndCreateMagazine();
            library.addPublication(magazin);
        } catch (InputMismatchException e){
            printer.printLine("Nie udało się się utworzyć magazynu, niepoprawne dane ");
        }catch (ArrayIndexOutOfBoundsException e){
            printer.printLine("Osiągnięto limit pojemności, nie można dodać więcej magazynów ");
        }
    }

    // metody pomocnicze
    private void exit() { // zapisujemy wszystkie zaminy do pliku przy zamykaniu programu
        try {
            fileMenager.exportData(library);
            printer.printLine("Eksport zakończony suskcesem");
        }catch (DataExportException e){
            printer.printLine(e.getMessage());
        }
        printer.printLine("Koniec programu");
        dataReader.close();
    }

    private void printBooks() {
// wykorzystanie referencji do metod
        printer.printBooks(library.getSortedPublication(
                Comparator.comparing(Publication::getTitile, String.CASE_INSENSITIVE_ORDER)

        ));
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addPublication(book);
        } catch (InputMismatchException e){
            printer.printLine("Nie udało się się utworzyć książki, niepoprawne dane ");
        }catch (ArrayIndexOutOfBoundsException e){
            printer.printLine("Osiągnięto limit pojemności, nie można dodać więcej książek ");
        }
        }

    private void printOption() {
        printer.printLine("Wybierz opcje: ");
        for (Option value : Option.values()) {
            printer.printLine(value.toString());
        }

    }
 private    enum Option {
        EXIT(0,"wyjście z programu"),
        ADD_BOOK(1,"dodanie nowej książki"),
        ADD_MAGAZINE(2, "dodanie nowego magazynu"),
        PRINT_BOOKS(3,"wyświetlenie dostępnych książek "),
        PRINT_MAGAZINES(4,"wyświetlenie dostępnych magazynów"),
        DELETE_BOOK(5,"Usuń książkę"),
        DELETE_MAGAZINE(6,"Usuń magazyn"),
        ADD_USERS(7, "Dodaj użytkownika"),
        PRINT_USERS(8,"Wyświetl użytkowników "),
        FIND_BOOK(9, "Wyszukaj publikacę");
        private final int value;
        private final String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value+" - "+description;
        }
        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option]; //values zwraca tablicę wszytkich opcji
            } catch (ArrayIndexOutOfBoundsException e){
                throw new NoSuchOptionException("Brak opcji o id "+ option); // rzucamy własny wyjątek
            }
        }
    }
}
