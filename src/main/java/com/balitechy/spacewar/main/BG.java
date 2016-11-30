/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.io.IOException;

/**
 *
 * @author Martin
 */
public interface BG {
    public void render(Graphics g, Canvas c) throws IOException;
}
