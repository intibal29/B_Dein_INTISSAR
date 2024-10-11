package org.example.b;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.b.Persona;

public class HelloController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private TableView<Persona> tablaPersonas;
    @FXML
    private TableColumn<Persona, String> colNombre;
    @FXML
    private TableColumn<Persona, String> colApellidos;
    @FXML
    private TableColumn<Persona, Integer> colEdad;

    // Lista observable para manejar la tabla
    private ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();

    // Inicializar la tabla y sus columnas
    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        colApellidos.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getApellidos()));
        colEdad.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getEdad()));

        // Asignar la lista observable a la tabla
        tablaPersonas.setItems(listaPersonas);
    }

    @FXML
    private void agregarPersona() {
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String edadTexto = txtEdad.getText();

        // Validar que los campos nombre y apellidos no estén vacíos
        if (nombre.isEmpty() || apellidos.isEmpty()) {
            mostrarAlerta("Error", "Nombre y apellidos son obligatorios.");
            return;
        }

        // Validar que la edad sea un número entero
        int edad;
        try {
            edad = Integer.parseInt(edadTexto);
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "La edad debe ser un número entero.");
            return;
        }

        // Crear objeto Persona
        Persona nuevaPersona = new Persona(nombre, apellidos, edad);

        // Verificar si la persona ya existe en la lista
        if (listaPersonas.contains(nuevaPersona)) {
            mostrarAlerta("Error", "Esta persona ya existe.");
        } else {
            // Agregar a la lista y actualizar la tabla
            listaPersonas.add(nuevaPersona);
            mostrarAlerta("Éxito", "Persona agregada correctamente.");
        }
    }

    // Método para mostrar alertas
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
