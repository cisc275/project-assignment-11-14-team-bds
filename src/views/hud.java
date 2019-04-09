package views;
import entities.Powerup;
import entities.stick;

public class hud{
  miniMap map;
  stick sticks;
  Powerup powUp;
  
  public hud(miniMap map, stick sticks, Powerup powUp) {
	  this.map = map;
	  this.sticks = sticks;
	  this.powUp = powUp;
  }
  public hud() {}
  
  public miniMap getMap() {
	  return this.map;
  }
  
  public stick getSticks() {
	  return this.sticks;
  }
  
  public Powerup getPowUp() {
	  return this.powUp;
  }
  
  public void update() {}
}
