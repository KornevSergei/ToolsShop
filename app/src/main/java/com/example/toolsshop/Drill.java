package com.example.toolsshop;

import androidx.annotation.NonNull;

//сщздали класс для описания дрели, что бы создавать обьекты с параметрами
public class Drill {
    private String title;
    private String info;
    private int imageResourceId;


    //создаём конструктор
    public Drill(String title, String info, int imageResourceId) {
        this.title = title;
        this.info = info;
        this.imageResourceId = imageResourceId;
    }

    //делаем гетеры для доступа
    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    //переопределяем метод для того что бы отображалось название
    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
