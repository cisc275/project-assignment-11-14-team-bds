package models;

import entities.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class OspreyTutorial extends OspreyModel {
    private boolean move = false;
    private boolean dive = false;

    private Tree t;
    private Pond p;
    public OspreyTutorial() {
        super();
        for (int i = 0; i < 500; i++) {
            super.updateCollidables();
        }

        System.out.println(entities);
        player.setLoc(320,200);
    }
    @Override
    public boolean checkGameState(int dur) {
        return false;
    }

    @Override
    public void updateCollidables() {
        prevX = player.getX();
        prevY = player.getY();
        player.update();
        Collections.sort(entities);
        if (!move) {
            //Display message saying how to move and how you should stay on the path
            Iterator<Collidable> i = entities.iterator();
            while (i.hasNext()){
                Collidable c = i.next();
            }
            if (pathHandler.collideWith(player)) {
                System.out.println("update");
                move = true;

            }
        } else if (!dive) {
            //This is a tree, hitting a tree hurt, dodge the tree while staying on the path
            //Wind pushes you
            //hit the tree
            for (Collidable c : entities) {
                if (player.collideWith(c)) {
                    if (c instanceof Pond) {
                        if (player.isDiving()) {
                            System.out.println("update");
                            dive = true;
                        }
                    }
                }
            }
        }
    }
}
