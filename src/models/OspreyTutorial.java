package models;

import entities.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class OspreyTutorial extends OspreyModel {
    private boolean path = false;
    private boolean trees = false;
    private boolean fish = false;

    private Tree t;
    private Pond p;
    public OspreyTutorial() {
        super();
        for (int i = 0; i < 500; i++) {
            super.updateCollidables();
        }
        entities.removeIf((c) -> ((c instanceof Pond) || (c instanceof Tree)));

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
        if (!path) {
            //Display message saying how to move and how you should stay on the path
            Iterator<Collidable> i = entities.iterator();
            while (i.hasNext()){
                Collidable c = i.next();
                if (player.collideWith(c)) {
                    path = true;
                }
            }
            if (path) {
                t = new Tree(50, 100, WIDTH, HEIGHT);
                entities.add(t);
                entities.add(new Wind(200, 100, 50, 50));
            }
        } else if (!trees) {
            //This is a tree, hitting a tree hurt, dodge the tree while staying on the path
            //Wind pushes you
            //hit the tree
            for (Collidable c : entities) {
                if (player.collideWith(t)) {
                    //Message about health
                    player.onCollide(t);
                    trees = true;
                }
            }
            if (trees) {
                p = new Pond(400, 200, WIDTH, HEIGHT);
                entities.add(p);
            }
        } else if(!fish) {
            //this is a pond, dive with space
            //diving slows your movement and moves you forward
            //diving over a pond catches a fish and heals you
            //get the fish
            if (player.collideWith(p) && player.isDiving()) {
                player.onCollide(p);
                //Yay, end tutorial
            }
        }
    }
}
