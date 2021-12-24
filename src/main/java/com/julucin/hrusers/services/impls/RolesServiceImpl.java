package com.julucin.hrusers.services.impls;

import com.julucin.hrusers.entities.RoleEntity;
import com.julucin.hrusers.exceptions.NullIdException;
import com.julucin.hrusers.exceptions.factories.RoleExceptionsFactory;
import com.julucin.hrusers.exceptions.throwers.RoleExceptionsThrower;
import com.julucin.hrusers.repositories.RolesRepository;
import com.julucin.hrusers.services.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService {

    private final RolesRepository rolesRepository;

    @Override
    public void deleteBy(Long id) {
        if (this.retrieveBy(id).isPresent())
            this.rolesRepository.deleteById(id);
        else
            throw RoleExceptionsFactory.makeInstanceDoesNotExistException(id);
    }

    @Override
    public Page<RoleEntity> retrieveAllPaginated(Integer pageNumber, Integer pageSize) {
        return this.rolesRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @Override
    public RoleEntity saveNew(RoleEntity newEntity) {
        return this.rolesRepository.save(newEntity);
    }

    @Override
    public void save(RoleEntity entity) {
        var id = ofNullable(entity.getId()).orElseThrow(NullIdException::new);
        if (this.retrieveBy(id).isPresent())
            this.rolesRepository.save(entity);
        else
            throw RoleExceptionsFactory.makeInstanceDoesNotExistException(id);
    }

    @Override
    public Optional<RoleEntity> retrieveBy(Long id) {
        return this.rolesRepository.findById(id);
    }

    @Override
    public void checkExistenceOf(RoleEntity roleEntity) {
        var id = ofNullable(roleEntity.getId()).orElseThrow(NullIdException::new);
        if (this.retrieveBy(id).isEmpty())
            RoleExceptionsThrower.throwInstanceDoesNotExistException(id);
    }
}
