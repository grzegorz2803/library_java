package pl.politechnika.library.app;

import pl.politechnika.library.io.DataReader;
import pl.politechnika.library.model.Book;

import java.util.Scanner;

class Library {
    public static void main(String[] args){
        final String appName= "Biblioteka v0.2";
        Book[] books = new Book[1000];
        DataReader dataReader = new DataReader(); // tworzymy obiekt klasy DataReader odpowiedzialnej za pobieranie danych od użytkownika
        books[0] = dataReader.readAndCreateBook();
        books[1] = dataReader.readAndCreateBook();
        dataReader.close();
        System.out.println(appName);
        System.out.println("Książki dostępne w bibliotece");
        books[0].printInfo();
        books[1].printInfo();

    }
}
