package ru.vrn.netcracker.medsys.configurations;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.vrn.netcracker.medsys.entities.Role;
import ru.vrn.netcracker.medsys.entities.SecurityUserDetails;
import ru.vrn.netcracker.medsys.entities.User;
import ru.vrn.netcracker.medsys.entities.dto.NewUserDto;

import java.util.Collection;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper(){
        //new user mapper
        /*PropertyMap<NewUserDto, User> newUserMap = new PropertyMap<NewUserDto, User>() {
            @Override
            protected void configure() {
                map().setPassword(new BCryptPasswordEncoder().encode(source.getPassword()));
                //map().setPassword(new BCryptPasswordEncoder().encode(source.getPassword()));
            }
        };*/
        ModelMapper mapper = new ModelMapper();
        //mapper.addMappings(newUserMap);
        return mapper;
    }
}
