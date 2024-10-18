package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task implements Comparable<Task>{
	
	private Integer id;
	private String title;
	private String description;
	private Date dte_fin;
    private Status status = new Status() ;
    private Categorie categogie;
    private ArrayList<Subtask> subtasks;
    
    
	/**
	 * @param title
	 * @param description
	 * @param dte_fin
	 * @param status
	 * @param categogie
	 * @param subtasks -> If wanted, otherwise there is a constructor which permit Task creation without subtasks
	 */
	public Task(Integer id, String title, String description, Date dte_fin, Categorie categogie, ArrayList<Subtask> subtasks) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dte_fin = dte_fin;
		this.status = new Status();
		this.categogie = categogie;
		this.subtasks = subtasks;
	}
	
    /**
     * @param title
     * @param description
     * @param dte_fin
     * @param status
     * @param catégogie
     */
    public Task(Integer id,String title, String description, Date dte_fin, Categorie categogie) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dte_fin = dte_fin;
		this.status = new Status();
		this.categogie = categogie;
	}
    
    @Override
    public String toString() {
        return title + "\n" + description;
    }
    
	public Integer getId() {
		return id;
	}

    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDte_fin() {
		return dte_fin;
	}

	public void setDte_fin(Date dte_fin) {
		this.dte_fin = dte_fin;
	}

	public String getStatusInfo() {
		return status.getStatusInfo();
	}

	public Status getStatus() {
		return status;
	}
	
	public void setStatusInfo(Integer status) {
		this.status.setStatusCode(status);
	}

	public Categorie getCategogie() {
		return categogie;
	}

	public void setCategogie(Categorie categogie) {
		this.categogie = categogie;
	}

	public List<Subtask> getSubtasks() {
		return subtasks;
	}

	public void setSubtasks(ArrayList<Subtask> subtasks) {
		this.subtasks = subtasks;
	}

	@Override
	public int compareTo(Task t) {
		if(this.dte_fin.after(t.dte_fin) ) {
			return -1;
		}
		return 1;
	}}