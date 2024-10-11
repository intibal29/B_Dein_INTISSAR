package org.example.b;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.Parent;

import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carga del archivo FXML usando una ruta relativa
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/b/hello-view.fxml")));

        primaryStage.setTitle("Gestión de Personas");
        primaryStage.setScene(new Scene(root, 600, 400));

        // Cargar el icono de la aplicación usando una ruta relativa
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/agenda.png"))));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
