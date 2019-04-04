package com.wangr.Money;

public class RedPackage {
    private double amount;
    private double size;

    public RedPackage(double amount, double size) {
        this.amount = amount;
        this.size = size;
    }
    //according to real rule of WeChat Redpackage
    public double getRandomMoney(){
        if(size == 1){
            return amount;
        }
        double min = 0.01;
        double max = amount / size * 2;
        double money = Math.random() * max;
        money = money <= min ? min :money;
        money = Math.floor(money * 100) / 100;
        amount -= money;
        size--;
        return money;
    }

    public double getAmount() {
        return amount;
    }

    public double getSize() {
        return size;
    }
}
