package com.LoL;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
        final int originalTileSize = 16; // 16x16 pixels
        final int scale = 3;

        final int tileSize = originalTileSize * scale; // 48x48 pixels after scaling
        final int maxScreenCol = 16;
        final int maxScreenRow = 12;
        final int screenWidth = tileSize * maxScreenCol;
        final int screenHeight = tileSize * maxScreenRow;


        KeyHandler keyH =  new KeyHandler();
        Thread gameThread;

        // Player's location and Player Speed
        int PlayerX = 100;
        int PlayerY = 100;
        int PlayerSpeed = 4;

        // Setting FPS
        int FPS = 60;

        public GamePanel() {

            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyH);
            this.setFocusable(true);
        }



        public void startGameThread() {

            gameThread = new Thread(this);
            gameThread.start();
        }
        
        @Override
        public void run() {

           double drawInterval = 1000000000 / FPS;
           double nextDrawTime = System.nanoTime() + drawInterval;
           while (gameThread != null) {

               update();

               repaint();

               try {
                   double remainingTime = nextDrawTime - System.nanoTime();
                   remainingTime = remainingTime/10000000;

                   if (remainingTime < 0) {
                       remainingTime = 0;
                   }

                   Thread.sleep((long) remainingTime);
                   nextDrawTime += drawInterval;

               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }

        public void update() {

            if (keyH.upPressed == true) {
                PlayerY -= PlayerSpeed;
            } else if (keyH.downPressed  == true) {
                PlayerY += PlayerSpeed;
            } else if (keyH.leftPressed == true) {
                PlayerX -= PlayerSpeed;
            } else if (keyH.rightPressed  == true) {
                PlayerX += PlayerSpeed;
            }
        }

        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.white);
            g2d.fillRect(PlayerX, PlayerY, tileSize, tileSize);
            g2d.dispose();
        }
}
