package pl.politechnika.library.model;

import pl.politechnika.library.exception.PublicationAlreadyExistsException;
import pl.politechnika.library.exception.UserAlreadyExistsException;

import java.io.Serializable;
import java.util.*;

public class Library implements Serializable {



    private final Map<String, Publication> publications = new HashMap<>();
    private final Map<String, LibraryUser> users = new HashMap<>();

    public Map<String, Publication> getPublications() {
        return publications;
    }
    public Collection<Publication> getSortedPublication(Comparator<Publication> comparator){
     List<Publication> list = new ArrayList<>(publications.values());
     list.sort(comparator);
     return list;

    }

    public Map<String, LibraryUser> getUsers() {
        return users;
    }
    public Collection<LibraryUser> getSortedUsers(Comparator<LibraryUser> comparator){
        ArrayList<LibraryUser> list = new ArrayList<>(users.values());
        list.sort(comparator);
        return list;
    }
    public Optional<Publication> findPublicationByTitle(String title){
        return  Optional.ofNullable(publications.get(title));
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
