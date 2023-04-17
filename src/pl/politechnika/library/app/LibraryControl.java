package pl.politechnika.library.app;

import pl.politechnika.library.exception.DataExportException;
import pl.politechnika.library.exception.DataImportException;
import pl.politechnika.library.exception.InvalidDataException;
import pl.politechnika.library.exception.NoSuchOptionException;
import pl.politechnika.library.io.ConsolPrinter;
import pl.politechnika.library.io.DataReader;
import pl.politechnika.library.io.file.FileManagerBulider;
import pl.politechnika.library.io.file.FileMenager;
import pl.politechnika.library.model.Book;
import pl.politechnika.library.model.Library;
import pl.politechnika.library.model.Magazine;
import pl.politechnika.library.model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {

    // obiekty klasy dataReader do wczytywania dancyh oraz klasy biblioteka

    private Library library;
    private ConsolPrinter printer = new ConsolPrinter();
    private DataReader dataReader = new DataReader(printer);
    private FileMenager fileMenager;

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
            switch (option){
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    printer.printLine("Nie ma takiej opcji!!!");
            }
        }while (option != Option.EXIT);
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
        Publication[] publications = library.getPublications();
        printer.printMagazines(publications);
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
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
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
        PRINT_MAGAZINES(4,"wyświetlenie dostępnych magazynów");
        private final int value;
        private final String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return description;
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
