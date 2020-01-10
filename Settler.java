public class Settler extends Unit {
	
	public Settler(Tile position, double hp, String faction) {
		super (position, hp, 2, faction);
	}

	@Override
	public void takeAction(Tile dopetile) {
		if (this.getPosition().equals(dopetile) && !dopetile.isCity()) {
			dopetile.foundCity();
			dopetile.removeUnit(this);
		}
	}
	
	public boolean equals(Object object) {
		if (super.equals(object)) {
			return true;
		}
		else {
			return false;
		}
	}

}
