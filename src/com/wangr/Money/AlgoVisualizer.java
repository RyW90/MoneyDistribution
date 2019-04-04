package com.wangr.Money;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Arrays;

public class AlgoVisualizer {

    private double[] money;
    private AlgoFrame frame;
    public static int DELAY = 40; // interval time between frames
//    private boolean flag = true;
    private boolean isAnimated = true;
    private int maxIndex = 0;
    private int N;


    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){


        this.N = N;
        money = new double[N];
        //initialize money of everyone, 100
        for(int i = 0;i<money.length;i++){
            money[i] = 100;
        }

        // initialize frame
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Visualize Algorithm", sceneWidth, sceneHeight);

            frame.addKeyListener(new AlgoKeyListener());

            new Thread(() -> {
                run();
            }).start();
        });
    }

    // logic of animation
    private void run(){

        while(true){
//            Arrays.sort(money);
            frame.render(money);
            AlgoVisUti.pause(DELAY);

            if (isAnimated) {
                for (int k = 0; k < 10; k++) {  // if you want to accelerate the pace of animation, change 10 to a larger one.
                    RedPackage redPackage = new RedPackage(10,N/2); // rule of redpackage, distribute RMB 10 to half of group
                    double maxAmount = 0;
                    money[maxIndex] -= 10; // The one who get the largest redpackage send it this time.
                    RandomArray array = new RandomArray(N);
                    for (int i = 0; i <N/2; i++) {
                        double amount = redPackage.getRandomMoney();
                        int index = array.getIndex();
                        money[index] += amount;
                        if(amount > maxAmount){
                            maxIndex = index;
                        }
                    }
                }
            }
        }
    }


    private class AlgoKeyListener extends KeyAdapter{
        @Override
//        press space key to pause the animation
        public void keyReleased(KeyEvent e) {
            if(e.getKeyChar()==' ')
                isAnimated = !isAnimated;
        }
    }
}


