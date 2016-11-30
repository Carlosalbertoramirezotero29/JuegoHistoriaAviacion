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
public abstract class Fabrica {
    public Fabrica(){}
    public static Fabrica creefabrica(){
        return new Style();
    }
    public abstract nave creenave();
    public abstract shoot creeshoot();
    public abstract BG creebg();
    public abstract enemy creeEnemigo();
    
}
