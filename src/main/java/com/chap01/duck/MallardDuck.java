package com.chap01.duck;

import com.chap01.quack.Quack;
import com.chap01.fly.FlyWithWings;

public class MallardDuck extends Duck {

    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("저는 물오리입니다.");
    }
}
