package tk.andrewboy159.pastebinclient.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tk.andrewboy159.pastebinclient.Main;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ControllerMain {

    Main main = new Main();

    @FXML
    private TextField usernameField;
    @FXML
    private String username;
    @FXML
    private PasswordField passwordField;
    @FXML
    private String password;
    private Stage window;

    @FXML
    private void close() {
        main.closeProgram();
    }

    @FXML
    private void loginWindow() {
        Parent loginLayout;
        try {
            loginLayout = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            window = new Stage();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Log In");
        window.setResizable(false);
        window.initStyle(StageStyle.UNDECORATED);

        Scene login = new Scene(loginLayout);
        window.setScene(login);
        window.showAndWait();
    }

    @FXML
    public String login() {
        username = usernameField.getText();
        password = passwordField.getText();

        HttpURLConnection connection = null;
        try {
            URL url = new URL("http://pastebinclient.tk/server/login.php");
            String urlParameters = "api_dev_key=" + main.getKey() + "&api_user_name=" + username + "&api_user_password=" + password;

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuffer response = new StringBuffer(); // or StringBuffer if Java version 5+
            String line;
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\n');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
    }
}
