package pl.politechnika.library.model;

public class Library {
    private final int maxBooks = 1000; // maksymalna ilość książek
    private Book[] books = new Book[maxBooks]; // tablica do przechowywania książek
    private int booksNumber = 0; // ilość książek wprowadzonych
    public void addBook(Book book){  // metoda do dodawania książek
        if(booksNumber<maxBooks){ // sprawdzamy czy jest jeszcze miejsce
            books[booksNumber] = book;
            booksNumber++;
        }else {
            System.out.println("Osiągnięto maksymalną liczbę książek ");
        }

    }
    public  void printBooks(){  // metoda do wyświetlania książek
        if(booksNumber==0){
            System.out.println("Brak książek do wyświetlenia");
        }
        for (int i=0;i<booksNumber;i++) {
            books[i].printInfo();
        }
    }
}
