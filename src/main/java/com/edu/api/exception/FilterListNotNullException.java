package com.edu.api.exception;

public class FilterListNotNullException extends  Exception {

    public FilterListNotNullException(){
        super("Value is null");
    }
}
