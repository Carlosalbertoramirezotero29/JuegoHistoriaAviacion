/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balitechy.spacewar.main;

/**
 *
 * @author Martin
 */
public class Pre extends Fabrica {
    public Pre(){}
    
    @Override
    public  nave creenave(){return new personaStyle();}
    
    @Override
    public  shoot creeshoot(){return new shootpre();};
    
    @Override
    public BG creebg() {
        return new bgpre();
    }

    @Override
    public enemy creeEnemigo() {
        return new EnemyPre();
    }
}
