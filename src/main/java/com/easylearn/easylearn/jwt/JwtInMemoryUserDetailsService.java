/**
 * @Author: Mahmoud Abdelrahman
 * JwtInMemoryUserDetailsService Class is a class, where the code for retrieving a
 * user by its username is implemented.
 */
package com.easylearn.easylearn.jwt;

import com.easylearn.easylearn.EasylearnApplication;
import com.easylearn.easylearn.entity.Parent;
import com.easylearn.easylearn.entity.Student;
import com.easylearn.easylearn.entity.Teacher;
import com.easylearn.easylearn.repository.ParentRepository;
import com.easylearn.easylearn.repository.StudentRepository;
import com.easylearn.easylearn.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Set<JwtUserDetails> inMemoryUserList = EasylearnApplication.inMemoryUserList;

        System.out.println("Number of users: " + inMemoryUserList.size());
        if (!inMemoryUserList.isEmpty()) {
            Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
                    .filter(user -> user.getUsername().equals(username)).findFirst();

            if (!findFirst.isPresent()) {
                throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
            }
            return findFirst.get();

        }
        return null;
    }

}
