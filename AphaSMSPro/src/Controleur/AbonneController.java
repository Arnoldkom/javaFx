/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/**
 *
 * @author Arnoldkom
 */
import Model.Abonne;
import Model.Abonnement;
import Model.RetardModel;
import Model.implAbonne;
import Model.implAbonnement;
import Model.interAbonne;
import Model.interAbonnement;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.fontawesome.AwesomeDude;
import de.jensd.fx.fontawesome.AwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class AbonneController implements Initializable {

    public static Stage themeWindow2;

//      @FXML
//    private JFXButton rappel;
//      @FXML
//    private JFXButton rappel1;
    @FXML
    private JFXTextField numero;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField tel;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField autre;
    @FXML
    private JFXTextField recherche;
    @FXML
    private TableView<Abonne> tabuser;
    @FXML
    private TableView<RetardModel> tab3;
    @FXML
    private TableColumn<RetardModel, String> colnom2;
    @FXML
    private TableColumn<RetardModel, String> colabonnement2;
    @FXML
    private TableColumn<RetardModel, String> coltel2;
    @FXML
    private TableColumn<RetardModel, String> coljour;
    
    @FXML
    private TableView<Abonnement> tab2;
    @FXML
    private TableColumn<Abonne, String> colid;
    @FXML
    private TableColumn<Abonne, String> colnumero;
    @FXML
    private TableColumn<Abonne, String> colnom;
    @FXML
    private TableColumn<Abonne, String> coltelephone;
    @FXML
    private TableColumn<Abonne, String> colemail;
    @FXML
    private TableColumn<Abonne, String> colautre;
    @FXML
    private TableColumn colaction;
//    @FXML
//    private JFXButton accueil;
//     @FXML
//    private JFXButton abonne;
//     @FXML
//    private JFXButton parametre;
//     @FXML
//    private JFXButton aide;
//     @FXML
//    private JFXButton close;
    @FXML
    private JFXButton cancel2;
    @FXML
    private JFXButton valide2;

    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;

    public double x = 0;
    public double y = 0;
    public static String transfert = "";
    public static String transfert2 = "";
    interAbonne crudData = new implAbonne();
    interAbonne testUser = new implAbonne();
    interAbonnement testdate = new implAbonnement();
    ObservableList<Abonne> listData;
    ObservableList<Abonne> listuser;
    ObservableList<Abonnement> listDate;
    private String StatusKode, statusKlik;
    ObservableList<Abonne> listDelete;
    ObservableList<RetardModel> list1;
    ObservableList<RetardModel> list2;
    ObservableList<RetardModel> list3   ;
    
    

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pane1.toFront();
        System.out.println(transfert);
        colnumero.setCellValueFactory(
                (TableColumn.CellDataFeatures<Abonne, String> cellData)
                -> cellData.getValue().getIdentifiantProperty());
        colnom.setCellValueFactory(
                (TableColumn.CellDataFeatures<Abonne, String> cellData)
                -> cellData.getValue().getNomProperty());
        coltelephone.setCellValueFactory(
                (TableColumn.CellDataFeatures<Abonne, String> cellData)
                -> cellData.getValue().getTelProperty());
        colemail.setCellValueFactory(
                (TableColumn.CellDataFeatures<Abonne, String> cellData)
                -> cellData.getValue().getEmailProperty());
        colautre.setCellValueFactory(
                (TableColumn.CellDataFeatures<Abonne, String> cellData)
                -> cellData.getValue().getAutreProperty());
        
        colaction.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Object, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Object, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        colaction.setCellFactory(new Callback<TableColumn<Object, Boolean>, TableCell<Object, Boolean>>() {
            @Override
            public TableCell<Object, Boolean> call(TableColumn<Object, Boolean> p) {
                return new ButtonCell(tabuser);
            }
        });

        colnom2.setCellValueFactory(
                (TableColumn.CellDataFeatures<RetardModel, String> cellData)
                -> cellData.getValue().getNomProperty());
        coltel2.setCellValueFactory(
                (TableColumn.CellDataFeatures<RetardModel, String> cellData)
                -> cellData.getValue().getTelephoneProperty());
        colabonnement2.setCellValueFactory(
                (TableColumn.CellDataFeatures<RetardModel, String> cellData)
                -> cellData.getValue().getAbonnementProperty());
        coljour.setCellValueFactory(
                (TableColumn.CellDataFeatures<RetardModel, String> cellData)
                -> cellData.getValue().getTempsProperty());
        
        
        list1 = FXCollections.observableArrayList();
        list2 = FXCollections.observableArrayList();
        list3 = FXCollections.observableArrayList();
        listData = FXCollections.observableArrayList();
        AwesomeDude.setIcon(valide2, AwesomeIcon.CHECK_SQUARE, "15px");
        AwesomeDude.setIcon(cancel2, AwesomeIcon.CHAIN_BROKEN, "15px");
        StatusKode = "0";
        statusKlik = "0";
        tampilData();
        voirreste();
        System.out.println(transfert);
        tabuser.getSelectionModel().clearSelection();
        tab3.getSelectionModel().clearSelection();
    }

    private void dialog(Alert.AlertType alertType, String s) {
        Alert alert = new Alert(alertType, s);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Info");
        alert.showAndWait();
    }

    private void clear() {
        numero.clear();
        nom.clear();
        email.clear();
        autre.clear();
        recherche.clear();
        tel.clear();
        StatusKode = "0";
    }

    private void tampilData() {
        listData = crudData.getAll();
        tabuser.setItems(listData);
    }

    @FXML
    public void btn_accueil(ActionEvent event) {
        System.out.println("le bouton de accueil fonctionne bien et parfaitement");
        pane1.toFront();

    }

    @FXML
    public void btn_zbonne(ActionEvent event) {
        System.out.println("le bouton abonne fonctionne bien et parfaitement");
pane2.toFront();
    }

    @FXML
    public void btn_parametre(ActionEvent event) {
        System.out.println("le bouton de paramettre fonctionne bien et parfaitement");

    }

    @FXML
    public void btn_rappel(ActionEvent event) {
        System.out.println("le bouton rappel sms fonctionne bien et parfaitement");
        calculDate();
    }

    @FXML
    public void btn_rappel1(ActionEvent event) {
        System.out.println("le bouton rappel sms fonctionne bien et parfaitement");
        calculDate1();
    }

    @FXML
    public void btn_aide(ActionEvent event) {
        System.out.println("le bouton d'aide fonctionne bien et parfaitement");

    }
    @FXML
    public void btn_termine(ActionEvent event) {
        System.out.println("le bouton termine fonctionne bien et parfaitement");
voirreste2();
list1.clear();
list2.clear();
    }
    @FXML
    public void btn_jour1(ActionEvent event) {
        System.out.println("le bouton jour1 fonctionne bien et parfaitement");
voirreste();
list2.clear();
list3.clear();
    }
    @FXML
    public void btn_jour2(ActionEvent event) {
        System.out.println("le bouton jour2 fonctionne bien et parfaitement");
voirreste1();
list1.clear();
list3.clear();
    }

    @FXML
    public void btn_close(ActionEvent event) {
        System.out.println("la fermeture de la fenetre fonctionne bien");
        System.exit(0);
    }

    @FXML
    public void btn_valide(ActionEvent event) {
        if (numero.getText() != "") {

            Abonne m = new Abonne();
            m.setIdentifiant(numero.getText());
            m.setNom(nom.getText());
            m.setEmail(email.getText());
            m.setAutre(autre.getText());
            m.setTel(tel.getText());

            m.setEmail(email.getText());
            if (StatusKode.equals("0")) {
                crudData.insert(m);

            } else {
                crudData.update(m);

            }
        } else {
            dialog(Alert.AlertType.WARNING, "Saisir les valeurs dans les champs");

        }
        tampilData();
        clear();

    }

    @FXML
    public void btn_annuler(ActionEvent event) {
        clear();
        tampilData();
    }

    @FXML
    private void klikTableData(MouseEvent event) {
        if (statusKlik.equals("1")) {
            StatusKode = "1";
            try {
                Abonne klik = tabuser.getSelectionModel().getSelectedItems().get(0);
                numero.setText(klik.getIdentifiant());
                nom.setText(klik.getNom());
                tel.setText(klik.getTel());
                email.setText(klik.getEmail());
                autre.setText(klik.getAutre());
            } catch (Exception e) {
            }
        }
        if (statusKlik.equals("2")) {

            start1();
        }

    }

    @FXML
    private void aksiCari(KeyEvent event) {
        listData = crudData.likeByNama(recherche.getText());
        tabuser.setItems(listData);
    }

    private class ButtonCell extends TableCell<Object, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("suprimer");
        final Hyperlink cellButtonEdit = new Hyperlink("Modifier");
        final Hyperlink cellButtonvue = new Hyperlink("view");
        final HBox hb = new HBox(cellButtonDelete, cellButtonEdit, cellButtonvue);

        ButtonCell(final TableView tblView) {

            hb.setSpacing(1);

            //cell delete
            cellButtonDelete.setOnAction((ActionEvent t) -> {
                statusKlik = "1";
                int row = getTableRow().getIndex();
                tabuser.getSelectionModel().select(row);
                klikTableData(null);
                Abonne m = new Abonne();
                m.setIdentifiant(numero.getText());
                crudData.delete(m);
                tampilData();
                clear();

                dialog(Alert.AlertType.INFORMATION, "Data Berhasil Dihapus");
                statusKlik = "0";
                StatusKode = "0";
            });

            //cell edit
            cellButtonEdit.setOnAction((ActionEvent event) -> {
                statusKlik = "1";
                int row = getTableRow().getIndex();
                tabuser.getSelectionModel().select(row);
                klikTableData(null);
                statusKlik = "0";
            });
            cellButtonvue.setOnAction((ActionEvent event) -> {
                statusKlik = "2";
                int row = getTableRow().getIndex();
                tabuser.getSelectionModel().select(row);
                Abonne kli = tabuser.getSelectionModel().getSelectedItems().get(0);
                transfert = kli.getIdentifiant().toString();
                transfert2 = kli.getNom().toString();
                System.out.println(transfert);
                System.out.println(transfert2);
                klikTableData(null);
                statusKlik = "0";
            });
        }

        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                setGraphic(hb);
            } else {
                setGraphic(null);
            }
        }
    }

    public void start1() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/Vue/abonnement.fxml"));
            themeWindow2 = new Stage();
            themeWindow2.setScene(new Scene(root));
            //themeWindow.setFullScreen(true);

        } catch (IOException ex) {
            Logger.getLogger(AbonneController.class.getName()).log(Level.SEVERE, null, ex);
        }

        root.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                x = event.getSceneX();
                y = event.getSceneY();
            }

        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                themeWindow2.setX(event.getScreenX() - x);
                themeWindow2.setY(event.getScreenY() - y);
            }

        });
        themeWindow2.initStyle(StageStyle.UNDECORATED);
        themeWindow2.show();

    }

    public void calculDate() {

        listDate = testdate.getAlldate();
        LocalDate aujourdhui = LocalDate.now();
        java.util.Date d4 = new java.util.Date();
        long nombre;

        for (int i = 0; i < listDate.size(); i++) {
            Abonnement ab = listDate.get(i);
            Date d1 = (Date) ab.getDatefin();
            LocalDate d3 = d1.toLocalDate();

            if (aujourdhui.isBefore(d3) || aujourdhui.equals(d3)) {
                long nbJours2 = ChronoUnit.DAYS.between(aujourdhui, d3);
                listuser = testUser.getAlluser(listDate.get(i).getNumerocli().toString());
                System.out.println(listDate.get(i).getNumerocli().toString());
                System.out.println(listuser.size());
                if (nbJours2 < 10) {
                    smsormail(listuser.get(0), nbJours2, listDate.get(i).getNumero().toString());

                }
            }
        }
        JOptionPane.showMessageDialog(null, "message envoyer avec succes.....");

        dialog(Alert.AlertType.CONFIRMATION, "Sms verification de date fait, Sms de confirmation encours...");

    }
    
    public void voirreste(){
        RetardModel rappel = new RetardModel();
          listDate = testdate.getAlldate();
        LocalDate aujourdhui = LocalDate.now();
        java.util.Date d4 = new java.util.Date();
        long nombre;

        for (int i = 0; i < listDate.size(); i++) {
            Abonnement ab = listDate.get(i);
            Date d1 = (Date) ab.getDatefin();
            LocalDate d3 = d1.toLocalDate();

            if (aujourdhui.isBefore(d3) || aujourdhui.equals(d3)) {
                long nbJours2 = ChronoUnit.DAYS.between(aujourdhui, d3);
                RetardModel re = new RetardModel();
                listuser = testUser.getAlluser(listDate.get(i).getNumerocli().toString());
                
                System.out.println(listuser.size());
                if (nbJours2 < 10) {
                    System.out.println(listuser.get(0).getNom().toString());
                    System.out.println(listuser.get(0).getTel().toString());
                    System.out.println(listDate.get(i).getNumerocli().toString());
                    System.out.println(""+nbJours2);
                    
                    
                    re.setNom(listuser.get(0).getNom().toString());
                    re.setTelephone(listuser.get(0).getTel().toString());
                    re.setAbonnement(listDate.get(i).getNumerocli().toString());
                    re.setTemps(""+nbJours2);
                    list1.add(re);
                    
                    
                }
            }
        } 
      tab3.setItems(list1);
    }
    
    public void voirreste1(){
        RetardModel rappel = new RetardModel();
          listDate = testdate.getAlldate();
        LocalDate aujourdhui = LocalDate.now();
        java.util.Date d4 = new java.util.Date();
        long nombre;

        for (int i = 0; i < listDate.size(); i++) {
            Abonnement ab = listDate.get(i);
            Date d1 = (Date) ab.getDatefin();
            LocalDate d3 = d1.toLocalDate();

            if (aujourdhui.isBefore(d3) || aujourdhui.equals(d3)) {
                long nbJours2 = ChronoUnit.DAYS.between(aujourdhui, d3);
                  RetardModel re = new RetardModel();
                listuser = testUser.getAlluser(listDate.get(i).getNumerocli().toString());
                System.out.println(listDate.get(i).getNumerocli().toString());
                System.out.println(listuser.size());
                if (nbJours2 > 10) {
                    re.setNom(listuser.get(0).getNom().toString());
                    re.setTelephone(listuser.get(0).getTel().toString());
                    re.setAbonnement(listDate.get(i).getNumerocli().toString());
                    re.setTemps(""+nbJours2);
                    list2.add(re);
                    
                    
                }
            }
        }
      tab3.setItems(list2);
    }
    
     public void voirreste2(){
        RetardModel rappel = new RetardModel();
          listDate = testdate.getAlldate();
        LocalDate aujourdhui = LocalDate.now();
        java.util.Date d4 = new java.util.Date();
        long nombre;

        for (int i = 0; i < listDate.size(); i++) {
            Abonnement ab = listDate.get(i);
            Date d1 = (Date) ab.getDatefin();
            LocalDate d3 = d1.toLocalDate();

            if (aujourdhui.isAfter(d3)) {
                RetardModel re = new RetardModel();
                listuser = testUser.getAlluser(listDate.get(i).getNumerocli().toString());
                System.out.println(listDate.get(i).getNumerocli().toString());
                System.out.println(listuser.size());
                
                System.out.println();
                
                     re.setNom(listuser.get(0).getNom().toString());
                    re.setTelephone(listuser.get(0).getTel().toString());
                    re.setAbonnement(listDate.get(i).getNumerocli().toString());
                    re.setTemps("Terminé");
                    list3.add(re);
                
            }
        }
      tab3.setItems(list3);
    }

    public void calculDate1() {

        listDate = testdate.getAlldate();
        LocalDate aujourdhui = LocalDate.now();
        java.util.Date d4 = new java.util.Date();
        long nombre;

        for (int i = 0; i < listDate.size(); i++) {
            Abonnement ab = listDate.get(i);
            Date d1 = (Date) ab.getDatefin();
            LocalDate d3 = d1.toLocalDate();

            if (aujourdhui.isBefore(d3) || aujourdhui.equals(d3)) {
                long nbJours2 = ChronoUnit.DAYS.between(aujourdhui, d3);
                listuser = testUser.getAlluser(listDate.get(i).getNumerocli().toString());
                System.out.println(listDate.get(i).getNumerocli().toString());
                System.out.println(listuser.size());
                if (nbJours2 < 10 && listuser.get(0).getEmail() != "") {
                    smsormail1(listuser.get(0), nbJours2, listDate.get(i).getNumero().toString());

                }
            }
        }
       
    }

    public void smsormail(Abonne l, long nb, String id) {
        System.out.println("sa marche pour " + l.getNom().toString() + "   email   :  " + l.getEmail() + "   nb : " + nb + "  abonement  :  " + id);
        try {
            // Recipient's email ID needs to be mentioned.
            String to = "arnoldkom55@gmail.com";
// Sender's email ID needs to be mentioned
            String from = "arnoldkim4@gmail.com";

//change accordingly final
            String password = "arnoldkills55";
//change accordingly
// Assuming you are sending email through relay.jangosmtp.net
            String host = "smtp.gmail.com";
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");

            // Get the Session object.
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(to, password);
                }
            });

// Create a default MimeMessage object.
            javax.mail.Message message = new MimeMessage(session);
// Set From: header field of the header.
            message.setFrom(new InternetAddress(to));
// Set To: header field of the header.
            message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(from));
// Set Subject: header field
            message.setSubject("Délai d'expiration du forfait Canal+ de " + l.getNom().toString() + "  " + nb + " jour(s) restant(s) ");
// Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
// Now set the actual message
            String message1 = "Canal+ \n\n Identifiant du forfait :   " + id + "  \n\n Nom et prenom :  " + l.getNom().toString() + "  \n\n mail  :   " + l.getEmail().toString() + "  \n\n Telephone :    " + l.getTel().toString() + "  \n\n Nombre de jour restant :  " + nb + " Jour(s) \n\n  \n\n System d'authetification du forfait canal+  ";
            message.setText(message1);
            // Create a multipar message
            Multipart multipart = new MimeMultipart();
// Set text message part
            multipart.addBodyPart(messageBodyPart);
            // Part two is attachment

// Send the complete message parts
            //message.setContent(multipart);
// Send message
            Transport.send(message);

        } catch (MessagingException ex) {
            Logger.getLogger(AbonneController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void smsormail1(Abonne l, long nb, String id) {
        System.out.println("sa marche pour " + l.getNom().toString() + "   email   :  " + l.getEmail() + "   nb : " + nb + "  abonement  :  " + id);
        try {
            // Recipient's email ID needs to be mentioned.
            String to = "arnoldkom55@gmail.com";
// Sender's email ID needs to be mentioned
            String from = "arnoldkim4@gmail.com";

//change accordingly final
            String password = "arnoldkills55";
//change accordingly
// Assuming you are sending email through relay.jangosmtp.net
            String host = "smtp.gmail.com";
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");

            // Get the Session object.
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(to, password);
                }
            });

// Create a default MimeMessage object.
            javax.mail.Message message = new MimeMessage(session);
// Set From: header field of the header.
            message.setFrom(new InternetAddress(to));
// Set To: header field of the header.
            message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(from));
// Set Subject: header field
            message.setSubject("Délai d'expiration du forfait Canal+ de " + l.getNom().toString() + "  " + nb + " jour(s) restant(s) ");
// Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
// Now set the actual message
            String message1 = "\n\nSalut <u> " + l.getNom().toString() + " votre forfait Canal+ arrive bientot a son expiration \n\n\n bien vouloir renouveller votre forfait \n\n\n\n\n Cordialement le groupe Canal+</u>  </h3></body></html>";
            message.setText(message1);
            // Create a multipar message
            Multipart multipart = new MimeMultipart();
// Set text message part
            multipart.addBodyPart(messageBodyPart);
            // Part two is attachment

// Send the complete message parts
            //message.setContent(multipart);
// Send message
            Transport.send(message);

        } catch (MessagingException ex) {
            Logger.getLogger(AbonneController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
