package pl.politechnika.library.io;

import pl.politechnika.library.model.Book;

import java.util.Scanner;

public  class DataReader {
     private Scanner sc = new Scanner(System.in); // prywatne pole obiektu Scanner do wczytywania danych z klawiatury
      public Book readAndCreateBook(){ // metoda odpowiedzialna za pobieranie danych z klawiatury
         System.out.println("Tytuł: ");
         String title = sc.nextLine();
         System.out.println("Autor: ");
         String author = sc.nextLine();
         System.out.println("Wydawnictwo: ");
         String publisher = sc.nextLine();
         System.out.println("ISBN: ");
         String isbn = sc.nextLine();
         System.out.println("Rok wydania: ");
         int relaseDate = sc.nextInt();
         sc.nextLine(); // pobieramy znak entera aby nie przeskoczyło o jedną linię i nie zgubic danych
         System.out.println("Liczba stron: ");
         int pages = sc.nextInt();
         sc.nextLine();
         return new Book(title,author,relaseDate,pages,publisher,isbn); // zwaracamy obiekt typu Book
     }
     public int getInt(){
         int number =  sc.nextInt();
          sc.nextLine();
          return  number;
     }
     public  void  close(){ // metoda zamykająca strumień skanera
         sc.close();
     }
}
