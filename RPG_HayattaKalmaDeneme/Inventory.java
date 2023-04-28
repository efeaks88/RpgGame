package RPG_HayattaKalmaDeneme;

public class Inventory {
	private boolean csKasildi;
	private boolean buffAlindi;
	private boolean baronKesildi;
	
	private String adapItems;
	private String canItems;
	
//	private int weapons;
//	private int armors;
	
	private int adapDamage;
	private int Armor;
	
	Inventory(){
		this.csKasildi=false;
		this.buffAlindi=false;
		this.baronKesildi=false;
		this.adapDamage=0;
		this.Armor=0;
		this.adapItems=null;
		this.canItems=null;
	}

	public boolean isCsKasildi() {
		return csKasildi;
	}

	public void setCsKasildi(boolean csKasildi) {
		this.csKasildi = csKasildi;
	}

	public boolean isBuffAlindi() {
		return buffAlindi;
	}

	public void setBuffAlindi(boolean buffAlindi) {
		this.buffAlindi = buffAlindi;
	}

	public boolean isBaronKesildi() {
		return baronKesildi;
	}

	public void setBaronKesildi(boolean baronKesildi) {
		this.baronKesildi = baronKesildi;
	}

	public String getAdapItems() {
		return adapItems;
	}

	public void setAdapItems(String adapItems) {
		this.adapItems = adapItems;
	}

	public String getCanItems() {
		return canItems;
	}

	public void setCanItems(String canItems) {
		this.canItems = canItems;
	}

	public int getAdapDamage() {
		return adapDamage;
	}

	public void setAdapDamage(int adapDamage) {
		this.adapDamage = adapDamage;
	}

	public int getArmor() {
		return Armor;
	}

	public void setArmor(int armor) {
		this.Armor = armor;
	}
	
}
