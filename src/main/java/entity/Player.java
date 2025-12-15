package entity;

import com.LoL.GamePanel;
import com.LoL.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends  Entity {
    GamePanel gp;
    KeyHandler kh;

    public Player(GamePanel gp, KeyHandler kh) {
        this.gp = gp;
        this.kh = kh;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {

        if (kh.upPressed == true) {
            direction = "up";
            y -= speed;
        } else if (kh.downPressed  == true) {
            direction = "down";
            y += speed;
        } else if (kh.leftPressed == true) {
            direction = "left";
            x -= speed;
        } else if (kh.rightPressed  == true) {
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics g2d) {

//        g2d.setColor(Color.white);
//        g2d.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        g2d.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
