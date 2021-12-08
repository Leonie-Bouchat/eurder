package com.switchfully.eurderproject.exceptions;

public class ListOfUsersIsEmptyException extends RuntimeException {
    public ListOfUsersIsEmptyException(String message) {
        super(message);
    }
}
