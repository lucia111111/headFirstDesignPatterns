package com.chap02.bookEx;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        // 모든 옵저버에게 상태 변화를 알려줌
        for(Observer o : observers){
            o.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged(){
        // 기상 스테이션으로부터 갱신된 측정값을 받으면 옵저버들에게 전달
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

}
