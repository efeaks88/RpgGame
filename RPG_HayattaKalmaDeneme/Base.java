package RPG_HayattaKalmaDeneme;

public class Base extends NormalLoc{

	public Base(Player player) {
		super(player, "Base");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean getLocation() {
		player.setHealth(player.getBhealth());
		System.out.println("Canın fullendi hadi koş");
		System.out.println("Mevcut can = "+player.getBhealth());
		
		return true;
	}
	
}
