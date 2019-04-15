package views;
import entities.Powerup;
import entities.Stick;

public class HUD{
  MiniMap map;
  Stick sticks;
  Powerup powUp;
  
  public HUD(MiniMap map, Stick sticks, Powerup powUp) {
	  this.map = map;
	  this.sticks = sticks;
	  this.powUp = powUp;
  }
  public HUD() {}
  
  public MiniMap getMap() {
	  return this.map;
  }
  
  public Stick getSticks() {
	  return this.sticks;
  }
  
  public Powerup getPowUp() {
	  return this.powUp;
  }
  
  public void update() {}
}
