package pl.politechnika.library.app;

import pl.politechnika.library.io.DataReader;
import pl.politechnika.library.model.Book;
import pl.politechnika.library.model.Library;
import pl.politechnika.library.model.Magazine;

public class LibraryControl {

    // obiekty klasy dataReader do wczytywania dancyh oraz klasy biblioteka
    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    // główna pętla aplikacji z możliwością wyboru opcji
    public void controlLoop(){
        Option option;
        do{
            printOption();
            option = Option.createFromInt(dataReader.getInt());
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
        }while (option != Option.EXIT);
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
        for (Option value : Option.values()) {
            System.out.println(value);
        }

    }
}
