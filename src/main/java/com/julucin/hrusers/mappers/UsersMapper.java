package com.julucin.hrusers.mappers;

import com.julucin.hrusers.dtos.UserDto;
import com.julucin.hrusers.entities.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsersMapper {

    private static final Class<UserEntity> USER_ENTITY_CLASS = UserEntity.class;
    private static final Class<UserDto> USER_DTO_CLASS = UserDto.class;

    public UserEntity toEntity(UserDto dto){
        return Mapper.map(dto).to(USER_ENTITY_CLASS);
    }

    public UserDto toDto(UserEntity dto){
        return Mapper.map(dto).to(USER_DTO_CLASS);
    }

}
