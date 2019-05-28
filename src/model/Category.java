package model;

public enum Category {
	LecheYDerivados("LecheYDerivados"),
	PatatasYLegumbres("PatatasYLegumbres"),
	GrasasYAceites("GrasasYAceites"), Bebidas("Bebidas"),
	BebidasAlcoholicas("BebidasAlcoholicas"),
	Frutas("Frutas"), 
	Verduras("Verduras"), 
	Jugos("Jugos"), 
	ConfiteriaDulce("ConfiteriaDulce"), 
	ConfiteriaSal("ConfiteriaSal"),  
	Granos("Granos"), 
	Harinas("Harinas"), 
	CerealesParaDesayuno("CerealesParaDesayuno"), 
	Pastas("Pastas"), 
	Panes("Panes"), 
	Endulzantes("Endulzantes"), 
	Condimentos("Condimentos"), 
	HierbasAromaticas("HierbasAromaticas"), 
	Salsas("Salsas"), 
	AlimentosParaBebes("AlimentosParaBebes"), 
	Limpieza("Limpieza"), 
	Higiene("Higiene");
	
	private final String description;
	
	Category(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
