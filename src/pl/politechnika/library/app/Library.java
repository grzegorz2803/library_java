package pl.politechnika.library.app;

import pl.politechnika.library.model.Book;

class Library {
    public static void main(String[] args){
        final String appName= "Biblioteka v0.2";
        Book[] books = new Book[1000];
       books[0] = new Book("W pustyni i puszczy", "Henryk Sienkiewicz", 2010, 296, "Greg","88996456+465646");
        books[1] = new Book("Java. Efektywne programowanie", "Nieznany", 2009, 352, "Helion","88945454456+465646");
        books[2] = new Book("Dziady", "Adam Mickiewicz", 2000, 203, "Sowa");

        System.out.println(appName);
        System.out.println("Książki dostępne w bibliotece");
        books[0].printInfo();
        books[1].printInfo();
        books[2].printInfo();
    }
}
