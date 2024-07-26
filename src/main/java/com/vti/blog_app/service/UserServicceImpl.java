package com.vti.blog_app.service;


import com.vti.blog_app.dto.UserDto;

import com.vti.blog_app.entity.User;
import com.vti.blog_app.form.UserCreateForm;

import com.vti.blog_app.mapper.UserMapper;
import com.vti.blog_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServicceImpl implements UserService, UserDetailsService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDto create(UserCreateForm form) {
        var user = UserMapper.map(form);
        var encodedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encodedPassword);
        user.setRole(User.Role.EMPLOYEE);
        var savedUser = userRepository.save(user);
        return UserMapper.map(savedUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByusername(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(
                username, user.getPassword(), AuthorityUtils.NO_AUTHORITIES
        );
    }
}
