package com.my.project;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {

    private ResourceMgr() {}

    public static BufferedImage[] goodTankL;
    public static BufferedImage[] goodTankR;
    public static BufferedImage[] goodTankU;
    public static BufferedImage[] goodTankD;
    public static BufferedImage[] badTankL;
    public static BufferedImage[] badTankR;
    public static BufferedImage[] badTankU;
    public static BufferedImage[] badTankD;
    public static BufferedImage bulletL;
    public static BufferedImage bulletR;
    public static BufferedImage bulletU;
    public static BufferedImage bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            goodTankU = new BufferedImage[2];
            goodTankU[0] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankU[1] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank2.png"));
            goodTankL = new BufferedImage[2];
            goodTankL[0] = ImageUtil.rotateImage(goodTankU[0], -90);
            goodTankL[1] = ImageUtil.rotateImage(goodTankU[1], -90);
            goodTankR = new BufferedImage[2];
            goodTankR[0] = ImageUtil.rotateImage(goodTankU[0], 90);
            goodTankR[1] = ImageUtil.rotateImage(goodTankU[1], 90);
            goodTankD = new BufferedImage[2];
            goodTankD[0] = ImageUtil.rotateImage(goodTankU[0], 180);
            goodTankD[1] = ImageUtil.rotateImage(goodTankU[1], 180);
            badTankU = new BufferedImage[2];
            badTankU[0] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankU[1] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank2.png"));
            badTankL = new BufferedImage[2];
            badTankL[0] = ImageUtil.rotateImage(badTankU[0], -90);
            badTankL[1] = ImageUtil.rotateImage(badTankU[1], -90);
            badTankR = new BufferedImage[2];
            badTankR[0] = ImageUtil.rotateImage(badTankU[0], 90);
            badTankR[1] = ImageUtil.rotateImage(badTankU[1], 90);
            badTankD = new BufferedImage[2];
            badTankD[0] = ImageUtil.rotateImage(badTankU[0], 180);
            badTankD[1] = ImageUtil.rotateImage(badTankU[1], 180);
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);
            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
