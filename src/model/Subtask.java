/**
 * 
 */
package model;

/**
 * Is used to create steps in tasks.
 */
public class Subtask {

	private Integer id;
	private String name;
	private String description;

	public Integer getId() {
		return id;
	}
	
	public String getNameString() {
		return name;
	}

	private void setNameString(String nameString) {
		this.name = nameString;
	}

	public String getDescriptionString() {
		return description;
	}

	private void setDescriptionString(String descriptionString) {
		this.description = descriptionString;
	}

	
	/**
	 * Subtask constructor
	 */
	public Subtask(Integer id, String nom, String description) {
		this.setDescriptionString(description);
		this.setNameString(nom);
		this.id = id;
	}

}
