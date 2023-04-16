package pl.politechnika.library.app;

import pl.politechnika.library.io.DataReader;
import pl.politechnika.library.model.Book;
import pl.politechnika.library.model.Library;

public class LibraryControl {
    // prywatne pola opcji jakie może wybrać użytkownik
    private final int exit = 0;
    private  final int addBook = 1;
    private  final int printBooks = 2;
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
                case addBook:
                    addBook();
                    break;
                case printBooks:
                    printBooks();
                    break;
                case exit:
                    exit();
                    break;
                default:
                    System.out.println("Nie ma takiej opcji!!!");
            }
        }while (option !=exit);
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
        System.out.println(exit + " - Wyjście z programu");
        System.out.println(addBook + " - dodanie nowej książki");
        System.out.println(printBooks + " - wyświetlenie dostępnych książek");
    }
}
