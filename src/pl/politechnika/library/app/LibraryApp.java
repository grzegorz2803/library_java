package pl.politechnika.library.app;
// klasa do uruchamiania aplikacji z metodą main
// opcje na przyszłość do rozwinięcia
// 1- usuwanie ksiązki po isbn
// 2 - usuwanie użytkowników  na podstawie peselu
// 3 - dodawanie i logowanie pracowników
// 4 - wyświetlanie historii wyporzyczeń
// 5  - wyświetlanie wyporzyczonych książek przez danego użytkownika na podstawie peselu
// 6 - dodawanie stanu magazynowego książki i poprawa logiki wyporzyczeń i oddawania
// 7 - dodanie sortowania
 class LibraryApp {
    private static final String APP_NAME = "Biblioteka";
     public static void main(String[] args) {

         System.out.println(APP_NAME);
         LibraryControl libControl = new LibraryControl();
         libControl.controlLoop();

     }

}
