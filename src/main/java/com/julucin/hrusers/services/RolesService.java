package com.julucin.hrusers.services;

import com.julucin.hrusers.entities.RoleEntity;
import com.julucin.hrusers.services.commons.DeletingService;
import com.julucin.hrusers.services.commons.RetrievingAllService;
import com.julucin.hrusers.services.commons.RetrievingByIdService;
import com.julucin.hrusers.services.commons.SavingService;
import org.springframework.stereotype.Service;

@Service
public interface RolesService extends SavingService<RoleEntity>,
        RetrievingAllService<RoleEntity>,
        RetrievingByIdService<RoleEntity, Long>,
        DeletingService<Long> {

    void checkExistenceOf(RoleEntity roleEntity);
}
