package co.uniquindio.edu.co.parcial1.viewController;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

    public class MainApp extends Application {

        @Override
        public void start(Stage stage) {
            Label label = new Label("¡JavaFX está funcionando!");
            StackPane root = new StackPane(label);
            Scene scene = new Scene(root, 400, 300);

            stage.setTitle("LenguajeCafetero");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

