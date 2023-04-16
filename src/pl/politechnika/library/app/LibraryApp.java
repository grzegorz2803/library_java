package pl.politechnika.library.app;
// klasa do uruchamiania aplikacji z metodą main
 class LibraryApp {
     public static void main(String[] args) {
         final String appName = "Biblioteka";
         System.out.println(appName);
         LibraryControl libControl = new LibraryControl();
         libControl.controlLoop();

     }

}
