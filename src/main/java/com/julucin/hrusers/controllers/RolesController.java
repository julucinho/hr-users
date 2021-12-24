package com.julucin.hrusers.controllers;

import com.julucin.hrusers.dtos.RoleDto;
import com.julucin.hrusers.dtos.UserDto;
import com.julucin.hrusers.exceptions.factories.UserExceptionsFactory;
import com.julucin.hrusers.mappers.RolesMapper;
import com.julucin.hrusers.mappers.UsersMapper;
import com.julucin.hrusers.services.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolesController {

    private final RolesService rolesService;

    @GetMapping
    public ResponseEntity<Page<RoleDto>> retrieveRoles(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        var rolesPaginated = this.rolesService.retrieveAllPaginated(pageNumber, pageSize).map(RolesMapper::toDto);
        return ResponseEntity.ok(rolesPaginated);
    }

    @PostMapping
    public ResponseEntity<RoleDto> saveNewRole(@RequestBody RoleDto newRole, @RequestHeader String host){
        var justSavedNewRole = this.rolesService.saveNew(RolesMapper.toEntity(newRole));
        var location = URI.create(host.concat("/roles/").concat(justSavedNewRole.getId().toString()));
        return ResponseEntity.created(location).body(RolesMapper.toDto(justSavedNewRole));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRole(@RequestBody RoleDto role, @PathVariable Long id){
        role.setId(id);
        this.rolesService.save(RolesMapper.toEntity(role));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id){
        this.rolesService.deleteBy(id);
        return ResponseEntity.noContent().build();
    }

}
