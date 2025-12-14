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


        public GamePanel() {

            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
        }

        Thread gameThread;

        public void startGameThread() {

            gameThread = new Thread(this);
            gameThread.start();
        }
        
        @Override
        public void run() {

            // UPDATE
            update();

            //Draw
            repaint();
        }

        public void update() {

        }

        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.white);
            g2d.fillRect(100, 100, tileSize, tileSize);
            g2d.dispose();
        }
}
