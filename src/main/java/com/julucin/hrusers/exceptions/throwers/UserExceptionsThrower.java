package com.julucin.hrusers.exceptions.throwers;

import com.julucin.hrusers.exceptions.factories.UserExceptionsFactory;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserExceptionsThrower {

    public static void throwInstanceDoesNotExistException(Long id){
        throw UserExceptionsFactory.makeInstanceDoesNotExistByIdException(id);
    }

}
