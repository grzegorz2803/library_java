package pl.politechnika.library.model;

import pl.politechnika.library.exception.PublicationAlreadyExistsException;
import pl.politechnika.library.exception.UserAlreadyExistsException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {



    private Map<String, Publication> publications = new HashMap<>();
    private Map<String, LibraryUser> users = new HashMap<>();

    public Map<String, Publication> getPublications() {
        return publications;
    }

    public Map<String, LibraryUser> getUsers() {
        return users;
    }

    public void addPublication(Publication publication){
            if(publications.containsKey(publication.getTitile())){
                throw new PublicationAlreadyExistsException("Publikacja o tym tytule już istnieje ");
            }
        publications.put(publication.getTitile(),publication);
    }
    public void addUser(LibraryUser user){
        if(users.containsKey(user.getPesel())){
            throw new UserAlreadyExistsException("Użytkownik o podanym nr Pesel juz istnieje ");
        }
        users.put(user.getPesel(),user);
    }
        public boolean removePublication(Publication pub){
           if(publications.containsValue(pub)){
               publications.remove(pub.getTitile());
               return true;
           }
            return false;
        }
}
