package tk.andrewboy159.pastebinclient;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private Stage window;
    private Scene splash, main;

    private String key = "e327e1850a5fab998d4a8043d1898c64";

    public String getKey() {
        return key;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        Parent splashLayout = FXMLLoader.load(getClass().getResource("/fxml/splash.fxml"));
        window.setTitle("Pastebin");
        window.setResizable(false);
        window.getIcons().add(new Image(getClass().getResourceAsStream("/images/logo.png")));
        window.initStyle(StageStyle.UNDECORATED);
        splash = new Scene(splashLayout, 600, 550);
        window.setScene(splash);
        window.show();

        wait(10);


        Parent mainLayout = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        window.setTitle("Pastebin");
        window.setResizable(false);
        main = new Scene(mainLayout, 600, 550);
        window.setScene(main);
    }

    public void closeProgram() {
        Platform.exit();
    }


    private void wait(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
