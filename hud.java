public class hud{
  miniMap map;
  stick sticks;
  powerUp powUp;
  
  public hud(miniMap map, stick sticks, powerUp powUp) {
	  this.map = map;
	  this.sticks = sticks;
	  this.powUp = powUp;
  }
  
  public miniMap getMap() {
	  return this.map;
  }
  
  public stick getSticks() {
	  return this.sticks;
  }
  
  public powerUp getPowUp() {
	  return this.powUp;
  }
  
  public void update() {}
}
