package pl.politechnika.library.exception;

public class DataExportException extends RuntimeException { // klasa wyjątku dla zapisywania danych
    public DataExportException(String message) {
        super(message);
    }
}
