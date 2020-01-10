public abstract class MilitaryUnit extends Unit {
	
	private double attackdamange;
	private int attackrange;
	private int armor;

	public MilitaryUnit(Tile position, double hp, int range, String faction, double attackdamage, int attackrange, int armor) {
		super (position, hp, range, faction);
		this.attackdamange = attackdamage;
		this.attackrange = attackrange;
		this.armor = armor;
	}
	
	public void takeAction(Tile dopetile) {
		if (Tile.getDistance(dopetile, this.getPosition()) < this.attackrange + 1) {
			if (dopetile.selectWeakEnemy(this.getFaction()) != null) {
				if (this.getPosition().isImproved()) {
					dopetile.selectWeakEnemy(this.getFaction()).receiveDamage(this.attackdamange + 0.05 * this.attackdamange);
				} else {
					dopetile.selectWeakEnemy(this.getFaction()).receiveDamage(this.attackdamange);
				}
			}
		}
	}
	
	public void receiveDamage(double damage) {
		double multiplier = 100/(100 + this.armor);
		double realdamage = multiplier * damage;
		super.receiveDamage(realdamage);
	}

}
