package model;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
	
	private String categorieInfo;
	private int categorieCode;
	
	@Override
	public String toString() {
		return categorieInfo;
	}
	
	public Categorie() {
		super();
		this.setCategorieCode(0);
	}
	
	public Categorie(int categorieCode) {
		super();
		this.setCategorieCode(categorieCode);
	}
	
	public String getCategorieInfo() {
		return categorieInfo;
	}
	public Integer getCategorieCode() {
		return categorieCode;
	}
	
	private void setCategorieInfo(int categorieCode) {
		categorieInfo = "Categorie" + categorieCode;
	}

	public void setCategorieCode(int categorieCode) {
		if (categorieCode < 0 || categorieCode > 2) {
			throw new IllegalArgumentException();
		}
		this.categorieCode = categorieCode;
		setCategorieInfo(categorieCode);
	}
	
	public static Categorie[] getCategorieList() {
		return new Categorie[] {new Categorie(), new Categorie(1), new Categorie(2)};
	}
}
