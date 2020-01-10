public class Tile {
	
	private int x;
	private int y;
	private boolean city;
	private boolean improvements;
	private ListOfUnits listofunits;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		this.city = false;
		this.improvements = false;
		this.listofunits = new ListOfUnits();
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean isCity() {
		return this.city;
	}
	
	public boolean isImproved() {
		return this.improvements;
	}
	
	public void foundCity() {
		this.city = true;
	}
	
	public void buildImprovement() {
		this.improvements = true;
	}
	
	public boolean addUnit(Unit unit) {
		boolean added = true;
		if (unit instanceof Warrior || unit instanceof Archer) {
			for (int i = 0; i < this.listofunits.size(); i++) {
				if (!this.listofunits.get(i).getFaction().equals(unit.getFaction())) {
					added = false;
					break;
				}
			}
			if (added) {
				this.listofunits.add(unit);
			}
		}	
		else {
			this.listofunits.add(unit);
		}
		return added;
	}
	
	public boolean removeUnit(Unit toberemoved) {
		return this.listofunits.remove(toberemoved);
	}
	
	public Unit selectWeakEnemy(String faction) {
		int enemyCount = 0;
		for (int i = 0; i < this.listofunits.size(); i ++) {
			if (!this.listofunits.get(i).getFaction().equals(faction)) {
				enemyCount++;
			}
		}
		if (enemyCount == 0) {
			return null;
		}
		else {
			Unit enemyArray[] = new Unit[enemyCount];
			int k = 0;
			for (int i = 0; i < this.listofunits.size(); i ++) {
				if (!this.listofunits.get(i).getFaction().equals(faction)) {
					enemyArray[k] = this.listofunits.get(i);
					k++;
				}
			}
			Unit weakenemy = this.listofunits.get(0);
			for (int i = 1; i < enemyArray.length; i ++) {
				if (enemyArray[i].getHP() < weakenemy.getHP()) {
					weakenemy = enemyArray[i];
				}
			}
			return weakenemy;
		}
	}
	
	public static double getDistance(Tile tile1, Tile tile2) {
		double distance;
		distance = Math.sqrt( Math.pow(tile1.x - tile2.x, 2) + Math.pow(tile1.y - tile2.y, 2) );
		return distance;
	}
	
}
