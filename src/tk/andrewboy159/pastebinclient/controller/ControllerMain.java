package tk.andrewboy159.pastebinclient.controller;

import javafx.fxml.FXML;
import tk.andrewboy159.pastebinclient.Main;

public class ControllerMain {

    private Main main = new Main();
    private ControllerLogin login = new ControllerLogin();
    private ControllerPaste paste = new ControllerPaste();


    @FXML
    private void close() {
        main.closeProgram();
    }

    @FXML
    private void loginWindow() {
        login.display();
    }

    @FXML
    private void pasteWindow() {
        paste.display();
    }

}
