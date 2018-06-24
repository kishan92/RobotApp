package data;

public class Board {
	
	private static final String MISSING_ROBOT = "ROBOT MISSING";
	private static final int MAX_X = 5;
	private static final int MAX_Y = 5;
	
	private Position position;
	
	public void update(int x, int y, String faceSide) {
		
		Position position = new Position.Builder()
										.withPosXAxis(x)
										.withPosYAxis(y)
										.withFaceSide(faceSide)
										.build();
		
		if( this.validPosition(position)) {
			this.position = position;
		}
	}
	
	public void move() {

		if( this.position == null) {
			return;
		}

		int displaceMentX = 0;
		int displaceMentY = 0;
		
		switch (Face.valueOf(this.position.getFaceSide())) {
		case NORTH:
			displaceMentY = 1;
			break;
		case EAST:
			displaceMentX = 1;
			break;
		case SOUTH:
			displaceMentY = -1;
			break;
		case WEST:
			displaceMentX = -1;
			break;
		default:
			break;
		}
		
		this.update( this.position.getPositionXAxis() + displaceMentX, 
				     this.position.getPositionYAxis() + displaceMentY, 
				     this.position.getFaceSide());
	}
	
	public void turnLeft() {
		if( this.position == null) {
			return;
		}
		
		String newFaceSide = "";
		
		switch (Face.valueOf(this.position.getFaceSide())) {
		case NORTH:
			newFaceSide = Face.WEST.getFaceSide();
			break;
		case EAST:
			newFaceSide = Face.NORTH.getFaceSide();
			break;
		case SOUTH:
			newFaceSide = Face.EAST.getFaceSide();
			break;
		case WEST:
			newFaceSide = Face.SOUTH.getFaceSide();
			break;
		default:
			break;
		}
	
		this.update( this.position.getPositionXAxis(), 
			     this.position.getPositionYAxis(), 
			     newFaceSide);
	}

	public void turnRight() {
		if( this.position == null) {
			return;
		}
		
		String newFaceSide = "";
		
		switch (Face.valueOf(this.position.getFaceSide())) {
		case NORTH:
			newFaceSide = Face.EAST.getFaceSide();
			break;
		case EAST:
			newFaceSide = Face.SOUTH.getFaceSide();
			break;
		case SOUTH:
			newFaceSide = Face.WEST.getFaceSide();
			break;
		case WEST:
			newFaceSide = Face.NORTH.getFaceSide();
			break;
		default:
			break;
		}
	
		this.update( this.position.getPositionXAxis(), 
			     this.position.getPositionYAxis(), 
			     newFaceSide);
	}
	
	
	public String report() {
		if( this.position == null) {
			return MISSING_ROBOT;
		}
		return this.position.toString();
	}
	
	private Boolean validPosition(Position position) {
		
		if( position.getPositionXAxis() > MAX_X || position.getPositionXAxis() < 1 ) {
			return false;
		}
		
		if( position.getPositionYAxis() > MAX_Y || position.getPositionYAxis() < 1 ) {
			return false;
		}
		
		if( position.getFaceSide() == null) {
			return false;
		}
		if( Face.valueOf(position.getFaceSide()) == null ) {
			return false;
		}
		return true;
	}
	

}