package com.infraleap;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        if (args.length < 1 || args.length > 2){
            usage();
        }

        String imagePath = args[0];

        BufferedImage myPicture = ImageIO.read(new File(imagePath));

        String formatName = "i64";
        if (args.length == 2) {
            String outPath = args[1];
            int length = outPath.length();
            if (length > 4 && outPath.charAt(length-4) == '.'){
                formatName = outPath.substring(length-3);
            }
            else{
                outPath += ".i64";
            }
            File outputFile = new File(outPath);
            ImageIO.write(myPicture, formatName, outputFile);
        }
        else {
            //drawCrap(myPicture);
            show(myPicture);
        }
    }

    private static void show(BufferedImage myPicture) {
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        JPanel jPanel = new JPanel();
        jPanel.add(picLabel);
        JFrame f = new JFrame();
        f.setSize(new Dimension(myPicture.getWidth(), myPicture.getHeight()));
        f.add(jPanel);
        f.setVisible(true);
        f.pack();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private static void drawCrap(BufferedImage myPicture) {
        Graphics2D g = (Graphics2D) myPicture.getGraphics();
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.BLUE);
        g.drawRect(10, 10, myPicture.getWidth() - 20, myPicture.getHeight() - 20);
    }

    private static void usage(){
        System.out.println("Usage:");
        System.out.println(" java -jar imgconv.jar <infile> [outfile]");
        System.out.println();
        System.out.println("Examples:");
        System.out.println(" java -jar imgconv.jar trees.bmp trees.i64");
        System.out.println(" java -jar imgconv.jar trees.i64");

        System.exit(1);
    }
}
