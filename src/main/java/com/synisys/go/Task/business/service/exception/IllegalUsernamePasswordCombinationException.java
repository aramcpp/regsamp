package com.synisys.go.Task.business.service.exception;

/**
 * Created by srapion.hunanyan on 10/12/2016.
 */
public class IllegalUsernamePasswordCombinationException extends Exception{
    public IllegalUsernamePasswordCombinationException() {
    }

    public IllegalUsernamePasswordCombinationException(String var1) {
        super(var1);
    }

    public IllegalUsernamePasswordCombinationException(String var1, Throwable var2) {
        super(var1, var2);
    }

    public IllegalUsernamePasswordCombinationException(Throwable var1) {
        super(var1);
    }

    protected IllegalUsernamePasswordCombinationException(String var1, Throwable var2, boolean var3, boolean var4) {
        super(var1, var2, var3, var4);
    }
}
