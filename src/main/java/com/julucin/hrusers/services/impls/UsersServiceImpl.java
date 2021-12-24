package com.julucin.hrusers.services.impls;

import com.julucin.hrusers.entities.UserEntity;
import com.julucin.hrusers.exceptions.NullIdException;
import com.julucin.hrusers.exceptions.factories.UserExceptionsFactory;
import com.julucin.hrusers.repositories.UsersRepository;
import com.julucin.hrusers.services.RolesService;
import com.julucin.hrusers.services.UsersService;
import com.julucin.hrusers.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final RolesService rolesService;

    @Override
    public void deleteBy(Long id) {
        if (this.retrieveBy(id).isPresent())
            this.usersRepository.deleteById(id);
        else
            throw UserExceptionsFactory.makeInstanceDoesNotExistByIdException(id);
    }

    @Override
    public Optional<UserEntity> retrieveBy(Long id) {
        return this.usersRepository.findById(id);
    }

    @Override
    public UserEntity saveNew(UserEntity newEntity) {
        ofNullable(newEntity.getRoles()).orElse(new ArrayList<>()).forEach(this.rolesService::checkExistenceOf);
        PasswordUtils.encodePasswordForUser(newEntity);
        return this.usersRepository.save(newEntity);
    }

    @Override
    public void save(UserEntity entity) {
        var id = ofNullable(entity.getId()).orElseThrow(NullIdException::new);
        if (this.retrieveBy(id).isPresent()){
            PasswordUtils.encodePasswordForUser(entity);
            this.usersRepository.save(entity);
        }
        else
            throw UserExceptionsFactory.makeInstanceDoesNotExistByIdException(id);
    }

    @Override
    public Optional<UserEntity> retrieveUserBy(String email) {
        return this.usersRepository.findByEmail(email);
    }
}
