/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Arnoldkom
 */
import javafx.collections.ObservableList;

public interface interAbonne {
    void insert(Abonne m);
    void delete(Abonne m);
    void update(Abonne m);
    void updatetest(String m);
    ObservableList<Abonne> getAll();
    
     ObservableList<Abonne> getAlluser(String a);
    ObservableList<Abonne> likeByNama(String a);
   
}
