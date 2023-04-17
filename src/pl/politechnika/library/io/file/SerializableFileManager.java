package pl.politechnika.library.io.file;

import pl.politechnika.library.exception.DataExportException;
import pl.politechnika.library.exception.DataImportException;
import pl.politechnika.library.model.Library;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;

public class SerializableFileManager implements FileMenager{
    private static final String FILE_NAME = "Library.o";
    @Override // metoda odczytująca dane z pliku
    public Library importData() {

        try( FileInputStream fis = new FileInputStream(FILE_NAME); // taki zapis try odrazu po wykonaniu zamyka strumienie
             ObjectInputStream ois = new ObjectInputStream(fis);) {

            return (Library)ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku "+ FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Błąd odczytu pliku "+ FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Niezgodny typ danych");
        }

    }

    @Override // metoda zapisująca dane do pliku
    public void exportData(Library library) {
        try(FileOutputStream fos= new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);) {

            oos.writeObject(library);
        } catch (FileNotFoundException e) {
            throw new DataExportException("Brak pliku " +FILE_NAME);
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu danych do pliku  " +FILE_NAME);
        }


    }
}
