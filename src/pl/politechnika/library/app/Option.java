package pl.politechnika.library.app;

import pl.politechnika.library.exception.NoSuchOptionException;

enum Option {
    EXIT(0,"wyjście z programu"),
    ADD_BOOK(1,"dodanie nowej książki"),
    ADD_MAGAZINE(2, "dodanie nowego magazynu"),
    PRINT_BOOKS(3,"wyświetlenie dostępnych książek "),
    PRINT_MAGAZINES(4,"wyświetlenie dostępnych magazynów");
    private final int value;
    private final String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value+" - "+description;
    }
    static Option createFromInt(int option) throws NoSuchOptionException {
        try {
            return Option.values()[option]; //values zwraca tablicę wszytkich opcji
        } catch (ArrayIndexOutOfBoundsException e){
            throw new NoSuchOptionException("Brak opcji o id "+ option); // rzucamy własny wyjątek
        }
        }
}
