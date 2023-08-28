package io.bayrktlihn.springapp.bootstrap;

import io.bayrktlihn.springapp.entity.Authority;
import io.bayrktlihn.springapp.entity.Role;
import io.bayrktlihn.springapp.entity.User;
import io.bayrktlihn.springapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDataFeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Role role = new Role("ADMIN");
        role.addAuthority(new Authority("READ"));
        role.addAuthority(new Authority("WRITE"));

        User user = new User();
        user.setUserName("bayrktlihn");
        user.setPassword(passwordEncoder.encode("123456"));
        user.addRole(role);


        userRepository.save(user);
    }
}
