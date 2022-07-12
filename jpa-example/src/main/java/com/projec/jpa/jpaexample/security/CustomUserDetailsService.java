package com.projec.jpa.jpaexample.security;

import com.projec.jpa.jpaexample.data.Role;
//import com.projec.jpa.jpaexample.data.User;
import org.springframework.security.core.userdetails.User;
import com.projec.jpa.jpaexample.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
       /* User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), mapRolesToAuthorities(user.getRoles()));

        */

        if ("javainuse".equals(usernameOrEmail)) {
            return new User("javainuse", "$2a$10$oQ1SigtS6Cs6P.4C5xy9MeE4JzbwEKv2UR5W6cdGCX37vLwbgTBS2",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + usernameOrEmail);
        }


    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
