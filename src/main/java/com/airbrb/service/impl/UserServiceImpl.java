package com.airbrb.service.impl;

import com.airbrb.auth.JwtToken;
import com.airbrb.auth.RsaKeyPair;
import com.airbrb.dao.UserDao;
import com.airbrb.domain.Token;
import com.airbrb.domain.User;
import com.airbrb.exception.AuthException;
import com.airbrb.exception.BusinessException;
import com.airbrb.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public Token register(User user) {
//check user information is not empty
        if (user.getEmail() == null || user.getEmail().length() == 0) {
            throw new BusinessException("Invalid email address!");
        }
        if(userDao.getByEmail(user.getEmail())!=null){
            throw new BusinessException("This email address has already be used");
        }
        if (user.getName() == null || user.getName().length() == 0) {
            throw new BusinessException("Invalid name!");
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            throw new BusinessException("Invalid password!");
        }
        userDao.save(user);
        return JwtToken.generateToken(user.getEmail());
    }
    public Token login(User user){
        User dataBaseUser= userDao.getByEmail(user.getEmail());
        if(dataBaseUser==null){
            throw new BusinessException("Email Address has not been found");
        }
        if(!user.getPassword().equals(dataBaseUser.getPassword())){
            throw new BusinessException("password doesn't match, try agin");
        }
        return JwtToken.generateToken(user.getEmail());
    }


    public void logout(String token){
        if(token.length()==0 ||token==null){
            throw new AuthException("invalid token");
        }
        String email=JwtToken.verifyToken(token);
       if(userDao.getByEmail(email)==null) {
           throw new AuthException("invalid token");
       }
    }

    public User getByEmail(String email){
        return userDao.getByEmail(email);
    };
    public List<User> getAll(){
        return userDao.getAll();
    };

}
