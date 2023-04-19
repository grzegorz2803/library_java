package pl.politechnika.library.io;

import pl.politechnika.library.model.Book;
import pl.politechnika.library.model.LibraryUser;
import pl.politechnika.library.model.Magazine;
import pl.politechnika.library.model.Publication;

import java.util.Collection;

public class ConsolPrinter { // klasa do wyświetlania informacji dla użytkowanika
    public  void printMagazines(Collection<Publication> publications){
        int countMagazines=0;

        for (Publication publication : publications) {
            if(publication instanceof Magazine) {
                printLine(publication.toString());
                countMagazines++;
            }
        }
        if(countMagazines==0){
            printLine("Brak magazynów do wyświetlenia");
        }
    }
    public  void printBooks(Collection<Publication> publications){  // metoda do wyświetlania książek
        int coutBooks = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                printLine(publication.toString());
                coutBooks++;
            }
        }
        if(coutBooks==0){
            printLine("Brak książek do wyświetlenia");
        }
    }
    public void printUsers(Collection<LibraryUser> users){
        for (LibraryUser user : users) {
            printLine(user.toString());
        }
    }
    public void printLine(String text){
        System.out.println(text);
    }
}
