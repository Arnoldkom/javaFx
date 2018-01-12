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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class implAbonnement implements interAbonnement {

    Connectionabonne ca;

    private void dialog(Alert.AlertType alertType, String s) {
        Alert alert = new Alert(alertType, s);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Info");
        alert.showAndWait();
    }

    @Override
    public void insert(Abonnement m) {
        ca = new Connectionabonne();

        PreparedStatement ps;

        if (m.getNumero().equalsIgnoreCase("")) {
            dialog(Alert.AlertType.WARNING, "Saisir les valeurs dans les champs");

        } else {
            try {
                ps = ca.connect().prepareStatement("insert into abonnement values(?,?,?,?,?,?)");
                ps.setString(1, m.getNumero());
                ps.setString(2, m.getNumerocli());
                ps.setDate(3, (Date) m.getDatedebut());
                ps.setDate(4, (Date) m.getDatefin());
                ps.setString(5, m.getType());
                ps.setString(6, "");

                ps.execute();
            } catch (Exception e) {
                Logger.getLogger(implAbonnement.class.getName()).log(Level.SEVERE, null, e);
            }

        }

    }

    @Override
    public void delete(Abonnement m) {
        ca = new Connectionabonne();

        PreparedStatement ps;
        try {
            ps = ca.connect().prepareStatement("delete from abonnement where numero = ?");
            ps.setString(1, m.getNumero());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(implAbonnement.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public void update(Abonnement m) {
        ca = new Connectionabonne();

        PreparedStatement ps;
        try {
            ps = ca.connect().prepareStatement("update abonnement set numero=?, datedebut=?, datefin=?, type=? where numero = ?");
            ps.setString(1, m.getNumero());

            ps.setDate(2, (Date) m.getDatedebut());
            ps.setDate(3, (Date) m.getDatefin());
            ps.setString(4, m.getType());

            ps.setString(5, m.getNumero());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(implAbonnement.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public ObservableList<Abonnement> getAll(String a1) {
        ca = new Connectionabonne();
        ObservableList<Abonnement> listData = FXCollections.observableArrayList();
        try {
            String sql = "select * from abonnement where numerocli = '" + a1 + "'";
            ResultSet rs = ca.connect().createStatement().executeQuery(sql);
            while (rs.next()) {
                Abonnement m = new Abonnement();

                m.setNumero(rs.getString(1));
                m.setNumerocli(rs.getString(2));
                m.setDatedebut(rs.getDate(3));
                m.setDatefin(rs.getDate(4));
                m.setType(rs.getString(5));
                m.setTest(rs.getString(6));
                listData.add(m);
            }
        } catch (Exception ex) {
            Logger.getLogger(implAbonnement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }

    @Override
    public ObservableList<Abonnement> getAlldate() {
        ca = new Connectionabonne();
        ObservableList<Abonnement> listData = FXCollections.observableArrayList();
        try {
            String sql = "select * from abonnement";
            ResultSet rs = ca.connect().createStatement().executeQuery(sql);
            while (rs.next()) {
                Abonnement m = new Abonnement();

                m.setNumero(rs.getString(1));
                m.setNumerocli(rs.getString(2));
                m.setDatedebut(rs.getDate(3));
                m.setDatefin(rs.getDate(4));
                m.setType(rs.getString(5));
                m.setTest(rs.getString(6));
                listData.add(m);
            }
        } catch (Exception ex) {
            Logger.getLogger(implAbonnement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }

    @Override
    public ObservableList<Abonnement> likeByNama(String a) {
        ca = new Connectionabonne();
        ObservableList<Abonnement> listData = FXCollections.observableArrayList();

        try {
            String sql = "select * from abonnement where type like '%" + a + "%'";
            ResultSet rs = ca.connect().createStatement().executeQuery(sql);
            while (rs.next()) {
                Abonnement m = new Abonnement();

                m.setNumero(rs.getString(1));
                m.setNumerocli(rs.getString(2));
                m.setDatedebut(rs.getDate(3));
                m.setDatefin(rs.getDate(4));
                m.setType(rs.getString(5));
                m.setTest(rs.getString(6));
                listData.add(m);
            }
        } catch (Exception ex) {
            Logger.getLogger(implAbonnement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;

    }

}
