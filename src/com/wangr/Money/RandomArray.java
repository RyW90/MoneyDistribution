package com.wangr.Money;

import java.util.ArrayList;

public class RandomArray {
    private int N;
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public RandomArray(int N){
        this.N = N;
        for(int i = 0; i < N; i++){
            list.add(i);
        }
    }

    public int getIndex(){
        int index = (int)(Math.random()*list.size());
        int result = list.get(index);
        list.remove(index);
        return result;
    }


}
