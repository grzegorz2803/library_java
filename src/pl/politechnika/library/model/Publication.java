package pl.politechnika.library.model;

import java.io.Serializable;
import java.time.Year;
import java.util.Objects;

public abstract class Publication implements Serializable, Comparable<Publication>, CsvConvertible {
    private final Year year;
    private final String titile;
    private final String publisher;

    public Publication( String titile, String publisher,int year) {
        this.year = Year.of(year);
        this.titile = titile;
        this.publisher = publisher;
    }

    public Year getYear() {
        return year;
    }



    public String getTitile() {
        return titile;
    }



    public String getPublisher() {
        return publisher;
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
        return Objects.equals(year, that.year) && Objects.equals(titile, that.titile) && Objects.equals(publisher, that.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, titile, publisher);
    }


    @Override
    public int compareTo(Publication o) {
        return titile.compareToIgnoreCase(o.titile);
    }
}

