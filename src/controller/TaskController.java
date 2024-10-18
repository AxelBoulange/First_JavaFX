package controller;

import model.Task;
import model.TaskList;
import model.Categorie;
import model.Subtask;

import java.net.URL;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class TaskController{

	
	public static TaskList<Task> getTasks(){
		ArrayList<Subtask> soustaches = new ArrayList<Subtask>();
		soustaches.add(new Subtask(1,"Subtask1","SubtaskDesc1"));
		soustaches.add(new Subtask(2,"Subtask2","SubtaskDesc2"));
		soustaches.add(new Subtask(3,"Subtask3","SubtaskDesc3"));
		soustaches.add(new Subtask(4,"Subtask4","SubtaskDesc4"));
		
		
		TaskList<Task> taches = new TaskList<Task>();
		taches.add(new Task(1, "tache1", "une description 1", new java.util.Date(2015, 02, 20) , new Categorie(0)));
		taches.add(new Task(2, "tache2", "une description 2", new java.util.Date(2025, 02, 20) ,  new Categorie(0), soustaches));
		taches.add(new Task(3, "tache3", "une description 3", new java.util.Date(2026, 02, 20) ,  new Categorie(1)));
		taches.add(new Task(4, "tache4", "une description 4", new java.util.Date(2027, 02, 20) ,  new Categorie(1)));
		taches.add(new Task(5, "tache1", "une description 1", new java.util.Date(2015, 02, 20) ,  new Categorie(1)));
		taches.add(new Task(6, "tache2", "une description 2", new java.util.Date(2025, 02, 20) , new Categorie(2)));
		taches.add(new Task(7, "tache3", "une description 3", new java.util.Date(2026, 02, 20) , new Categorie(2), soustaches));
		taches.add(new Task(8, "tache4", "une description 4", new java.util.Date(2027, 02, 20) , new Categorie(2)));
		
		return taches;
	}
	
}