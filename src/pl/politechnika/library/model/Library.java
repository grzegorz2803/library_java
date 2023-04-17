package pl.politechnika.library.model;

public class Library {

    private static final int MAX_PUBLICATION = 2000;
    private int publicationsNumber = 0;
    private Publication[] publications = new Publication[MAX_PUBLICATION];

    public void addBook(Book book){  // metoda do dodawania książek
        if(publicationsNumber< MAX_PUBLICATION){ // sprawdzamy czy jest jeszcze miejsce
            publications[publicationsNumber] = book;
            publicationsNumber++;
        }else {
            System.out.println("Osiągnięto maksymalną liczbę książek ");
        }

    }
    public  void printBooks(){  // metoda do wyświetlania książek
       int coutBooks = 0;
        for (int i=0;i<publicationsNumber;i++) {
            if(publications[i] instanceof Book) {
                System.out.println(publications[i]);
                coutBooks++;
            }
        }
        if(coutBooks==0){
            System.out.println("Brak książek do wyświetlenia");
        }
    }

    public void addMagazine(Magazine magazine){
        if(publicationsNumber< MAX_PUBLICATION){
            publications[publicationsNumber]=magazine;
            publicationsNumber++;
        }else {
            System.out.println("Osiągnięto maksymalną liczbę magazynów ");
        }

    }

    public  void printMagazines(){
        int countMagazines=0;
        for (int i=0;i<publicationsNumber;i++) {
            if(publications[i] instanceof Magazine ) {
                System.out.println(publications[i]);
                countMagazines++;
            }
        }
        if(countMagazines==0){
            System.out.println("Brak magazynów do wyświetlenia");
        }
    }
}
