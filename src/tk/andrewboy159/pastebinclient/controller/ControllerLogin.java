package tk.andrewboy159.pastebinclient.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tk.andrewboy159.pastebinclient.Main;

import java.io.IOException;

public class ControllerLogin {
    private Main main = new Main();

    @FXML
    private Button cancelButton;

    @FXML
    private TextField usernameField;
    @FXML
    private String username;

    @FXML
    private PasswordField passwordField;
    @FXML
    private String password;

    @FXML
    private Stage window = new Stage();

    @FXML
    private Text footerText;

    public void display() {
        try {
            window.initModality(Modality.APPLICATION_MODAL);
            Parent loginLayout = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            window.setTitle("Log In");
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
    public void login() {
        username = usernameField.getText();
        password = passwordField.getText();

        try {
            HttpResponse<String> post = Unirest.post("http://www.pastebinclient.tk/server/login.php")
                    .field("api_dev_key", main.getKey())
                    .field("api_user_name", username)
                    .field("api_user_password", password).asString();
            String response = post.getBody();

            if(response.equals("Bad API request, use POST request, not GET\n")) {
                System.out.println("Use POST requests not GET!");
            } else if(response.equals("Bad API request, invalid api_dev_key\n")) {
                System.out.println("Invalid Key!");
            } else if(response.equals("Bad API request, invalid login\n")) {
                footerText.setText("Invalid Username or Password!");
            } else if(response.equals("Bad API request, account not active\n")) {
                footerText.setText("This account is inactive!");
            } else if(response.equals("Bad API request, invalid POST parameters\n")) {
                System.out.println("Invalid POST request!");
            } else {
                main.setUserKey(response);
                HttpResponse<String> infoPost = Unirest.post("http://www.pastebinclient.tk/server/info.php")
                        .field("api_user_key", main.getUserKey()).asString();
                String infoResponse = infoPost.getBody();
                System.out.println(infoResponse);
                //close();
            }
            System.out.println(response);
        } catch (UnirestException e) {
            System.out.println("Failed to connect!");
            close();
        }

    }

    @FXML
    public void close() {
        Stage stage = (Stage) this.cancelButton.getScene().getWindow();
        stage.close();
    }
}
