package pl.politechnika.library.model;

import java.time.MonthDay;
import java.util.Objects;

public class Magazine extends Publication{
    public static final String TYPE = "Magazyn";
    private final MonthDay montDay;
    private final String language;

    public Magazine(String title, String publisher, String language, int year, int month, int day) {
        super(title,publisher,year);

        this.language = language;
        montDay = MonthDay.of(month,day);
    }

    @Override
    public String toCsv() {
        return TYPE +";"+
                getTitile()+";"+
                getPublisher()+";"+
                getYear()+";"+
                montDay.getMonthValue()+";"+
                montDay.getDayOfMonth()+";"+
                language;
    }
    @Override
    public String toString() {
        return super.toString()+"; "+montDay.getMonthValue()+"; "+montDay.getDayOfMonth()+"; "+language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(montDay, magazine.montDay) && Objects.equals(language, magazine.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), montDay, language);
    }
}
