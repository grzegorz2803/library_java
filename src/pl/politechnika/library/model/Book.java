package pl.politechnika.library.model;

public class Book extends Publication {

    private String author;
    private int pages;
   private  String isbn;
    public Book(String title, String author, int releaseDate, int pages, String publisher, String isbn){
        super(title,publisher,releaseDate); // wywołanie konstruktora z kalsy nadrzędnej
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;

    }


// getery

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }



     public void printInfo() { // Metoda do wyświetlania książek
         String info = getTitile() + "; "+author+"; "+getYear()+"; "+pages+"; "+getPublisher();
         if(isbn !=null)
             info = info + "; "+isbn;
         System.out.println(info);
    }
}
