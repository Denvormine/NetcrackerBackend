package ru.vrn.netcracker.medsys.entities.dto;

import lombok.Data;
import lombok.ToString;
import ru.vrn.netcracker.medsys.entities.Role;

import java.util.Collection;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private Collection<RoleDto> roles;
}
