package RPG_HayattaKalmaDeneme;

import java.util.Scanner;


public class Game {
	Market m1=new Market(null);
	static Scanner sc =new Scanner(System.in);
	Player player;
	Location location;
	
	public void login() {
		System.out.println("╦ ╦┌─┐┬  ┌─┐┌─┐┌┬┐┌─┐  ┌┬┐┌─┐  ╦═╗╔═╗╔═╗  ╔═╗┌─┐┌┬┐┌─┐\r\n"
						 + "║║║├┤ │  │  │ ││││├┤    │ │ │  ╠╦╝╠═╝║ ╦  ║ ╦├─┤│││├┤ \r\n"
						 + "╚╩╝└─┘┴─┘└─┘└─┘┴ ┴└─┘   ┴ └─┘  ╩╚═╩  ╚═╝  ╚═╝┴ ┴┴ ┴└─┘");
		
		System.out.print("Oyuna başlamadan önce isminizi giriniz.");
		String playerName=sc.nextLine();
		player = new Player(playerName);
		player.selectCharachter();
		
		start();
	}

	private void start() {
		m1.boslukGetir();
		m1.boslukGetir();
		while(true) {
			System.out.println();

			System.out.println();
			System.out.println("Eylem gerçekleştirmek için seçim yapınız.");
			System.out.println("1. Base Atmak(üsse dönmek)");
			System.out.println("2. Mide git -->Burada minyon kesilir. Para kasılır.");
			System.out.println("3. Ormana git -->O şampiyonla jg yapılır mı bilmem ama go on");
			System.out.println("4. Baron kesmeye git --> Mini boss");
			
			System.out.println("5. Base atıp mağazaya tıklama eylemi. Item almak için");
			
			int selectLoc=sc.nextInt(); sc.nextLine();
			//go to burada denemeyi çok isterdim. Try catch ile sarmalamayı sonra go to metodunu yazmayı.
			
			while (selectLoc<0||selectLoc>6) {
				System.out.println("Lütfen geçerli bir yer seçiniz.");
				selectLoc=sc.nextInt();
			}
			switch (selectLoc) {
			case 1:
				location=new Base(player);
				break;
			case 2:
				location=new Lane(player);
				break;
			case 3:
				location=new Jungle(player);
				break;
			case 4:
				location=new BaronSıde(player);
				break;
			case 5:
				location=new Market(player);
				break;
			default:
				location=new Base(player);
				break;
			}
			if (location.getName().equals("Base")) {
				if (player.getInv().isBaronKesildi()&&player.getInv().isBuffAlindi()&&player.getInv().isCsKasildi()) {
					System.out.println("Tüm ödüller kontrol ediliyor.....");
					System.out.println("OYUN BİTTİ 20 LP KAZANDIK AMA ÖMRÜMÜZDEN 40DK GİTTİ");
					break;
				}
			}
			if(!location.getLocation()) {
				System.out.println("  #####     #    #     # #######    ####### #     # ####### ######      #    ## \r\n"
						+ " #     #   # #   ##   ## #          #     # #     # #       #     #    ###  #   \r\n"
						+ " #        #   #  # # # # #          #     # #     # #       #     #     #  #    \r\n"
						+ " #  #### #     # #  #  # #####      #     # #     # #####   ######         #    \r\n"
						+ " #     # ####### #     # #          #     #  #   #  #       #   #       #  #    \r\n"
						+ " #     # #     # #     # #          #     #   # #   #       #    #     ###  #   \r\n"
						+ "  #####  #     # #     # #######    #######    #    ####### #     #     #    ## \r\n"
						+ "                                                                                ");
				break;
				
			}
			
		}
		
	}
	
	
}
