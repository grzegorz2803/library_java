package pl.politechnika.library.model;

import java.io.Serializable;
import java.util.Arrays;

public class Library implements Serializable {

    private static final int INITLIAL_CAPACITY = 1; // maksymalna liczba publikacji
    private int publicationsNumber = 0; // aktualna liczba publikacji
    private Publication[] publications = new Publication[INITLIAL_CAPACITY]; // tablica do przechowywania publikacji

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationsNumber];
        for (int i = 0; i<result.length;i++){
            result[i]=publications[i];
        }
        return result;
    }



    public void addPublication(Publication publication){
        if(publicationsNumber==publications.length){
            publications = Arrays.copyOf(publications, publications.length*2);
        }
        publications[publicationsNumber]=publication;
        publicationsNumber++;
    }
        public boolean removePublication(Publication pub){
            final int notFound= -1;
            int found = notFound;
            int i=0;
            while (i<publicationsNumber&&found==notFound){
                if (pub.equals(publications[i])){
                    found=i;
                }else {
                    i++;
                }
            }
            if (found!=notFound){
                System.arraycopy(publications,found+1,publications,found,publications.length-1);
                publicationsNumber--;
                publications[publicationsNumber]=null;
            }
            return found!=notFound;
        }
}
