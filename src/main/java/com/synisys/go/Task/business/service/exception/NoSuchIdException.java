package com.synisys.go.Task.business.service.exception;

/**
 * Created by srapion.hunanyan on 10/12/2016.
 */
public class NoSuchIdException extends Exception{
    public NoSuchIdException() {
    }

    public NoSuchIdException(String var1) {
        super(var1);
    }

    public NoSuchIdException(String var1, Throwable var2) {
        super(var1, var2);
    }

    public NoSuchIdException(Throwable var1) {
        super(var1);
    }

    protected NoSuchIdException(String var1, Throwable var2, boolean var3, boolean var4) {
        super(var1, var2, var3, var4);
    }
}
