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
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Abonnement {

    private final StringProperty numero = new SimpleStringProperty();
    private final StringProperty numerocli = new SimpleStringProperty();
    private final StringProperty type = new SimpleStringProperty();
    private final StringProperty test = new SimpleStringProperty();
    private final ObjectProperty<Date> datedebut = new SimpleObjectProperty<>();
    private final ObjectProperty<Date> datefin = new SimpleObjectProperty<>();
    private String formatDated;
    private String formatDatef;

    public Abonnement() {

    }

    public String getNumero() {
        return numero.get();
    }

    public void setNumero(String numero1) {
        numero.set(numero1);
    }

    public StringProperty getNumeroProperty() {
        return numero;
    }

    public String getNumerocli() {
        return numerocli.get();
    }

    public void setNumerocli(String numerocli1) {
        numerocli.set(numerocli1);
    }

    public StringProperty getNumerocliProperty() {
        return numerocli;
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type1) {
        type.set(type1);
    }

    public StringProperty getTypeProperty() {
        return type;
    }

    public Date getDatedebut() {
        return datedebut.get();
    }

    public void setDatedebut(Date debut) {
        datedebut.set(debut);
    }

    public ObjectProperty getDatedebutProperty() {
        return datedebut;
    }

    public Date getDatefin() {
        return datefin.get();
    }

    public void setDatefin(Date fin) {
        datefin.set(fin);
    }

    public ObjectProperty getDatefinProperty() {
        return datefin;
    }

    public String getFormatDatef() {
        Date tanggal = getDatefin();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
        String format = df.format(tanggal);
        return format;
    }

    public void setFormatDatef(String formatdate1) {
        this.formatDatef = formatdate1;
    }

    public String getFormatDated() {
        Date tanggal = getDatedebut();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
        String format = df.format(tanggal);
        return format;
    }

    public void setFormatDated(String formatdate1) {
        this.formatDated = formatdate1;
    }

    public String getTest() {
        return test.get();
    }

    public StringProperty getTestProperty() {
        return test;
    }

    public void setTest(String test1) {
        test.set(test1);
    }

}
