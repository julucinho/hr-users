package com.julucin.hrusers.dtos;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String pass;
    private List<RoleDto> roles;
}
