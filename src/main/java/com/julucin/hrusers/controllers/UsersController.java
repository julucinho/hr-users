package com.julucin.hrusers.controllers;

import com.julucin.hrusers.dtos.UserDto;
import com.julucin.hrusers.exceptions.factories.UserExceptionsFactory;
import com.julucin.hrusers.mappers.UsersMapper;
import com.julucin.hrusers.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/{email}")
    public ResponseEntity<UserDto> retrieveUserByEmail(@PathVariable String email){
        var user = this.usersService.retrieveUserBy(email)
                .orElseThrow(() -> UserExceptionsFactory.makeInstanceDoesNotExistByEmailException(email));
        return ResponseEntity.ok(UsersMapper.toDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDto> saveNewUser(@RequestBody UserDto newUser, @RequestHeader String host){
        var justSavedNewUser = this.usersService.saveNew(UsersMapper.toEntity(newUser));
        var location = URI.create(host.concat("/users/").concat(justSavedNewUser.getId().toString()));
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody UserDto user, @PathVariable Long id){
        user.setId(id);
        this.usersService.save(UsersMapper.toEntity(user));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        this.usersService.deleteBy(id);
        return ResponseEntity.noContent().build();
    }

}
