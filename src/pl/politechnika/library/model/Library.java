package pl.politechnika.library.model;

import java.io.Serializable;

public class Library implements Serializable {

    private static final int MAX_PUBLICATION = 2000; // maksymalna liczba publikacji
    private int publicationsNumber = 0; // aktualna liczba publikacji
    private Publication[] publications = new Publication[MAX_PUBLICATION]; // tablica do przechowywania publikacji

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationsNumber];
        for (int i = 0; i<result.length;i++){
            result[i]=publications[i];
        }
        return result;
    }

    public void addBook(Book book){  // metoda do dodawania książek
     addPublication(book);
    }


    public void addMagazine(Magazine magazine){
     addPublication(magazine);

    }

    private void addPublication(Publication publication){
        if(publicationsNumber>=MAX_PUBLICATION){
            throw  new ArrayIndexOutOfBoundsException("Osiągnięto maksymalną liczbę publikacji " + MAX_PUBLICATION);
        }
        publications[publicationsNumber]=publication;
        publicationsNumber++;
    }

}
