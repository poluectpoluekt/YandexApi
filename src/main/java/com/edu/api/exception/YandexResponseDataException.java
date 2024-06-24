package com.edu.api.exception;

public class YandexResponseDataException extends Exception{

    public YandexResponseDataException(){
        super("Error loading data from yandex server.");
    }
}
