package pl.politechnika.library.model;

public class Library {
    private static final int MAX_BOOKS = 1000; // maksymalna ilość książek
    private static final int MAX_MAGAZINE = 1000;
    private Book[] books = new Book[MAX_BOOKS]; // tablica do przechowywania książek
    private Magazine[] magazins = new Magazine[MAX_MAGAZINE];
    private int booksNumber = 0; // ilość książek wprowadzonych
    private int magazinsNumber = 0;
    public void addBook(Book book){  // metoda do dodawania książek
        if(booksNumber< MAX_BOOKS){ // sprawdzamy czy jest jeszcze miejsce
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

    public void addMagazine(Magazine magazine){
        if(magazinsNumber< MAX_MAGAZINE){
            magazins[magazinsNumber]=magazine;
            magazinsNumber++;
        }else {
            System.out.println("Osiągnięto maksymalną liczbę magazynów ");
        }

    }

    public  void printMagazines(){
        if(magazinsNumber==0){
            System.out.println("Brak książek do wyświetlenia");
        }
        for (int i=0;i<magazinsNumber;i++) {
            magazins[i].printInfo();
        }
    }
}
