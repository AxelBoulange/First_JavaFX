package view;

import controller.TaskController;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import model.Categorie;
import model.Status;
import model.Task;
import model.TaskList;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class TaskViewController implements Initializable {

    @FXML
    private TextField taskTitleField;
    
    @FXML
    private TextField taskDescriptionField;
    
    @FXML
    private ListView<Status> listStatus;
    
    @FXML
    private ListView<Categorie> listCategorie;
    
    @FXML
    private ListView<Categorie> listCategorieFilter;
    
    @FXML
    private TextField taskDueDateField;

    private TaskController taskController = new TaskController();
    
    private Task currentTask;

    boolean first = true;
    
    @FXML
	private ListView<Task> listView;
	
	@FXML
	private Label myLabel;
	
	@FXML
	private DatePicker datePicker;
	
	@FXML
	private RadioButton radioButtonDateAsc;
	
	@FXML
    private RadioButton radioButtonDateDesc;
	
	int index = 0;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TaskList<Task> tasks = TaskController.getTasks();
		for (Task task : tasks) {
			if(task.getId() > index) {
				index = task.getId() + 1;
			}
		}
		listView.getItems().addAll(tasks);
		
		listStatus.getItems().addAll(Status.getStatusList());
		listCategorieFilter.getItems().addAll(Categorie.getCategorieList());
		listCategorie.getItems().addAll(Categorie.getCategorieList());
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Task>() {
			@Override
			public void changed(ObservableValue<? extends Task> arg0, Task arg1, Task arg2) {
				currentTask = listView.getSelectionModel().getSelectedItem();
				if (currentTask != null || first) {
					first = false;
					myLabel.setText(currentTask.getTitle() + "\n" + currentTask.getDescription());
					taskTitleField.setText(currentTask.getTitle());
					taskDescriptionField.setText(currentTask.getDescription());
					listStatus.getSelectionModel().select(currentTask.getStatus().getStatusCode());;
					datePicker.setValue(currentTask.getDte_fin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
					listCategorie.getSelectionModel().select(currentTask.getCategogie().getCategorieCode());
				}
			}
		});	
	}


	@FXML
	private void updateOrCreateTask() {
		
		String titleString = taskTitleField.getText();
		String descripString = taskDescriptionField.getText();
		Integer status = listStatus.getSelectionModel().getSelectedItem().getStatusCode();
		Categorie categorie = listCategorie.getSelectionModel().getSelectedItem();
		Date date = Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		if (titleString.isEmpty() || descripString.isEmpty() || status == null || categorie == null || date == null) {
			new Alert(AlertType.NONE, "Veuillez remplir toutes les informations pour modifier ou ajouter un tache." , ButtonType.CLOSE).show();
		}
		else {
			if (currentTask == null) {
				Task newTask = new Task(index, titleString, descripString, date, categorie);
				newTask.setStatusInfo(status);
				listView.getItems().add(newTask);
				index++;
			}
			else {
				Task tempTask = currentTask;
				listView.getItems().remove(currentTask);
				currentTask = null;
				tempTask.setTitle(titleString);
				tempTask.setDescription(descripString);
				tempTask.setStatusInfo(status);
				tempTask.setCategogie(categorie);
				tempTask.setDte_fin(date);
				listView.getItems().add(tempTask);
			}
		}
		refreshList();
		currentTask = null;
	}
	
	private void refreshList() {
		ObservableList<Task> tasks = listView.getItems();
		listView.setItems(null); 
		listView.setItems(tasks);         
	}
	
	@FXML
	private void clearTask() {
		SelectionModel model = listView.getSelectionModel();
		if (model.getSelectedItem() != null) {
			model.clearSelection();
		}
		currentTask = null;
		myLabel.setText("rien");
	}
	
	@FXML
	private void filterTask() {
		Categorie currentCategorie = listCategorieFilter.getSelectionModel().getSelectedItem();
		if (currentCategorie != null) {
			List<Task> tasks = new TaskList<Task>();
			for (Task task : listView.getItems()) 
				if (task.getCategogie().getCategorieCode() == currentCategorie.getCategorieCode()) {
					tasks.add(task);
				}
			tasks.sort((a,b) -> {return -1 * a.compareTo(b);});
			if(radioButtonDateDesc.isSelected()) {
				tasks = tasks.reversed();
			}
			listView.getItems().setAll(tasks);
			refreshList();
		}
		else {
			new Alert(AlertType.NONE, "Veuillez choisir une catégorie avant de filtrer." , ButtonType.CLOSE).show();
		}
	}
	
	@FXML
	private void ClearfilterTask() {
		listCategorieFilter.getSelectionModel().clearSelection();;
		radioButtonDateAsc.setSelected(true);
		listView.getItems().clear();
		listView.getItems().addAll(TaskController.getTasks());
		refreshList();
	}
	
    @FXML
    private void deleteTask() {
    	if (currentTask == null) {
    		new Alert(AlertType.NONE, "Aucune tâche séléctionné" , ButtonType.CLOSE).show();
    	}
    	else {
    		listView.getItems().remove(currentTask);	
		}
    	
    }
}
