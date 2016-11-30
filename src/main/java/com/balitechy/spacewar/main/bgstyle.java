/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Martin
 */
public class bgstyle implements BG{
    
   public bgstyle(){}
   @Override
   public void render(Graphics g, Canvas c) throws IOException {
	BufferedImage background = null;
	SpritesImageLoader bg;
	bg = new SpritesImageLoader("/bg.png");
	bg.loadImage();
	background = bg.getImage(0, 0, 640, 480);
	g.drawImage(background, 0, 0, c.getWidth(), c.getHeight(), c);	
	}
}
