package RPG_HayattaKalmaDeneme;

import java.util.Random;

public class Enemy {
	
	private String name;
	private int damage;
	private int health;
	private int gold;
	private int wave;
	
	public Enemy(String name, int damage, int health, int gold, int wave) {
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.gold = gold;
		this.wave = wave;
	}
	
	public int EnemyWaveCount() {
		Random rnd = new Random();
		return rnd.nextInt(0,this.wave)+1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getWave() {
		return wave;
	}

	public void setWave(int wave) {
		this.wave = wave;
	}
	
	
	
}
