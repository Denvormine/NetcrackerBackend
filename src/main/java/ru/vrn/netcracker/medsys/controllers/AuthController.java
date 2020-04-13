package ru.vrn.netcracker.medsys.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vrn.netcracker.medsys.entities.Role;
import ru.vrn.netcracker.medsys.entities.SecurityUserDetails;
import ru.vrn.netcracker.medsys.entities.User;
import ru.vrn.netcracker.medsys.entities.dto.NewUserDto;
import ru.vrn.netcracker.medsys.entities.dto.UserDto;
import ru.vrn.netcracker.medsys.repositories.RoleRepository;
import ru.vrn.netcracker.medsys.services.UsersService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final UsersService usersService;
    private final RoleRepository roleRepository;
    private final ModelMapper mapper;

    protected String encodePassword(String password) {
        return SecurityUserDetails.passwordEncoder.encode(password);
    }

    protected boolean matchPassword(String rawPassword, String encodedPassword) {
        return SecurityUserDetails.passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Autowired
    public AuthController(UsersService usersService, RoleRepository roleRepository, ModelMapper mapper) {
        this.usersService = usersService;
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

  /*@PostMapping("/sign-in")
    @Secured(value = {"ROLE_CLIENT", "ROLE_USER", "ROLE_ADMIN"})
    @ResponseBody
    public ResponseEntity<UserDto> signIn(Principal p){
        Optional<User> user = usersService.findByEmail(p.getName());

        return ResponseEntity.ok(mapper.map(user.get(), UserDto.class));
    }*/

    @PostMapping("/sign-in")
    @ResponseBody
    public ResponseEntity<UserDto> signIn(@RequestBody NewUserDto newUser) {
        Optional<User> user = usersService.findByEmail(newUser.getName());
        if (user.isPresent()) {
            String password = user.get().getPassword();
            if (matchPassword(newUser.getPassword(), password)) {
                return ResponseEntity.ok(mapper.map(user.get(), UserDto.class));
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/sign-up")
    @ResponseBody
    public ResponseEntity<UserDto> signUp(@RequestBody NewUserDto newUser) {

        //check if login already exists
        Optional<User> tmp = usersService.findByEmail(newUser.getEmail());
        if (tmp.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        User user = mapper.map(newUser, User.class);
        user.setRoles(new ArrayList<>());
        Optional<Role> role = roleRepository.findByName("ROLE_CLIENT");
        if (!role.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        user.getRoles().add(role.get());
        user.setPassword(encodePassword(user.getPassword()));
        usersService.save(user);


        return ResponseEntity.ok(mapper.map(user, UserDto.class));
    }

}
