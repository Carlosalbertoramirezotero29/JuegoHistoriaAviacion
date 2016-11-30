/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balitechy.spacewar.main;

import static com.balitechy.spacewar.main.Bullet.HEIGHT;
import static com.balitechy.spacewar.main.Bullet.WIDTH;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin
 */
public class shootstyle implements shoot {
    public shootstyle(){}

    @Override
    public void render(Graphics g,Bullet b) {
        SpritesImageLoader sprites = new SpritesImageLoader("/sprites.png");
        BufferedImage image;
        try {			
            sprites.loadImage();
	} catch (IOException e) {
            e.printStackTrace();
	}
        image = sprites.getImage(35, 52, 11, 21);
        g.drawImage(image, (int) b.getX(),(int)b.getY(), null);
	
    }
}
