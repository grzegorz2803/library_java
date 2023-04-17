package pl.politechnika.library.exception;

public class DataImportException extends RuntimeException{ // klasa wyjątku dla odczytywania danych
    public DataImportException(String message) {
        super(message);
    }
}
