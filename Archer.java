public class Archer extends MilitaryUnit{
	
	private int arrows;

	public Archer(Tile position, double hp, String faction) {
		
		super(position, hp, 2, faction, 15.0, 2, 0);
		this.arrows = 5;
		
	}
	
	public void takeAction(Tile dopetile) {
		if (this.arrows <= 0) {
			this.arrows = 5;
		} else {
			this.arrows--;
			super.takeAction(dopetile);
		}
	}
	
	public boolean equals(Object object) {
		if (super.equals(object)) {
			Archer input = (Archer) object;
			if (input.arrows == this.arrows) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
