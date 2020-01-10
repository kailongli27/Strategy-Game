public class Worker extends Unit {
	
	private int jobs;

	public Worker(Tile position, double hp, String faction) {
		super (position, hp, 2, faction);
		this.jobs = 0;
	}

	@Override
	public void takeAction(Tile dopetile) {
		if (this.getPosition().equals(dopetile) && !dopetile.isImproved()) {
			dopetile.buildImprovement();
			this.jobs ++;
			if (this.jobs >= 10) {
				dopetile.removeUnit(this);
			}
		}
	}
	
	public boolean equals(Object someobject) {
		if (super.equals(someobject)) {
			Worker input = (Worker) someobject;
			if (this.jobs == input.jobs) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
