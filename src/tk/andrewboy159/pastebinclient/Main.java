package tk.andrewboy159.pastebinclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene splash, main;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        Parent splashLayout = FXMLLoader.load(getClass().getResource("/fxml/splash.fxml"));
        window.setTitle("Pastebin");
        window.setResizable(false);
        splash = new Scene(splashLayout, 600, 550);
        window.setScene(splash);
        window.show();

        wait(3);


        Parent mainLayout = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        window.setTitle("Pastebin");
        window.setResizable(false);
        main = new Scene(mainLayout, 600, 550);
        window.setScene(main);

        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/splash.fxml"));
        //primaryStage.setTitle("Pastebin");
        //primaryStage.setScene(new Scene(root, 600, 550));
        //primaryStage.setResizable(false);
        //primaryStage.show();
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
