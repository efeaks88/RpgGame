package RPG_HayattaKalmaDeneme;

public class Market extends NormalLoc {

	public Market(Player player) {
		super(player, "Mağaza");

	}

	public boolean getLocation() {
		boslukGetir();
		System.out.println("Para: " + getPlayer().getMoney());
		System.out.println("1. Ad/Ap itemleri");
		System.out.println("2. Can itemleri");
		System.out.println("3. Çıkış");
		System.out.println("Item seçimi yapın.");
		int secim = sc.nextInt();
		sc.nextLine();
		int secimItemId;
		switch (secim) {
		case 1:
			secimItemId = itemMenu();
			buyItem(secimItemId);
			break;
		case 2:
			secimItemId = armorMenu();
			buyArmor(secimItemId);
			break;
		default:
			break;
		}
		return true;
	}

	public int armorMenu() {
		System.out.println("1. Randuin Alameti <Gold : 50 - Zırh :7>");
		System.out.println("2. Warmog'un zırhı <Gold : 90 - Zırh :16>");
		System.out.println("3. Çivili Zırh <Gold : 100 - Zırh :20>");
		System.out.println("4. Çıkış");
		int secimItemId = sc.nextInt();
		sc.nextLine();
		return secimItemId;
	}

	public void buyArmor(int itemID) {
		int armor = 0, fiyat = 0;
		String aName = null;
		switch (itemID) {
		case 1:
			armor = 7;
			aName = "Randuin Alameti";
			fiyat = 50;
			break;
		case 2:
			armor = 16;
			aName = "Warmog'un Zırhı";
			fiyat = 90;
			break;
		case 3:
			armor = 20;
			aName = "Çivili Zırh";
			fiyat = 100;

			break;
		case 4:
			System.out.println("Çıkış yapılıyor.");
		default:
			System.out.println("Geçersiz item ! biliyorum daha fazla item var ama hepsine üşendim");
			break;
		}
		if (player.getMoney() > fiyat) {
			player.getInv().setArmor(armor);
			player.getInv().setCanItems(aName);
			player.setMoney(player.getMoney() - fiyat);
			System.out.println(aName + "Item satın alındı, Yeni Zırh değeri : " + player.getInv().getArmor());
			System.out.println("Kalan Gold : " + player.getMoney());
		} else {
			boslukGetir();
			System.out.println("Biraz daha minyon kesmelisin niye hemen base attın ki.");
		}

	}

	public int itemMenu() {
		boslukGetir();
		if (player.getcName().equals("Yasuo") || player.getcName().equals("Ashe")) {
			System.out.println("1. Bombardıman Topu <Gold : 80 - Hasar :5>");
			System.out.println("2. Kana Susamış <Gold : 90 - Hasar :10>");
			System.out.println("3. Ebedi kılıç <Gold : 100 - Hasar :14>");
			System.out.println("4. Çıkış");
			int secimItemId = sc.nextInt();
			sc.nextLine();
			return secimItemId;
		} else {
			System.out.println("1. Asırlık Sopa <Gold : 50 - Hasar :20>");
			System.out.println("2. Zhonya'nın kumsaati <Gold : 90 - Hasar :30>");
			System.out.println("3. Rabadonun şapkası <Gold : 120 - Hasar :50>");
			System.out.println("4. Çıkış");
			int secimItemId = sc.nextInt();
			sc.nextLine();
			return secimItemId;
		}
	}

	public void buyItem(int itemId) {
		int damage = 0;
		int fiyat = 0;
		String iName = null;
		if (player.getcName().equals("Yasuo") || player.getcName().equals("Ashe")) {
			switch (itemId) {
			case 1:
				damage = 5;
				iName = "Bombardıman Topu";
				fiyat = 80;
				break;
			case 2:
				damage = 10;
				iName = "Kana Susamış";
				fiyat = 90;
				break;
			case 3:
				damage = 14;
				iName = "Ebedi Kılıç";
				fiyat = 100;
				break;
			case 4:
				System.out.println("Base den çıkış yapılıyor.");
				break;
			default:
				System.out.println("Geçersiz item ! biliyorum daha fazla item var ama hepsine üşendim");
				break;
			}

		} else {
			switch (itemId) {
			case 1:
				damage = 20;
				iName = "Asırlık Sopa";
				fiyat = 50;
				break;
			case 2:
				damage = 30;
				iName = "Zhonya'nın kumsaati";
				fiyat = 90;
				break;
			case 3:
				damage = 50;
				iName = "Rabadon'un şapkası";
				fiyat = 120;
				break;
			case 4:
				System.out.println("Base den çıkış yapılıyor.");
				break;
			default:
				System.out.println("Geçersiz item ! biliyorum daha fazla item var ama hepsine üşendim");
				break;
			}
		}
		if (fiyat > 0) {
			if (player.getMoney() >= fiyat) {
				player.getInv().setAdapDamage(damage);
				player.getInv().setAdapItems(iName);
				player.setMoney(player.getMoney() - fiyat);
				System.out.println(iName + "Item satın alındı, Onceki hasar : " + player.getDamage()
						+ " , Yeni hasar : " + (player.getTotalDamage()));
				System.out.println("Kalan Gold : " + player.getMoney());
			} else {
				boslukGetir();
				System.out.println("Biraz daha minyon kesmelisin niye hemen base attın ki.");
			}
		}

	}

	public void boslukGetir() {
		System.out.println();
		System.out.println();
		System.out.println();
	}
}
