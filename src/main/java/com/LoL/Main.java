package com.LoL;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

            JFrame window = new JFrame();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(false);
            window.setTitle("2d adventure game");

            GamePanel gamePanel = new GamePanel(); // Implements gamePanel class
            window.add(gamePanel);
            window.pack(); // GamePanel size GUI

            window.setLocationRelativeTo(null);
            window.setVisible(true);

            gamePanel.startGameThread();
    }
}
