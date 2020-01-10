public abstract class Unit {
	
	private Tile position;
	private double hp;
	private int range;
	private String faction;
	
	public Unit(Tile position, double hp, int range, String faction) {
		this.position = position;
		this.hp = hp;
		this.range = range;
		this.faction = faction;
		
		if (!position.addUnit(this)) {
			throw new IllegalArgumentException();
		}
	}
	
	public final Tile getPosition() {
		return this.position;
	}
	
	public final double getHP() {
		return this.hp;
	}
	
	public final String getFaction() {
		return this.faction;
	}
	
	public boolean moveTo(Tile where) {
		boolean moved = false;
		if (Tile.getDistance(this.getPosition(), where) >= this.range + 1) {
			moved = false;
		}
		else {
			if (where.addUnit(this)) {
				this.getPosition().removeUnit(this);
				this.position = where;
				moved = true;
			}
		}
		return moved;
	}
	
	public void receiveDamage(double damage) {
		if (this.getPosition().isCity()) {
			double reduceddamage = damage - 0.1 * damage;
			this.hp = this.hp - reduceddamage;
		} else {
			this.hp = this.hp - damage;
		}
		if (this.hp <= 0) {
			this.getPosition().removeUnit(this);
		}
	}
	
	public abstract void takeAction(Tile dopetile);
	
	public boolean equals(Object object) {
		Unit input = (Unit) object;
		if (this.getClass().equals(input.getClass()) && this.getFaction().equals(input.getFaction()) && this.getHP() == input.getHP() && this.getPosition().equals(input.getPosition())) {
			return true;
		} else {
			return false;
		}
	}
	
}
