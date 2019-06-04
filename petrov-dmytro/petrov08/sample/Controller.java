package sample;

import java.beans.XMLEncoder;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {

    private TableView<Persons> table1 = new TableView<Persons>();
    private final ObservableList<Persons> data = FXCollections.observableArrayList();/* =
            FXCollections.observableArrayList(
                    new Persons("Jacob", "Smith"),
                    new Persons("Isabella", "Johnson"),
                    new Persons("Ethan", "Williams"),
                    new Persons("Emma", "Jones"),
                    new Persons("Michael", "Brown")
            );*/

    @FXML
    private TableView<Persons> table;

    @FXML
    private Label table_lable;

    @FXML
    private Label lable_name;

    @FXML
    private Label lable_last_name;

    @FXML
    private Label lable_sub_name;

    @FXML
    private Label lable_birth_date;

    @FXML
    private Label lable_address;

    @FXML
    private Label lable_phone;

    @FXML
    private TextField text_field_name;

    @FXML
    private TextField text_field_last_name;

    @FXML
    private TextField text_field_sub_name;

    @FXML
    private TextField text_field_birth_date;

    @FXML
    private TextField text_field_address;

    @FXML
    private TextField text_field_phone;

    @FXML
    private Button btn_new;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_save;

    @FXML
    private Button btn_load;

    @FXML
    private Button btn_delete_item;

    @FXML
    void initialize() {
        String name;

        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Persons, String>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Persons, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Persons, String> cellEditEvent) {
                        ((Persons) cellEditEvent.getTableView().getItems().get(
                                cellEditEvent.getTablePosition().getRow())
                        ).setFirstName(cellEditEvent.getNewValue());
                    }
                }
        );

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Persons, String>("lastName"));
        /**setting Editable **/
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Persons, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Persons, String> cellEditEvent) {
                        ((Persons) cellEditEvent.getTableView().getItems().get(
                                cellEditEvent.getTablePosition().getRow())
                        ).setLastName(cellEditEvent.getNewValue());
                    }
                }
        );

        TableColumn subNameCol = new TableColumn("SubName");
        subNameCol.setMinWidth(100);
        subNameCol.setCellValueFactory(
                new PropertyValueFactory<Persons, String>("subName"));
        /**setting Editable **/
        subNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        subNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Persons, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Persons, String> cellEditEvent) {
                        ((Persons) cellEditEvent.getTableView().getItems().get(
                                cellEditEvent.getTablePosition().getRow())
                        ).setSubName(cellEditEvent.getNewValue());
                    }
                }
        );

        TableColumn addressCol = new TableColumn("Address");
        addressCol.setMinWidth(100);
        addressCol.setCellValueFactory(
                new PropertyValueFactory<Persons, String>("address"));
        /**setting Editable **/
        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        addressCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Persons, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Persons, String> cellEditEvent) {
                        ((Persons) cellEditEvent.getTableView().getItems().get(
                                cellEditEvent.getTablePosition().getRow())
                        ).setAddress(cellEditEvent.getNewValue());
                    }
                }
        );

        TableColumn birthDateCol = new TableColumn("Birthday");
        birthDateCol.setMinWidth(100);
        birthDateCol.setCellValueFactory(
                new PropertyValueFactory<Persons, String>("birthday"));
        /**setting Editable **/
        birthDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        birthDateCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Persons, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Persons, String> cellEditEvent) {
                        ((Persons) cellEditEvent.getTableView().getItems().get(
                                cellEditEvent.getTablePosition().getRow())
                        ).setBirthday(cellEditEvent.getNewValue());
                    }
                }
        );

        TableColumn phoneCol = new TableColumn("phone");
        phoneCol.setMinWidth(100);
        phoneCol.setCellValueFactory(
                new PropertyValueFactory<Persons, String>("phone"));
        /**setting Editable **/
        phoneCol.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Persons, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Persons, String> cellEditEvent) {
                        ((Persons) cellEditEvent.getTableView().getItems().get(
                                cellEditEvent.getTablePosition().getRow())
                        ).setPhone(cellEditEvent.getNewValue());
                    }
                }
        );

        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, subNameCol, addressCol, birthDateCol, phoneCol);

//        Persons person = new Persons("", "", "", "", "", "");
        ArrayList<Persons> personsArrayList = new ArrayList<>();

        btn_new.setOnAction(actionEvent -> {

            Persons persons = new Persons(
                    text_field_name.getText(),
                    text_field_last_name.getText(),
                    text_field_sub_name.getText(),
                    text_field_address.getText(),
                    text_field_birth_date.getText(),
                    text_field_phone.getText());

            personsArrayList.add(persons);

//            person.setFirstName(text_field_name.getText());
//            person.setLastName(text_field_last_name.getText());
//            person.setSubName(text_field_sub_name.getText());
//            person.setAddress(text_field_address.getText());
//            person.setBirthday(text_field_birth_date.getText());
//            person.setPhone(text_field_phone.getText());

//            persons.setFirstName(text_field_name.getText());
//            persons.setLastName(text_field_last_name.getText());


            data.add(persons);




            text_field_name.setText("");
            text_field_last_name.setText("");
            text_field_sub_name.setText("");
            text_field_address.setText("");
            text_field_birth_date.setText("");
            text_field_phone.setText("");
//            table_column_1.setCellValueFactory(new PropertyValueFactory<>(persons.getFirstName()));
        });

        btn_delete.setOnAction(actionEvent -> {
            data.clear();
            table.setItems(data);
            personsArrayList.clear();
        });

        btn_save.setOnAction(actionEvent -> {
            Stage secondaryStage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save table");
//            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            if (table.getItems().isEmpty()){
                Alert emptyTableAlert = new Alert(Alert.AlertType.ERROR, "Empty Table", ButtonType.OK);
                emptyTableAlert.setContentText("You have nothing to save!");
                emptyTableAlert.initModality(Modality.APPLICATION_MODAL);

                emptyTableAlert.showAndWait();
                if (emptyTableAlert.getResult() == ButtonType.OK){
                    emptyTableAlert.close();
                }
            }else {
                File file = fileChooser.showSaveDialog(secondaryStage);
                if (file != null){
//                    saveFile(table.getItems().toArray(), file);
                    ArrayList<Persons> addingData = new ArrayList<>(table.getItems());//(ArrayList<Persons>) table.getItems();
                    saveFile(addingData, file);
                }
            }
        });

        btn_load.setOnAction(actionEvent -> {
            Stage secondaryStage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Load table");
//            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            if (!personsArrayList.isEmpty()){
                Alert emptyTableAlert = new Alert(Alert.AlertType.ERROR, "Table has Objects", ButtonType.OK);
                emptyTableAlert.setContentText("You have items in the table! Your items in the table!");
                emptyTableAlert.initModality(Modality.APPLICATION_MODAL);

                emptyTableAlert.showAndWait();
                if (emptyTableAlert.getResult() == ButtonType.OK){
                    emptyTableAlert.close();
                }
            }else {
                File file = fileChooser.showOpenDialog(secondaryStage);
                if (file != null){
//                    loadFile(table.getItems(), file);
//                    table.setItems(loadFile(), file);
                    ObservableList<Persons> save = FXCollections.observableArrayList ((ArrayList<Persons>) loadFile(data, file));// loadFile(data, file);
                    data.setAll(save);
                }
            }
        });

        btn_delete_item.setOnAction(actionEvent -> {
            if (!table.getItems().isEmpty()) {
                System.out.println("Delete Item button clicked");
                Alert deleteAlert = new Alert(Alert.AlertType.WARNING, "Confirm", ButtonType.OK, ButtonType.CANCEL);
                deleteAlert.setContentText("Do you want to delete this row?\n This CANNOT BE UNDONE!");
                deleteAlert.initModality(Modality.APPLICATION_MODAL);
                deleteAlert.showAndWait();

                if (deleteAlert.getResult() == ButtonType.OK){
                    table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
                    System.out.println("OK");
                    table.getSelectionModel().clearSelection();
                } else {
                    deleteAlert.close();
                }
            }
        });


    }

    /***************************************************************
     *
     * ObservableList<Stavka> oListStavaka = FXCollections.observableArrayList(listStavaka);
     * @param observableList
     * @param file
     */

    public void saveFile(ArrayList<Persons> observableList, File file){
        try {
            /*BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));
            for (Persons persons: observableList){
                outWriter.write(persons.toString());
                outWriter.newLine();
            }*/
            Object personsArrayList = observableList;

//            for (Persons persons: observableList) {
//                personsArrayList.add(observableList.)
//            }

            Serialization.XMLEncoder(observableList, file);

            System.out.println(observableList.toString());

//            outWriter.close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Damn!", ButtonType.OK);
            alert.setContentText("We can't write, master!");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK){
                alert.close();
            }
            e.printStackTrace();
        }
    }

    public Object loadFile(ObservableList<Persons> observableList, File file){
        ObservableList<Persons> personsObservableList = FXCollections.observableArrayList();
        ArrayList<Persons> loaded = new ArrayList<>();
        try {

            System.out.println(observableList.toString());

            loaded= (ArrayList<Persons>) Serialization.XMLDecoder(file);
//            Persons[] saveFileArray = (Persons[]) object;
            System.out.println(loaded.toString());
//            ArrayList<Persons> savePersons = (ArrayList<Persons>) object;
//            personsObservableList = (ObservableList<Persons>) object;
//           personsObservableList = (ObservableList<Persons>) savePersons;
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Damn!", ButtonType.OK);
            alert.setContentText("We can't write, master!");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK){
                alert.close();
            }
            e.printStackTrace();
        }
        return loaded;
    }


}
