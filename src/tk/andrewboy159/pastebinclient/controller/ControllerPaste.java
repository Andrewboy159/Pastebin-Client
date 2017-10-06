package tk.andrewboy159.pastebinclient.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tk.andrewboy159.pastebinclient.Main;

import java.io.IOException;

public class ControllerPaste {

    Main main = new Main();

    Stage window = new Stage();

    @FXML
    Button cancelButton;

    public void display() {
        try {
            window.initModality(Modality.APPLICATION_MODAL);
            Parent loginLayout = FXMLLoader.load(getClass().getResource("/fxml/paste.fxml"));
            window.setTitle("New Paste");
            window.setResizable(false);
            window.initStyle(StageStyle.UNDECORATED);

            Scene login = new Scene(loginLayout);
            window.setScene(login);
            window.showAndWait();
        } catch (IOException e) {
            System.out.println("Failed to load fxml!");
            e.printStackTrace();
        }
    }

    @FXML
    public void close() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void paste() {
        /*HttpResponse<String> post = Unirest.post("pastebinclient.tk/server/paste.php")
                .field("api_dev_key", main.getKey())
                .field("api_paste_code", )*/
    }
}
