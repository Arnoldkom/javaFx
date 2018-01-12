/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Arnoldkom
 */
public class RetardModel {

    private final StringProperty telephone = new SimpleStringProperty();
        private final StringProperty nom = new SimpleStringProperty();
private final StringProperty abonnement = new SimpleStringProperty();
    private final StringProperty temps = new SimpleStringProperty();

    public StringProperty getAbonnementProperty() {
        return abonnement;
    }
    
    public String getAbonnement(){
       return abonnement.get();
    }
    
    public void setAbonnement(String abonnement){
        this.abonnement.set(abonnement);
    }
    
    
    public String getTelephone(){
        return telephone.get();
    }
    
    public void setTelephone(String telephon){
        this.telephone.set(telephon);
    }
    
    public StringProperty getTelephoneProperty() {
        return telephone;
    }
    
    public String getNom(){
        return nom.get();
    }
    
    public void setNom(String nom1){
        this.nom.set(nom1);
    }

    public StringProperty getNomProperty() {
        return nom;
    }
    
    public String getTemps(){
        return temps.get();
    }
    
    public void setTemps(String temp){
        this.temps.set(temp);
    }

    public StringProperty getTempsProperty() {
        return temps;
    }

    
    
    
}
