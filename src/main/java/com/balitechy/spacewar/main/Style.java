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
public class Style extends Fabrica {
    public Style(){}

     @Override
    public  nave creenave(){return new navestyle();}
    
    @Override
    public  shoot creeshoot(){return new shootstyle();}
    
    @Override
    public BG creebg() {
       return new bgstyle();
    }

    @Override
    public enemy creeEnemigo() {
        return new EnemyStyle();
    }
}
