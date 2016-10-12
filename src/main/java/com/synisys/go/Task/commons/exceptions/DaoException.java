package com.synisys.go.Task.commons.exceptions;

/**
 * Created by aram.hovhannisyan on 10/12/2016.
 */
public class DaoException extends Exception {
    public DaoException(String errorMessage) {
        super("DaoException:" + errorMessage);
    }
}
