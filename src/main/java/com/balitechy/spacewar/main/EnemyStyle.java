/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin
 */
public class EnemyStyle implements enemy {
    public EnemyStyle(){
    }
    @Override
    public void render(Graphics g,ene player) {
        
        SpritesImageLoader sprites = new SpritesImageLoader("/sprites.png");
        BufferedImage image;
        try {			
            sprites.loadImage();
	} catch (IOException e) {
            e.printStackTrace();
	}
        image = sprites.getImage(236, 353, 25, 28);
        g.setColor(Color.white);
	g.drawImage(image, (int) player.getX(), (int) player.getY(), null);
          
        
    }

    
}
