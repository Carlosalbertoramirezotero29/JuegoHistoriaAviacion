package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ene {
	
	private double x;
	private double y;
	
	private double velX=5;
	private double velY=0.1;
	
	public static final int WIDTH = 56;
	public static final int HEIGHT = 28;
	
	private BufferedImage image;
	private Game game;
	
	public ene(double x, double y, Game game){
		this.x = x;
		this.y = y;
		this.game = game;
	
	}
      
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}
	

	public void tick(){
		x += velX;
		y += velY;
		
		// To avoid player go outside the arena.		
		if(x <= 0)
                        this.velX*=-1;
		if(x >= (Game.WIDTH * Game.SCALE) - WIDTH)
                    this.velX*=-1;
		if(y <= 0)
			y = 0;
		if(y >= (Game.HEIGHT * Game.SCALE) - HEIGHT)
			y = (Game.HEIGHT * Game.SCALE) - HEIGHT;
	}
	
        

}
