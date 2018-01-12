/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.ObservableList;

/**
 *
 * @author Arnoldkom
 */
public interface interAbonnement {
        void insert(Abonnement m);
    void delete(Abonnement m);
    void update(Abonnement m);
    ObservableList<Abonnement> getAll(String a);
    ObservableList<Abonnement> getAlldate();
    ObservableList<Abonnement> likeByNama(String a);
}
