package data;

public enum Face {
	NORTH("NORTH"),
	EAST("EAST"),
	SOUTH("SOUTH"),
	WEST("WEST");
	
	private final String faceSide;
	
	Face(String faceSide){
		this.faceSide = faceSide;
	}
	
	public String getFaceSide() {
		return this.faceSide;
	}
}
