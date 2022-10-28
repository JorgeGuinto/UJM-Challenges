package com.example.contactschallenge;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.util.Optional;

public class Controller {
    @FXML
    private GridPane mainGridPane;
    @FXML
    private TableView<Contact> tableView;

    public void initialize() {
        ContactData.getInstance().loadContacts();
        tableView.setItems(ContactData.getInstance().getContacts());
    }

    public void deleteItem(Contact item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact");
        alert.setHeaderText("Delete contact: " + item.toString());
        alert.setContentText("Press OK to confirm, or cancel to Back out.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            ContactData.getInstance().deleteContact(item);
        }
    }

    @FXML
    public void handleDeleteKeyPressed(KeyEvent keyEvent) {
        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
        if (selectedContact != null) {
            if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteItem(selectedContact);
            }
        }
    }

    @FXML
    public void handleDeleteClick(){
        Contact contact = tableView.getSelectionModel().getSelectedItem();
        deleteItem(contact);
    }

    @FXML
    public void showNewItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainGridPane.getScene().getWindow());
        dialog.setTitle("Add New Contact");
        dialog.setHeaderText("Use this dialog to create a new contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactDialog.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch(IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            System.out.println("Ok pressed");
            DialogController controller = fxmlLoader.getController();
            Contact newContact = controller.getNewContact();
            ContactData.getInstance().addContact(newContact);
            ContactData.getInstance().saveContacts();
        } else {
            System.out.println("Cancel pressed");
        }
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }
}