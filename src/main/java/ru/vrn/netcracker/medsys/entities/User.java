package ru.vrn.netcracker.medsys.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

//@Data
@Getter
@Setter
@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user"),
               inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "id_role"))
    private Collection<Role> roles;

}
