package pl.politechnika.library.io;

import pl.politechnika.library.model.Book;
import pl.politechnika.library.model.Magazine;
import pl.politechnika.library.model.Publication;

public class ConsolPrinter { // klasa do wyświetlania informacji dla użytkowanika
    public  void printMagazines(Publication[] publications){
        int countMagazines=0;

        for (Publication publication : publications) {
            if(publication instanceof Magazine) {
                System.out.println(publication);
                countMagazines++;
            }
        }
        if(countMagazines==0){
            printLine("Brak magazynów do wyświetlenia");
        }
    }
    public  void printBooks(Publication[] publications){  // metoda do wyświetlania książek
        int coutBooks = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                System.out.println(publication);
                coutBooks++;
            }
        }
        if(coutBooks==0){
            printLine("Brak książek do wyświetlenia");
        }
    }
    public void printLine(String text){
        System.out.println(text);
    }
}
