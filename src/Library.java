 class Library {
    public static void main(String[] args){
        final String appName= "Biblioteka v0.2";
        Book book1 = new Book("W pustyni i puszczy", "Henryk Sienkiewicz", 2010, 296, "Greg","88996456+465646");
        Book book2 = new Book("Java. Efektywne programowanie", "Nieznany", 2009, 352, "Helion","88945454456+465646");
        Book book3 = new Book("Dziady", "Adam Mickiewicz", 2000, 203, "Sowa");

        System.out.println(appName);
        System.out.println("Książki dostępne w bibliotece");
        book1.printInfo();
        book2.printInfo();
        book3.printInfo();
    }
}
