package pl.politechnika.library.io;

import pl.politechnika.library.model.Book;
import pl.politechnika.library.model.LibraryUser;
import pl.politechnika.library.model.Magazine;

import java.util.Scanner;

public  class DataReader {
     private Scanner sc = new Scanner(System.in); // prywatne pole obiektu Scanner do wczytywania danych z klawiatury
    private ConsolPrinter printer;

    public DataReader(ConsolPrinter printer) {
        this.printer = printer;
    }

    public Book readAndCreateBook(){ // metoda odpowiedzialna za pobieranie danych z klawiatury
         printer.printLine("Tytuł: ");
         String title = sc.nextLine();
         printer.printLine("Autor: ");
         String author = sc.nextLine();
         printer.printLine("Wydawnictwo: ");
         String publisher = sc.nextLine();
         printer.printLine("ISBN: ");
         String isbn = sc.nextLine();
         printer.printLine("Rok wydania: ");
         int relaseDate = getInt();
         printer.printLine("Liczba stron: ");
         int pages = getInt();
         return new Book(title,author,relaseDate,pages,publisher,isbn); // zwaracamy obiekt typu Book
     }
    public Magazine readAndCreateMagazine(){ // metoda odpowiedzialna za pobieranie danych z klawiatury
        printer.printLine("Tytuł: ");
        String title = sc.nextLine();
        printer.printLine("Wydawnictwo: ");
        String publisher = sc.nextLine();
        printer.printLine("Język: ");
        String language = sc.nextLine();
        printer.printLine("Rok wydania: ");
        int year = getInt();
        printer.printLine("Miesiąc: ");
        int month = getInt();
        printer.printLine("Dzień: ");
        int day = getInt();
        return new Magazine(title,publisher,language,year,month,day);
    }
    public LibraryUser createLibraryUser(){
        printer.printLine("Imię: ");
        String firstName = sc.nextLine();
        printer.printLine("Nazwisko: ");
        String lastName = sc.nextLine();
        printer.printLine("Pesel: ");
        String pesel = sc.nextLine();
        return  new LibraryUser(firstName,lastName,pesel);
    }
     public int getInt(){ // metoda pomocnicza do pobierania int od użytkownaika aby nie trzeba było za każdym razem usuwać enter
         try {
             return sc.nextInt();
         }finally { // to się zawsze wykona
             sc.nextLine();
         }
     }
     public String getString(){
        return sc.nextLine();
     }

     public  void  close(){ // metoda zamykająca strumień skanera
         sc.close();
     }
}
