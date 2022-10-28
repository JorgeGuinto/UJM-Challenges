package com.example.contactschallenge;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DialogController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextArea notesField;

    public Contact getNewContact() {
        if (firstNameField.getText().trim() == ""){
            System.out.println("First name can't be empty");
            return null;
        } else if (lastNameField.getText().trim() == "") {
            System.out.println("Last name can't be empty");
            return null;
        } else if (phoneNumberField.getText().trim() == "") {
            System.out.println("Phone number can't be empty");
            return null;
        } else {
            Contact newContact = new Contact(firstNameField.getText(),
                    lastNameField.getText(),
                    phoneNumberField.getText(),
                    notesField.getText());
            return newContact;
        }
    }
}
