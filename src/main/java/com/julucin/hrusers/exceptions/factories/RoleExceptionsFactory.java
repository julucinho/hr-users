package com.julucin.hrusers.exceptions.factories;

import com.julucin.hrusers.exceptions.InstanceDoesNotExistException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class RoleExceptionsFactory {

    public InstanceDoesNotExistException makeInstanceDoesNotExistException(Long id){
        var message = "There isn't an instance of role with ID ".concat(id.toString());
        log.info(message);
        return new InstanceDoesNotExistException(message);
    }

}
