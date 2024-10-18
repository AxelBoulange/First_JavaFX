package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Task;
import model.TaskList;

import java.io.IOException;
import java.util.ArrayList;

import controller.TaskController;

public class Main extends Application {

	public static TaskList<Task> tasks;
	
    @Override
    public void start(Stage primaryStage) throws IOException {
    	
    	tasks = TaskController.getTasks();
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/task_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
    	
        
        primaryStage.setTitle("Gestionnaire de Tâches");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
