package com.easylearn.easylearn.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
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
    /*
    public void setPassword(String password)
    {
        this.password = encoder.encode(password);
    }
    */
    //https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt


}
