package it.unicam.cs.pa.jlife097988;

import it.unicam.cs.pa.jlife097988.Model.Board;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Main avvia il gioco
 */
public class Main extends Application {

    private FXMLLoader fxmlLoader;
    private Stage primaryStage;
    private Parent view;

    public static Board board;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        initializePrimaryStage(primaryStage);
        initializeFxmlLoader();
        initializeView();
        showScene();
        board = View.initLayout(view.getScene());
    }


    private void initializePrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Game of Life");
        this.primaryStage.setOnCloseRequest(event -> Platform.exit());
        this.primaryStage.setResizable(false);
        this.primaryStage.sizeToScene();
    }

    private void initializeFxmlLoader() {
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("/it.unicam.cs.pa.jlife097988/ui.fxml"));
    }

    private void initializeView() throws IOException {
        view = fxmlLoader.load();
    }

    private void showScene() {
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}