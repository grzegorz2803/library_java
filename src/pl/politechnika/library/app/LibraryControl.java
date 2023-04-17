package pl.politechnika.library.app;

import pl.politechnika.library.io.DataReader;
import pl.politechnika.library.model.Book;
import pl.politechnika.library.model.Library;
import pl.politechnika.library.model.Magazine;

public class LibraryControl {
    // prywatne pola opcji jakie może wybrać użytkownik
    private static final int EXIT = 0;
    private  static final int ADD_BOOK = 1;
    private  static final int ADD_MAGAZINE = 2;
    private  static final int PRINT_BOOKS = 3;
    private  static final int PRINT_MAGAZINES = 4;
    // obiekty klasy dataReader do wczytywania dancyh oraz klasy biblioteka
    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    // główna pętla aplikacji z możliwością wyboru opcji
    public void controlLoop(){
        int option;
        do{
            printOption();
            option = dataReader.getInt();
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
                    System.out.println("Nie ma takiej opcji!!!");
            }
        }while (option != EXIT);
    }

    private void printMagazines() {
        library.printMagazines();
    }

    private void addMagazine() {
        Magazine magazin = dataReader.readAndCreateMagazine();
        library.addMagazine(magazin);
    }

    // metody pomocnicze
    private void exit() {
        System.out.println("Koniec programu");
        dataReader.close();
    }

    private void printBooks() {
        library.printBooks();
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printOption() {
        System.out.println("Wybierz opcje: ");
        System.out.println(EXIT + " - Wyjście z programu");
        System.out.println(ADD_BOOK + " - dodanie nowej książki");
        System.out.println(ADD_MAGAZINE + " - dodanie nowego magazynu");
        System.out.println(PRINT_BOOKS + " - wyświetlenie dostępnych książek");
        System.out.println(PRINT_MAGAZINES + " - wyświetlenie dostępnych magazynów");

    }
}
