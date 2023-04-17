package pl.politechnika.library.exception;

public class NoSuchOptionException extends Exception { // własna klasa wyjątku do obsługi opcji poza zakresem
    public NoSuchOptionException(String message) {
        super(message);
    }
}
