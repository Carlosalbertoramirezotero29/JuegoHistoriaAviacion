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

/**
 *
 * @author 2105537
 */
public class personaStyle implements nave{

    @Override
    public void render(Graphics g, Player player) {
        SpritesImageLoader sprites = new SpritesImageLoader("/prehistorica.png");
        BufferedImage image;
        try {			
            sprites.loadImage();
	} catch (IOException e) {
            e.printStackTrace();
	}
        image = sprites.getImage(31, 48, 33, 67);
        g.setColor(Color.white);
	g.drawImage(image, (int) player.getX(), (int) player.getY(), null);
    }
    
}
