package pl.politechnika.library.model;

import java.util.Objects;

public abstract class Publication {
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

    @Override
    public String toString() {
        return titile+"; "+publisher+"; "+year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return year == that.year && Objects.equals(titile, that.titile) && Objects.equals(publisher, that.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, titile, publisher);
    }
}
