package com.chap02.bookEx;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    // 생성자에 weatherData라는 주제가 전달되며, 그 객체를 써서 디스플레이를 옵저버로 등록
    public CurrentConditionsDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        // update()가 호출되면 온도와 습도를 저장하고 display()를 호출
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("현재 상태 : 온도 " + temperature + " F, 습도 " + humidity + "%");
    }

}
