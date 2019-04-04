package com.wangr.Money;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Dimension;

import java.awt.RenderingHints;

import javax.swing.*;

public class AlgoFrame extends JFrame{
    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}


    private double[] money;
    public void render(double[] money){
        this.money = money;
        repaint();
    }

    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // anti-aliasing
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // details of drawing in every step

            AlgoVisUti.drawText(g2d,"Money Distribution among 100 People",500,20);

            int w = canvasWidth / money.length;
            for(int i = 0;i<money.length;i++){
                if(money[i]>0){
                    AlgoVisUti.setColor(g2d,AlgoVisUti.Blue);
                    AlgoVisUti.fillRectangle(g2d,
                            i*w-1,canvasHeight/2 - money[i]/2,w-1,money[i]/2);
                }
                else{
                    AlgoVisUti.setColor(g2d,AlgoVisUti.Red);
                    AlgoVisUti.fillRectangle(g2d,
                            i*w-1,canvasHeight/2,w-1,-money[i]/2);
                }


            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
