package ru.vrn.netcracker.medsys.entities.dto;

import lombok.Data;
import ru.vrn.netcracker.medsys.entities.Role;

import java.util.Collection;

@Data
public class NewUserDto {
    private String name;
    private String email;
    private String password;
    private Collection<RoleDto> roles;
}
