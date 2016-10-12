package com.synisys.go.Task.business.service.exception;

import com.sun.xml.internal.ws.api.model.CheckedException;
import com.sun.xml.internal.ws.api.model.ExceptionType;
import com.sun.xml.internal.ws.model.CheckedExceptionImpl;
import com.sun.xml.internal.ws.model.JavaMethodImpl;
import com.sun.xml.internal.ws.spi.db.TypeInfo;

/**
 * Created by srapion.hunanyan on 10/12/2016.
 */
public class DuplicateUsernameException extends Exception{

    public DuplicateUsernameException() {
    }

    public DuplicateUsernameException(String var1) {
        super(var1);
    }

    public DuplicateUsernameException(String var1, Throwable var2) {
        super(var1, var2);
    }

    public DuplicateUsernameException(Throwable var1) {
        super(var1);
    }

    protected DuplicateUsernameException(String var1, Throwable var2, boolean var3, boolean var4) {
        super(var1, var2, var3, var4);
    }
}
