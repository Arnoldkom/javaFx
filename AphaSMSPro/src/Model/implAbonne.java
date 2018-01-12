/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
/**
 *
 * @author Arnoldkom
 */
public class implAbonne implements interAbonne{

    Connectionabonne ca;
    
    private void dialog(Alert.AlertType alertType,String s){
        Alert alert = new Alert(alertType,s);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Info");
        alert.showAndWait();
    }
    
    @Override
    public void insert(Abonne m) {
   ca = new Connectionabonne();
   
   PreparedStatement ps;
   if (m.getIdentifiant().equalsIgnoreCase("")){
        dialog(Alert.AlertType.WARNING, "Saisir les valeurs dans les champs");
       
   }else {
        try {
            ps = ca.connect().prepareStatement("insert into abonne values(?,?,?,?,?,?)");
            ps.setString(1, m.getIdentifiant());
            ps.setString(2, m.getNom());
            ps.setString(3, m.getTel());
             ps.setString(4, m.getEmail());
            ps.setString(5, m.getAutre());
             ps.setString(6, "");
           
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(implAbonne.class.getName()).log(Level.SEVERE, null, e);
        }
   }
       
    }

    @Override
    public void delete(Abonne m) {
   ca = new Connectionabonne();
   
   PreparedStatement ps;
     try {
            ps = ca.connect().prepareStatement("delete from abonne where idetifiant = ?");
            ps.setString(1, m.getIdentifiant());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(implAbonne.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Abonne m) {
   ca = new Connectionabonne();
   
   PreparedStatement ps;
     try {
            ps = ca.connect().prepareStatement("update abonne set idetifiant=?, nom=?, telephone=?, email=?, autre=? where idetifiant = ?");
            ps.setString(1, m.getIdentifiant());
          
            ps.setString(2, m.getNom());
            ps.setString(3, m.getTel());
            ps.setString(4, m.getEmail());
            ps.setString(5, m.getAutre());
              ps.setString(6, m.getIdentifiant());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(implAbonne.class.getName()).log(Level.SEVERE, null, e);
        }
    }
     public void updatetest(String m) {
   ca = new Connectionabonne();
   
   PreparedStatement ps;
     try {
            ps = ca.connect().prepareStatement("update abonne set test=? where idetifiant = ?");
            ps.setString(1, m);
          
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(implAbonne.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public ObservableList<Abonne> getAll() {
         ca = new Connectionabonne();
    ObservableList<Abonne> listData = FXCollections.observableArrayList();
        try {
            String sql = "select * from abonne";
            ResultSet rs = ca.connect().createStatement().executeQuery(sql);
            while (rs.next()) {   
                Abonne m = new Abonne();
               
                m.setIdentifiant(rs.getString(1));
                m.setNom(rs.getString(2));
                m.setTel(rs.getString(3));
                 m.setEmail(rs.getString(4));
                m.setAutre(rs.getString(5));
                  m.setTest(rs.getString(6));
                listData.add(m);
            }
        } catch (Exception ex) {
            Logger.getLogger(implAbonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    
    }
   
     @Override
    public ObservableList<Abonne> getAlluser(String a2) {
         ca = new Connectionabonne();
    ObservableList<Abonne> listData = FXCollections.observableArrayList();
        try {
            String sql = "select * from abonne where idetifiant = '"+a2+"'";
            ResultSet rs = ca.connect().createStatement().executeQuery(sql);
            while (rs.next()) {   
                Abonne m = new Abonne();
               
                m.setIdentifiant(rs.getString(1));
                m.setNom(rs.getString(2));
                m.setTel(rs.getString(3));
                 m.setEmail(rs.getString(4));
                m.setAutre(rs.getString(5));
                  m.setTest(rs.getString(6));
                listData.add(m);
            }
        } catch (Exception ex) {
            Logger.getLogger(implAbonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    
    }

    @Override
    public ObservableList<Abonne> likeByNama(String a) {
   
         ca = new Connectionabonne();
    ObservableList<Abonne> listData = FXCollections.observableArrayList();
    
     try {
            String sql = "select * from abonne where nom like '%"+a+"%'";
            ResultSet rs = ca.connect().createStatement().executeQuery(sql);
            while (rs.next()) {   
                Abonne m = new Abonne();
                 
                 m.setIdentifiant(rs.getString(1));
                m.setNom(rs.getString(2));
                m.setTel(rs.getString(3));
                 m.setEmail(rs.getString(4));
                m.setAutre(rs.getString(5));
                  m.setTest(rs.getString(6));
                listData.add(m);
            }
        } catch (Exception ex) {
            Logger.getLogger(implAbonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }

   
    
}
