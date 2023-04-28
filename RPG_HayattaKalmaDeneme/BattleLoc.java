package RPG_HayattaKalmaDeneme;

public abstract class BattleLoc extends Location {
	protected Enemy enemy;
	protected String reward;

	public BattleLoc(Player player, String name, Enemy enemy, String reward) {

		super(player);
		this.enemy = enemy;
		this.name = name;
		this.reward = reward;
	}

	public boolean getLocation() {
		int enemyCount = enemy.EnemyWaveCount();
		System.out.println("Geldiğimiz yer : " + this.getName());
		System.out.println("Buraya " + enemyCount + " tane" + enemy.getName() + "  var. ");
		System.out.print("Savaş veya kaç. (savaşmak için s kaçmak için herhangi bir tuş.)");
		String secim = sc.nextLine();
		secim = secim.toLowerCase();
		if (secim.equals("s")) {
			if (combat(enemyCount)) {
				System.out.println(this.getName() + " Koridorundaki tüm birimler temizlendi.");
				System.out.println();
				System.out.println();
				if (this.reward.equals("csKasildi") && player.getInv().isCsKasildi() == false) {
					System.out.println(" Bu koridorun ödülü Kazanıldı");
					player.getInv().setCsKasildi(true);
				} else if (this.reward.equals("redAndBlueBuff") && player.getInv().isBuffAlindi() == false) {
					System.out.println(this.reward + "  Bu koridorun ödülü Kazanıldı");
					player.getInv().setBuffAlindi(true);
				} else if (this.reward.equals("BaronBuff") && player.getInv().isBaronKesildi() == false) {
					System.out.println(this.reward + "  Bu koridorun ödülü Kazanıldı");
					player.getInv().setBaronKesildi(true);
				}
				return true;
			}
			if (player.getHealth() <= 0) {
				System.out.println("Öldünüz... Takım birazdan flame atmaya başlayacaktır.");
				return false;
			}
		}
		return true;

	}

	public boolean combat(int enemyCount) {
		for (int i = 0; i < enemyCount; i++) {
			System.out.println();
			System.out.println();
			int defEnemyHealth = enemy.getHealth();
			System.out.println("***********" + player.getcName() + "*****************");
			playerStats();
			System.out.println("***********DÜŞMAN*****************");
			enemyStats();
			while (player.getHealth() > 0 && enemy.getHealth() > 0) {
				System.out.print("Vur veya dodge at. (vurmak için v kaçmak için klavyeye kafa at)");
				String secim = sc.nextLine();
				secim = secim.toLowerCase();
				if (secim.equals("v")) {
					System.out.println("Hit atıldı");
					enemy.setHealth(enemy.getHealth() - player.getTotalDamage());
					afterHit();
					if (enemy.getHealth() > 0) {
						System.out.println();
						System.out.println(enemy.getName() + " vuruyor."); // canım - creep hasarı + armor
						//burada bug buldum ama uykum var yarın düzeltirim ******** if>0 şeysi
						player.setHealth(player.getHealth() - (enemy.getDamage() - player.getInv().getArmor()));
						afterHit();
						System.out.println();

					}
				} else {
					return false;
				}
			}
			// if (enemy.getHealth() < 0 && player.getHealth() > 0) {
			if (enemy.getHealth() < player.getHealth()) {
				System.out.println("Birim öldürüldü.");
				System.out.println();
				System.out.println();
				player.setMoney(player.getMoney() + enemy.getGold());

				enemy.setHealth(defEnemyHealth);
				System.out.println("Güncel gold miktarı." + player.getMoney());
				// return true;
			} else {
				return false;
			}
			System.out.println("----------------------");

		}

		return true;
	}

	public void playerStats() {
		System.out.println("Sihirdar Bilgileri");
		System.out.println("Can barı = " + player.getHealth());
		System.out.println("Ad/Ap Hasarı = " + player.getTotalDamage());
		System.out.println("Para = " + player.getMoney());
		if (player.getInv().getAdapDamage() > 0) {
			System.out.println("Sahip olunan Ofansif itemler  = " + player.getInv().getAdapItems());
		}
		if (player.getInv().getArmor() > 0) {
			System.out.println("Sahip olunan Defansif itemler  = " + player.getInv().getArmor());
		}
	}

	public void enemyStats() {
		System.out.println(enemy.getName() + " Değerleri ");
		System.out.println("Can = " + enemy.getHealth());
		System.out.println("Hasar = " + enemy.getDamage());
		System.out.println("Ödül = " + enemy.getGold());
	}

	public void afterHit() {
		System.out.println();
		System.out.println("Oyuncu kalan can  = " + player.getHealth());
		System.out.println(enemy.getName() + " canı = " + enemy.getHealth() + " Kaldı.");
		System.out.println();
	}
}
