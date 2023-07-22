package com.example.chocoholic.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(nullable=false)
    private String firstName;

    private String lastName;

    @Column(nullable = false,unique = true)
    @NotEmpty
    @Email(message = "{errors.invalid_email}")
    private String email;


    @NotEmpty
    private String password;

//    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_role"
//            {joinsColumns=(@JoinColumn(name="User_ID"),referencedColumnName="ID"})
//    )
//    private List<Role>roles;
}
