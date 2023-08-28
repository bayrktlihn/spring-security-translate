package io.bayrktlihn.springapp.security;

import io.bayrktlihn.springapp.entity.Authority;
import io.bayrktlihn.springapp.entity.Role;
import io.bayrktlihn.springapp.entity.User;
import io.bayrktlihn.springapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
@RequiredArgsConstructor
public class BayrktlihnUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException(username));


        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        Set<String> addedRoles = new HashSet<>();
        Set<String> addedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            boolean addedRole = addedRoles.add(role.getName());
            if (addedRole) {
                authorityList.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
            }
            for (Authority authority : role.getAuthorities()) {
                boolean addedAuthority = addedAuthorities.add(authority.getName());
                if (addedAuthority) {
                    authorityList.add(new SimpleGrantedAuthority(authority.getName()));
                }
            }
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getPassword())
                .authorities(authorityList)
                .disabled(user.isPassive())
                .build();
    }
}
