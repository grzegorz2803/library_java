package pl.politechnika.library.io.file;


import pl.politechnika.library.io.ConsolPrinter;
import pl.politechnika.library.io.DataReader;


public class FileManagerBulider {
    private final ConsolPrinter printer;
    private final DataReader reader;

    public FileManagerBulider(ConsolPrinter printer, DataReader reader) {
        this.printer = printer;
        this.reader = reader;
    }
    public FileMenager build(){
        printer.printLine("Wybierz format danych: ");
     FileType fileType = getFileType();
        return switch (fileType) {
            case SERIAL -> new SerializableFileManager();
            case CSV -> new CsvFileManager();
        };
    }

    private FileType getFileType() {  // metoda do pobierania typu pliku od użytkownika oraz zabezpieczenie przez rzucaniem wyjatków
        boolean typeOk = false;
        FileType result = null;
        do{
            printTypes();
            String type = reader.getString().toUpperCase();
            try{
                result = FileType.valueOf(type);
                typeOk = true;
            }catch (IllegalArgumentException e)
            {
             printer.printLine("Nieobsługiwany typ danych wybierz ponownie");
            }
        }while (!typeOk);
        return result;
    }

    private void printTypes() { // metoda która wyświetla dostępne formaty zapisu i odczytu
        for (FileType value : FileType.values()) {
            printer.printLine(value.name());
        }
    }
}
