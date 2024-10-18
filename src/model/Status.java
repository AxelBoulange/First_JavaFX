package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Status for a Task.
 */
public class Status {
	
	private String statusInfo;
	private int statusCode;
	
	@Override
	public String toString() {
		return statusInfo;
	}
	
	/**
	 * Status constructor with default "non commencé" Info.
	 */
	public Status() {
		super();
		this.setStatusCode(0);
	}
	
	/**
	 * Status constructor which permit to create a status with a status code. 
	 * @param statusCode
	 */
	public Status(int statusCode) {
		super();
		this.setStatusCode(statusCode);
	}
	
	/**
	 * @return info about status.
	 */
	public String getStatusInfo() {
		return statusInfo;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	private void setStatusInfo(int statusCode) {
		if(statusCode == 0) {statusInfo = "Non Commencé";}
		else if(statusCode == 1) {statusInfo = "En Cours";}
		else {statusInfo = "Terminée";}
	}

	/**
	 *  Set the status code and automatically the statusInfo string.
	 * @param statusCode -> have to be in [0;2] range.
	 */
	public void setStatusCode(int statusCode) {
		if (statusCode < 0 || statusCode > 2) {
			throw new IllegalArgumentException();
		}
		this.statusCode = statusCode;
		setStatusInfo(statusCode);
	}
	
	public static Status[] getStatusList() {
		return new Status[] {new Status(), new Status(1), new Status(2)};
	}
}
