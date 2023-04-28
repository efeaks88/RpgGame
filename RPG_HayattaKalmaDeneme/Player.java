package RPG_HayattaKalmaDeneme;

import java.util.Random;
import java.util.Scanner;

public class Player {
	Market m1=new Market(null);
	Scanner sc = new Scanner(System.in);
	private int damage;
	private int health;
	private int money;
	private int bhealth;
	private String name;
	private String cName;
	private Inventory inventory;
	
	public Player(String name) {
		super();
		this.name = name;
		this.inventory=new Inventory();
	}
	
	public void selectCharachter() {
		Random rd = new Random();
		switch (chaMenu()) {
		case 1:
			System.out.println("Yasuo seçtiniz. ");
			initPlayer("Yasuo", 10, 30, 50);
			break;
		case 2:
			System.out.println("Ryze seçtiniz. ");
			initPlayer("Ryze", 1, 35, 51);
			break;
		case 3:
			System.out.println("Ashe seçtiniz. ");
			initPlayer("Ashe", 12, 25, 50);
			break;
		default:
			System.out.println("Hiç birşey seçmediniz rastgele karakter veriliyor. ");
			initPlayer("Ryze", 1, 35, 50);
			break;
		}
		System.out.println("Karakteriniz =======>>> Isim = "+getcName()+" Hasar "+getDamage()+" Can "+getHealth());
	}
	
	private int chaMenu() {
		System.out.println("Lütfen bir lol karakteri seçiniz.");
		System.out.println("1-> Yasuo ; ");
		System.out.println(" __-----_________________{]__________________________________________________\r\n"
				+ "{&&&&&&&#%%&#%&%&%&%&%#%&|]__________________________________________________\\\r\n"
				+ "                         {]");
		System.out.println("AD = 10, Can : 30, Para: 50");
		m1.boslukGetir();
		System.out.println("2-> Ryze ; ");
		System.out.println("            ,    _\r\n"
		+ "           /|   | |\r\n"
		+ "         _/_\\_  >_<\r\n"
		+ "        .-\\-/.   |\r\n"
		+ "       /  | | \\_ |\r\n"
		+ "       \\ \\| |\\__(/\r\n"
		+ "       /(`---')  |\r\n"
		+ "      / /     \\  |\r\n"
		+ "   _.'  \\'-'  /  |\r\n"
		+ "   `----'`=-='   ' ");
		System.out.println("AD = 1,Can :35, Para:50 ");
		System.out.println("Doğal olarak ap ile güçleniyor.");
		m1.boslukGetir();
		System.out.println("3-> Ashe ;");
		System.out.println(">>>>>>>_____________________\\`-._\r\n"
				+ ">>>>>>>                     /.-'");
		System.out.println("AD = 12,Can :25, Para:50 ");
		
		System.out.println("Lütfen sayı olarak seçim yapınız.");
		int chaID=sc.nextInt(); sc.nextLine();
		try {
			if (chaID<1||chaID>3) {
				throw new ExceptionThings("Girilen sayı 1 ile 3 arasında olmalıdır. Bu sebeple rastgele karakter verilecek.");
			}else {
				return chaID;
			}
		} catch (ExceptionThings e) {
			System.out.println(e.getMessage());
		}

		return chaID;
		
	}
	
	
	public int getTotalDamage() {
		return this.getDamage()+this.getInv().getAdapDamage();
	}
	
	
	public void initPlayer(String cName,int dmg,int health,int money) {
		setcName(cName);
		setDamage(dmg);
		setHealth(health);
		setMoney(money);
		setBhealth(health);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inventory;
	}

	public void setInv(Inventory inv) {
		this.inventory = inv;
	}

	public int getBhealth() {
		return bhealth;
	}

	public void setBhealth(int bhealth) {
		this.bhealth = bhealth;
	}
	
}
