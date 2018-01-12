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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class Abonne {
    private final StringProperty identifiant = new SimpleStringProperty();
    private final StringProperty nom = new SimpleStringProperty();
    private final StringProperty tel = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final StringProperty autre = new SimpleStringProperty();
    private final StringProperty test = new SimpleStringProperty();
    public Abonne(){
        
    }
public String getIdentifiant(){
    return identifiant.get();
}
    public StringProperty getIdentifiantProperty() {
        return identifiant;
    }
 public void setIdentifiant(String id1){
        this.identifiant.set(id1);
    }
   
public String getNom(){
    return nom.get();
}
    public StringProperty getNomProperty() {
        return nom;
    }
    public void setNom(String nom1){
        nom.set(nom1);
    }
public String getTel(){
    return tel.get();
}
    public StringProperty getTelProperty() {
        return tel;
    }
public void setTel(String tel1){
    tel.set(tel1);
}
public String getEmail(){
    return email.get();
}
    public StringProperty getEmailProperty() {
        return email;
    }
public void setEmail(String email1){
    email.set(email1);
}

public String getAutre(){
    return autre.get();
}
    public StringProperty getAutreProperty() {
        return autre;
    }
    public void setAutre(String autre1){
        autre.set(autre1);
    }
public String getTest(){
    return test.get();
}
    public StringProperty getTestProperty() {
        return test;
    }
   public void setTest(String test1){
       test.set(test1);
   }
}
