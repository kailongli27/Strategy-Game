public class ListOfUnits {

	private Unit arrayofunits[]; 
	private int size;
	
	public ListOfUnits() {
		this.arrayofunits = new Unit[10];
		this.size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public Unit[] getUnits() {
		
		int NotNulls = 0;
		
		for (int i = 0; i < this.arrayofunits.length; i ++) {
			if (this.arrayofunits[i] != null) {
				NotNulls ++;
			}
		}
		
		Unit finalarray[] = new Unit[NotNulls];
		
		for (int i = 0; i < NotNulls; i ++) {
			finalarray[i] = this.arrayofunits[i];
		}
		
		return finalarray;

	}
	
	public Unit get(int index) {
		
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index out of bounds!");
		} else {
			return this.arrayofunits[index];
		}
	}
	
	public void add(Unit unit) {
		if (this.size == this.arrayofunits.length) {
			int newcapacity = (this.arrayofunits.length) + ( (this.arrayofunits.length) / 2 ) + 1;
			Unit newarray[] = new Unit[newcapacity];
			for (int i = 0; i < this.arrayofunits.length; i++) {
				newarray[i] = this.arrayofunits[i];
			}
			newarray[this.arrayofunits.length] = unit;
			this.arrayofunits = newarray;
			this.size++;
		} else {
			this.arrayofunits[this.size] = unit;
			this.size++;
		}
	}
	
	public int indexOf(Unit someunit) {
		int someindex = -1;
		for (int i = 0; i < this.size; i ++) {
			if (this.arrayofunits[i].equals(someunit)) {
				someindex = i;
				break;
			}
		}
		return someindex;
	}
	
	public boolean remove(Unit toberemoved) {
		boolean foundandremoved = false;
		int removalindex = 0;
		for (int i = 0; i < this.size; i ++) {
			if (this.arrayofunits[i].equals(toberemoved)) {
				foundandremoved = true;
				removalindex = i;
				break;
			}
		}
		if (foundandremoved) {
			for (int i = removalindex; i < this.size; i ++) {
				this.arrayofunits[i] = this.arrayofunits[i + 1];
			}
			this.size --;
		}
		return foundandremoved;
	}
	
	public MilitaryUnit[] getArmy() {
		int countmilitary = 0;
		for (int i = 0; i < this.size; i++) {
			if (this.arrayofunits[i] instanceof Warrior || this.arrayofunits[i] instanceof Archer) {
				countmilitary ++;
			}
		}
		MilitaryUnit militaryunits[] = new MilitaryUnit[countmilitary];
		int j = 0;
		for (int i = 0; i < this.size; i++) {
			if (this.arrayofunits[i] instanceof Warrior || this.arrayofunits[i] instanceof Archer) {
				militaryunits[j] = (MilitaryUnit) this.arrayofunits[i];
				j++;
			}
		}
		return militaryunits;
	}


}
