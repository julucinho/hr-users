package com.julucin.hrusers.exceptions.factories;

import com.julucin.hrusers.exceptions.InstanceDoesNotExistException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class UserExceptionsFactory {

    public InstanceDoesNotExistException makeInstanceDoesNotExistByIdException(Long id){
        var message = "There isn't an instance of user with ID ".concat(id.toString());
        log.info(message);
        return new InstanceDoesNotExistException(message);
    }

    public InstanceDoesNotExistException makeInstanceDoesNotExistByEmailException(String email){
        var message = "There isn't an instance of user with email equal to ".concat(email);
        log.info(message);
        return new InstanceDoesNotExistException(message);
    }

}
