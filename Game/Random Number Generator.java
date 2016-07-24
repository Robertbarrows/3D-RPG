package com.base.game;

/**
 * This class is used for random values.  This class duplicates
 * many of the programming of the Random Java Class but without
 * the serial requirement.
 * @author Robert Barrows
 * @version 6/4/2016
 */
public class RandomValue {
	private static final int STATE_SIZE = 16;
	
	private long[] state;
	private int index;
	/**
	 * 
	 */
	public RandomValue(){
		this((int) System.currentTimeMillis());
	}
	/**
	 * 
	 * @param seed
	 */
	public RandomValue(int seed){
		state = new long[STATE_SIZE];
		index = 0;
		
		setSeed(seed);
	}
	/**
	 * 
	 * @param seed
	 */
	private void setSeed(int seed){
		seed = Math.abs(seed);
		
		for(int i = 0; i < STATE_SIZE; i++){
			state[i] = (seed + 1) * ((seed + 1) << 2) * i;
		}
	}
	/**
	 * 
	 * @return
	 */
	public int nextInt() {
		return next(32);
	}
	/**
	 * 
	 * @param n
	 * @return
	 */
	public int nextInt(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("n must be positive");

		if ((n & -n) == n)  // i.e., n is a power of 2
		    return (int)((n * (long)next(31)) >> 31);

		int bits, val;
		do {
		    bits = next(31);
		    val = bits % n;
		} while (bits - val + (n-1) < 0);
		return val;
	}
	/**
	 * 
	 * @return
	 */
	public long nextLong() {
		return ((long)next(32) << 32) + next(32);
	}
	/**
	 * 
	 * @return
	 */
	public float nextFloat() {
		return next(24) / ((float)(1 << 24));
	}
	/**
	 * 
	 * @return
	 */
	public double nextDouble() {
		return (((long)next(26) << 27) + next(27))
		     / (double)(1L << 53);
	}
	/**
	 * 
	 * @return
	 */
	public boolean nextBoolean() {
		return next(1) != 0;
	}
	/**
	 * 
	 * @param nbits
	 * @return
	 */
	protected int next(int nbits){
		long a, b, c, d;
		a = state[index];
		c = state[(index+13)&15];
		b = a^c^(a<<16)^(c<<15);
		c = state[(index+9)&15];
		c ^= (c>>11);
		a = state[index] = b^c;
		d = a^((a<<5)&0xDA442D24L);
		index = (index + 15)&15;
		a = state[index];
		state[index] = a^b^d^(a<<2)^(b<<18)^(c<<28);
		return (int) state[index];
	}
}
