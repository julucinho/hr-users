package com.julucin.hrusers.exceptions;

public class NullIdException extends RuntimeException{

    public NullIdException(){
        super("The ID was null.");
    }

}
