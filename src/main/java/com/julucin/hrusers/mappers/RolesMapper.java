package com.julucin.hrusers.mappers;

import com.julucin.hrusers.dtos.RoleDto;
import com.julucin.hrusers.entities.RoleEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RolesMapper {

    private static final Class<RoleEntity> ROLE_ENTITY_CLASS = RoleEntity.class;
    private static final Class<RoleDto> ROLE_DTO_CLASS = RoleDto.class;

    public RoleEntity toEntity(RoleDto dto){
        return Mapper.map(dto).to(ROLE_ENTITY_CLASS);
    }

    public RoleDto toDto(RoleEntity dto){
        return Mapper.map(dto).to(ROLE_DTO_CLASS);
    }

}
