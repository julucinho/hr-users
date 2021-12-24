package com.julucin.hrusers.services;

import com.julucin.hrusers.entities.UserEntity;
import com.julucin.hrusers.services.commons.DeletingService;
import com.julucin.hrusers.services.commons.RetrievingByIdService;
import com.julucin.hrusers.services.commons.SavingService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UsersService extends SavingService<UserEntity>,
        RetrievingByIdService<UserEntity, Long>,
        DeletingService<Long>{
    Optional<UserEntity> retrieveUserBy(String email);
}
