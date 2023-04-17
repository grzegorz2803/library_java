package pl.politechnika.library.io.file;

import pl.politechnika.library.exception.NoSuchFileTypeException;
import pl.politechnika.library.io.ConsolPrinter;
import pl.politechnika.library.io.DataReader;

import java.util.Locale;


public class FileManagerBulider {
    private ConsolPrinter printer;
    private DataReader reader;

    public FileManagerBulider(ConsolPrinter printer, DataReader reader) {
        this.printer = printer;
        this.reader = reader;
    }
    public FileMenager build(){
        printer.printLine("Wybierz format danych: ");
     FileType fileType = getFileType();
     switch (fileType){

         case SERIAL:
             return new SerializableFileManager();
         case CSV:
             return new CsvFileManager();
         default:
             throw new NoSuchFileTypeException("Nieobsługiwany typ danych");
     }
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
