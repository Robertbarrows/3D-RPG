package com.base.game.characters.characteristics;

import com.base.game.RandomValue;
/**
 * 
 * @author Robert Barrows
 * @version 6/4/2016
 */
public class StatScale {
	public static final int STAMINA = 0;
	public static final int ATTACK_SPEED = 1;
//	public static final int UNKNOWN1 = 2;
//	public static final int UNKNOWN2 = 3;
	public static final int STRENGTH = 4;
	public static final int PHYSICAL_DEFENSE = 5;
	public static final int MAGIC = 6;
	public static final int MAGICAL_DEFENSE = 7;
	
	private static final int STAT_COUNT = 8;
	private static final double MINIMUM_STAT_SCALE = 0.125;
	private static final double MAXIMUM_STAT_BOOST = 0.25;
	
	private double[] values;
	private double[] statBoost;
	private RandomValue random;
	
	public StatScale(){
		values = new double[STAT_COUNT];
		statBoost = new double[STAT_COUNT];
		random = new RandomValue();
	}

	public void generateStatScale(){
		double sum = 0;
		
		for(int i = 0; i < STAT_COUNT; i++){
			double value = Math.abs(random.nextDouble());
			values[i] = value;
			sum += value;
		}
		
		//Normalize the Stat Scale
		for(int i = 0; i < STAT_COUNT; i++){
			values[i] /= sum;
			values[i] *= (1.0 - MINIMUM_STAT_SCALE * MINIMUM_STAT_SCALE * STAT_COUNT);
			values[i] += MINIMUM_STAT_SCALE * MINIMUM_STAT_SCALE;
			values[i] = Math.sqrt(values[i]);
		}
	}

	public double getScale(int stat){
		return values[stat] + (statBoost[stat] * MAXIMUM_STAT_BOOST);
	}
	public void addStatBoost(int stat, double boost){
		if(boost > 1){
			boost = 1;
		}
		if(boost < 0){
			boost = 0;
		}
		statBoost[stat] = boost;
	}
}
