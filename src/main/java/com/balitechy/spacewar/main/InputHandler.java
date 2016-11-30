package com.balitechy.spacewar.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputHandler extends KeyAdapter{
	
	private Game game;
	
	public InputHandler(Game game){
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
            try {
                game.keyPressed(e);
            } catch (InterruptedException ex) {
                Logger.getLogger(InputHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		game.keyReleased(e);
	}

}
