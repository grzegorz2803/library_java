package pl.politechnika.library.model;

public class Publication {
    private int year;
    private String titile;
    private String publisher;

    public Publication( String titile, String publisher,int year) {
        this.year = year;
        this.titile = titile;
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
