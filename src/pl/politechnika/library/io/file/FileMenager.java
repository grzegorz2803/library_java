package pl.politechnika.library.io.file;

import pl.politechnika.library.model.Library;

 interface FileMenager { // interfejs do obsługi plików
    Library importData();
    void exportData(Library library);
}
