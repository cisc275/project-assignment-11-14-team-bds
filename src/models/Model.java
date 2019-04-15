package models;

import java.util.*;
import entities.*;


public abstract class Model {
  public abstract void start();
  public abstract void updateCollidables();
  public abstract Collection<Collidable> getEntities(); 
  
}