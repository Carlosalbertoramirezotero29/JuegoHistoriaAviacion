package com.balitechy.spacewar.main;

import java.awt.Graphics;
import static java.lang.Math.abs;
import java.util.LinkedList;

public class Enemycontroller {
	private LinkedList<ene> en = new LinkedList<ene>();
        private BulletController bullets;
        private Player player;

    public Enemycontroller(BulletController bullets, Player player) {
        this.bullets = bullets;
        this.player = player;
    }   
	
    public void tick(){
        LinkedList<ene> enes = new LinkedList<ene>();
        for(int i=0; i < en.size(); i++){
            for (int j = 0; j < bullets.getbullets().size(); j++) {
                if(abs(bullets.getbullets().get(j).getX()-en.get(i).getX())<=30 && abs(bullets.getbullets().get(j).getY()-en.get(i).getY())<=20){
                    enes.add(en.get(i));
                }
            }
            en.get(i).tick();
        }
        for(ene e:enes){
            player.setPuntaje(player.getPuntaje()+100);
            en.remove(e);
        }
    }
	
    public void addene(ene e){
            en.add(e);
    }

    public void removeene(ene e){
            en.remove(e);
    }

    public LinkedList<ene> getene(){
            return en;
    }

    void render(Graphics g, ene get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}