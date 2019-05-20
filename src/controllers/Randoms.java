package controllers;

import java.util.Random;

public final class Randoms {
	private static Random rand = new Random(123);
	
	public static void newRandomSeed() {
		rand = new Random();
	}
	
	public static int getRandomInt(int upperBound) {
		return rand.nextInt(upperBound);
	}
	
	public static void setSeed(long seed) {
		rand.setSeed(seed);
	}
}
