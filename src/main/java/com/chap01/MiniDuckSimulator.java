package com.chap01;

import com.chap01.fly.FlyRocketPowered;
import com.chap01.duck.Duck;
import com.chap01.duck.MallardDuck;
import com.chap01.duck.ModelDuck;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();

        /**
         * 각 오리에는 FlyBehavior와 QuckBehavior가 있으며, 각각 나는 행동과 꽥꽥거리는 행동을 위임받음
         * 이런 식으로 두 클래스를 합치는 것을 '구성(composition)'을 이용한다고 부름
         * 오리 클래스에서는 행동을 상속받는 대신, 올바른 행동 객체로 구성되어 행동을 부여 받음
         *
         * 디자인 원칙 : 상속보다는 구성을 활용한다
         *
         * */
        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
