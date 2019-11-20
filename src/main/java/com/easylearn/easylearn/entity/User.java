package com.easylearn.easylearn.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class User {
    /*
    @Autowired
    private BCryptPasswordEncoder encoder;
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increament
    protected Long id;

    @Column(nullable = false)
    protected String firstName;

    @Column(nullable = false)
    protected String lastName;

    @Column(unique = true, nullable = false)
    protected String email;

    @Column(nullable = false)
    protected String password;
    /*
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user.id"), inverseJoinColumns = @JoinColumn(name="role_id"))
    */
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    protected Set<Role> roles = new HashSet<>();

    /*
    public void setPassword(String password)
    {
        this.password = encoder.encode(password);
    }
    */
    //https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt


}
