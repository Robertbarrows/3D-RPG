package com.base.game.characters.characteristics;

public class Stats {
	public static final int MAX_LEVEL = 99;
	public static final int MAX_EXPERIENCE = 999999;
	public static final double LEVEL_CONSTANT = (double) MAX_EXPERIENCE / ((double) MAX_LEVEL * (double) MAX_LEVEL);
	
	private boolean isLevelAble;
	private int level;
	private StatScale scale;
	private float experience;
	private int health;
	
	public Stats(float xp, boolean levelable){
		isLevelAble = levelable;
		scale = new StatScale();
		
		if(isLevelAble){
			experience = xp;
			level = 1;
		}else{
			experience = -1;
			level = (int) xp;
		}
		health = getMaxHealth();
	}
	public int getLevel(){
		
		if(!isLevelAble){
			return level;
		}
		
		return (int) Math.sqrt((double) experience/LEVEL_CONSTANT) + 1;
	}
	public float getMovementSpeed(){
		return 4f;
	}
	//TODO: UPDATE STATS.
	public float getAttackSpeed(){
		return 4f;
	}
	public float getCurrentHealth(){
		return 4f;
	}
	public int getMaxHealth(){
		return 4;
	}
	public float getStrength(){
		return 4f;
	}
	public float getPhysicalDefense(){
		return 4f;
	}
	public float getMagic(){
		return 4f;
	}
	public float getMagicDefense(){
		return 4f;
	}
	public void addexperience(float amt){
		experience += amt;
		if(experience > MAX_EXPERIENCE){
			experience = MAX_EXPERIENCE;
		}
	}
}
