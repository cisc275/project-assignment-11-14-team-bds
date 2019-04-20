package entities;

/* Provides a way to define different sets of bird properties as well as transfer them (i.e. when getting a powerup) */
public enum BirdProperties {
	DEFAULT(false, 1f),
	INVINCIBLE(true, 1f),
	SPEEDUP(false, 1.5f);
	
	protected final boolean invincible;
	protected final float speedMultiplier;
	
	private BirdProperties(boolean invincible, float speedMultiplier) {
		this.invincible = invincible;
		this.speedMultiplier = speedMultiplier;
	}
}
