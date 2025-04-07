package com.chap02.gptEx;


import com.chap02.bookEx.Observer;

import java.util.ArrayList;
import java.util.List;

// Observer 인터페이스
interface PriceObserver {
    void onPriceChange(String productName, int newPrice);
}



// Subject 클래스
class Product{
    private String name;
    private int price;
    private List<PriceObserver> observers = new ArrayList<>();

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public void addObserver(PriceObserver priceObserver){
        observers.add(priceObserver);
    }

    public void removeObserver(PriceObserver priceObserver){
        observers.remove(priceObserver);
    }

    public void setPrice(int newPrice){
        if(this.price != newPrice){
            this.price = newPrice;
            System.out.println("[알림] " + name + " 가격이 변경되었습니다: " + newPrice + "원");
            notifyObservers();
        }
    }

    private void notifyObservers(){
        for(PriceObserver po : observers){
            po.onPriceChange(name, price);
        }
    }
}




// Concrete Observer
class Customer implements PriceObserver{
    private String name;

    public Customer(String name){
        this.name = name;
    }

    @Override
    public void onPriceChange(String productName, int newPrice) {
        System.out.println(name + "님, " + productName + "의 가격이 " + newPrice + "원으로 변경되었습니다.");
    }
}




// 실행 예제
class Main{
    public static void main(String[] args) {
        Product iphone = new Product("iphone 15", 130000);

        Customer alice = new Customer("Alice");
        Customer bob = new Customer("bob");

        iphone.addObserver(alice);
        iphone.addObserver(bob);

        iphone.setPrice(1250000);
    }
}


