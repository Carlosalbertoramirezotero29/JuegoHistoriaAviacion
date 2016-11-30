package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
    public final String TITLE = "Space War 2D";

    private boolean running = false;
    private Thread thread;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    private SpritesImageLoader sprites;
    //Game components
    private Player player;
    private BulletController bullets;
    private Enemycontroller enemies;
    private BG backgRenderer;
    private nave nav;
    private shoot sho;
    private enemy malo;
    private Fabrica f;

    public void init() {
        requestFocus();
        // Add keyboard listener
        addKeyListener(new InputHandler(this));
        // Initialize game components.
        // Set player position at the bottom center.
        player = new Player((WIDTH * SCALE - Player.WIDTH) / 2, HEIGHT * SCALE - 50, this);
        bullets = new BulletController();
        enemies = new Enemycontroller(this.bullets, player);
        creeenemigos();
        backgRenderer = Fabrica.creefabrica().creebg();
        nav = Fabrica.creefabrica().creenave();
        sho = Fabrica.creefabrica().creeshoot();
        malo = Fabrica.creefabrica().creeEnemigo();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        try {
            if(player.getPuntaje()>=15000){
                
                backgRenderer = Fabrica.creefabrica().creebg();
                nav = Fabrica.creefabrica().creenave();
                sho = Fabrica.creefabrica().creeshoot();
                malo = Fabrica.creefabrica().creeEnemigo();
            }
            backgRenderer.render(g, this);
            nav.render(g, player);
            for (int i = 0; i < bullets.getbullets().size(); i++) {
                sho.render(g, bullets.getbullets().get(i));
            }
            for (int i = 0; i < enemies.getene().size(); i++) {
                malo.render(g, enemies.getene().get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics2D g2 = (Graphics2D) g;g2.setColor(Color.RED);g2.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        g2.drawString("Payer 1   Puntaje= "+player.getPuntaje(),250, 25);
        g.dispose();
        bs.show();
    }

    public SpritesImageLoader getSprites() {
        return sprites;
    }

    public BulletController getBullets() {
        return bullets;
    }

    public void keyPressed(KeyEvent e) throws InterruptedException {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_RIGHT:
                player.setVelX(5);
                break;

            case KeyEvent.VK_LEFT:
                player.setVelX(-5);
                break;

            case KeyEvent.VK_UP:
                player.setVelY(-5);
                break;

            case KeyEvent.VK_DOWN:
                player.setVelY(5);
                break;

            case KeyEvent.VK_SPACE:
                player.shoot();
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_RIGHT:
                player.setVelX(0);
                break;

            case KeyEvent.VK_LEFT:
                player.setVelX(0);
                break;

            case KeyEvent.VK_UP:
                player.setVelY(0);
                break;

            case KeyEvent.VK_DOWN:
                player.setVelY(0);
                break;

        }
    }

    private synchronized void start() {
        if (running) {
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if (!running) {
            return;
        }

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    /*
	 * Game thread runner. 
     */
    @Override
    public void run() {
        init();

        long lastTime = System.nanoTime();
        final double numOfTicks = 60.0;
        double ns = 1000000000 / numOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        int cont=0;
        while (running) {
            cont++;
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            if(cont==600 ){creeenemigos();cont=0;}
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    /*
	 * Run the ticks of all game components.
     */
    public void tick() {
        player.tick();
        bullets.tick();
        enemies.tick();
    }

    /*
	 * Render overall game components.
     */
    public static void main(String args[]) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }

    private void creeenemigos() {
        for (int i = 0; i < 8; i++) {
            enemies.addene(new ene(20 + 70 * i, 20, this));

        }
    }

}
