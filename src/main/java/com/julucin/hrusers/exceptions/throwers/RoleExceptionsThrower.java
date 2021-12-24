package com.julucin.hrusers.exceptions.throwers;

import com.julucin.hrusers.exceptions.factories.RoleExceptionsFactory;
import com.julucin.hrusers.exceptions.factories.UserExceptionsFactory;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RoleExceptionsThrower {

    public static void throwInstanceDoesNotExistException(Long id){
        throw RoleExceptionsFactory.makeInstanceDoesNotExistException(id);
    }

}
