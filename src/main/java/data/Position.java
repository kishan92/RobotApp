package data;

public class Position {

	private final int posXAxis;
	private final int posYAxis;
	private final String faceSide;
	
	private Position(Builder builder) {
		this.posXAxis = builder.posXAxis;
		this.posYAxis = builder.posYAxis;
		this.faceSide = builder.faceSide;
	}
	
	public int getPositionXAxis() {
		return this.posXAxis;
	}

	public int getPositionYAxis() {
		return this.posYAxis;
	}
	
	public String getFaceSide() {
		return this.faceSide;
	}
	
	public static class Builder{
		
		private int posXAxis = 1;
		private int posYAxis = 1;
		private String faceSide = Face.NORTH.getFaceSide();
		
		public Builder withPosXAxis(int pos) {
			this.posXAxis = pos;
			return this;
		}
		public Builder withPosYAxis(int pos) {
			this.posYAxis = pos;
			return this;
		}
		public Builder withFaceSide(String faceSide) {
			this.faceSide = faceSide;
			return this;
		}

		public Position build() {
			return new Position(this);
		}
	}
	
	@Override
	public String toString() {
		return this.posXAxis + "," + this.posYAxis + "," + this.faceSide;
	}
}
