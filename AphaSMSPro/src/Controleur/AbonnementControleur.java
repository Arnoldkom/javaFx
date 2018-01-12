/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Model.Abonnement;
import Model.implAbonnement;
import Model.interAbonnement;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.fontawesome.AwesomeDude;
import de.jensd.fx.fontawesome.AwesomeIcon;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 *
 * @author Arnoldkom
 */
public class AbonnementControleur implements Initializable {

    @FXML
    private AnchorPane panne;
    @FXML
    private JFXTextField numero1;
    @FXML
    private JFXTextField type;
    @FXML
    private JFXTextField recherche2;
    @FXML
    private JFXDatePicker datedebut;
    @FXML
    private JFXDatePicker datefin;
    @FXML
    private TableColumn colaction1;
//    @FXML
//    private JFXButton accueil2;
//     @FXML
//    private JFXButton abonne2;
//     @FXML
//    private JFXButton parametre2;
//     @FXML
//    private JFXButton aide2;
//     @FXML
//    private JFXButton close3;
    @FXML
    private JFXButton cancel3;
    @FXML
    private JFXButton valide3;
    @FXML
    private TableView<Abonnement> tababonne;
    @FXML
    private TableColumn<Abonnement, String> colnumero1;
    @FXML
    private TableColumn<Abonnement, String> coltype;
    @FXML
    private TableColumn<Abonnement, String> coldatedebut;
    @FXML
    private TableColumn<Abonnement, String> coldatefin;
    @FXML
    private Label setnumero;
    @FXML
    private Label setnom;

    interAbonnement crudData = new implAbonnement();
    ObservableList<Abonnement> listData;
    private String StatusKode, statusKlik;
    ObservableList<Abonnement> listDelete;
    private String param1 = AbonneController.transfert.toString();
    private String param2 = AbonneController.transfert2.toString();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setnumero.setText(AbonneController.transfert.toString());
        setnom.setText(AbonneController.transfert2.toString());
        colnumero1.setCellValueFactory(
                (TableColumn.CellDataFeatures<Abonnement, String> cellData)
                -> cellData.getValue().getNumeroProperty());
        coltype.setCellValueFactory(
                (TableColumn.CellDataFeatures<Abonnement, String> cellData)
                -> cellData.getValue().getTypeProperty());

        coldatedebut.setCellValueFactory(new PropertyValueFactory("formatDated"));
        coldatefin.setCellValueFactory(new PropertyValueFactory("formatDatef"));

        colaction1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Object, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Object, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        colaction1.setCellFactory(new Callback<TableColumn<Object, Boolean>, TableCell<Object, Boolean>>() {
            @Override
            public TableCell<Object, Boolean> call(TableColumn<Object, Boolean> p) {
                return new ButtonCell(tababonne);
            }
        });

        listData = FXCollections.observableArrayList();
        AwesomeDude.setIcon(valide3, AwesomeIcon.CHECK_SQUARE, "15px");
        AwesomeDude.setIcon(cancel3, AwesomeIcon.CHAIN_BROKEN, "15px");
        StatusKode = "0";
        statusKlik = "0";
        tampilData();

        tababonne.getSelectionModel().clearSelection();

    }

    private void dialog(Alert.AlertType alertType, String s) {
        Alert alert = new Alert(alertType, s);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Info");
        alert.showAndWait();
    }

    private void clear() {
        numero1.clear();
        type.clear();
        datedebut.setValue(LocalDate.of(2017, 12, 01));
        datefin.setValue(LocalDate.of(2017, 12, 01));
        StatusKode = "0";
    }

    private void tampilData() {
        System.out.println("parmetre de " + param1);
        listData = crudData.getAll(param1);
        tababonne.setItems(listData);
    }

    @FXML
    public void btn_accueil2(ActionEvent event) {
        System.out.println("le bouton de accueil2 fonctionne bien et parfaitement");

    }

    @FXML
    public void btn_abonne2(ActionEvent event) {
        System.out.println("le bouton abonne2 fonctionne bien et parfaitement");

    }

    @FXML
    public void btn_parametre2(ActionEvent event) {
        System.out.println("le bouton de paramettre2 fonctionne bien et parfaitement");

    }

    @FXML
    public void btn_aide2(ActionEvent event) {
        System.out.println("le bouton d'aide2 fonctionne bien et parfaitement");

    }

    @FXML
    public void btn_close3(ActionEvent event) {
        System.out.println("la fermeture de la fenetre fonctionne bien");
        AbonneController.themeWindow2.close();
    }

    @FXML
    public void btn_valide3(ActionEvent event) {
        Abonnement m = new Abonnement();
        m.setNumero(numero1.getText());
        m.setType(type.getText());
        m.setDatedebut(Date.valueOf(datedebut.getValue()));
        m.setDatefin(Date.valueOf(datefin.getValue()));
        m.setNumerocli(param1);
        if (StatusKode.equals("0")) {
            crudData.insert(m);
        } else {
            crudData.update(m);
        }
        dialog(Alert.AlertType.INFORMATION, "Enregistré avec succes...");
        tampilData();
        clear();

    }

    @FXML
    public void btn_annuler3(ActionEvent event) {
        clear();
        tampilData();
    }

    @FXML
    private void klikTableData(MouseEvent event) {
        if (statusKlik.equals("1")) {
            StatusKode = "1";
            try {
                Abonnement klik = tababonne.getSelectionModel().getSelectedItems().get(0);
                numero1.setText(klik.getNumero());
                type.setText(klik.getType());
                datedebut.setValue(LocalDate.parse(klik.getDatedebut().toString()));
                datefin.setValue(LocalDate.parse(klik.getDatefin().toString()));
            } catch (Exception e) {
            }
        }
        if (statusKlik.equals("2")) {

        }

    }

    @FXML
    private void aksiCari(KeyEvent event) {
        listData = crudData.likeByNama(recherche2.getText());
        tababonne.setItems(listData);
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
                tababonne.getSelectionModel().select(row);
                klikTableData(null);
                Abonnement m = new Abonnement();
                m.setNumero(numero1.getText());
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
                tababonne.getSelectionModel().select(row);
                klikTableData(null);
                statusKlik = "0";
            });
            cellButtonvue.setOnAction((ActionEvent event) -> {
                statusKlik = "2";
                int row = getTableRow().getIndex();
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

}
