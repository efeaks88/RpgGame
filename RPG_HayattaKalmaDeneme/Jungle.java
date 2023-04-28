package RPG_HayattaKalmaDeneme;

public class Jungle extends BattleLoc{

	public Jungle(Player player) {
		super(player, "Blue side",new JungleEnemies(),"redAndBlueBuff");
	}
	
	
}
