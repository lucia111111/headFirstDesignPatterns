package com.chap01.duck;

import com.chap01.quack.Quack;
import com.chap01.fly.FlyNoWay;

public class ModelDuck extends Duck {

    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("저는 모형 오리입니다");
    }
}
