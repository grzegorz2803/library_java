package pl.politechnika.library.app;
// klasa do uruchamiania aplikacji z metodą main
 class LibraryApp {
    private static final String APP_NAME = "Biblioteka";
     public static void main(String[] args) {

         System.out.println(APP_NAME);
         LibraryControl libControl = new LibraryControl();
         libControl.controlLoop();

     }

}
