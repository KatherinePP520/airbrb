package com.airbrb.service;

import com.airbrb.domain.Token;
import com.airbrb.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {

    public Token register(User user);
    public Token login(User user);

    public void logout(String token);

    public User getByEmail(String email);
    public List<User> getAll();
}
