package com.di.nb.controller;

import com.di.nb.domain.ResultJson;
import com.di.nb.domain.UserBean;
import com.di.nb.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/user")
public class UserController {
    private static int CODE = 200;
    private static int ERRORCODE = 400;

    @Autowired
    private UserService userService;

    @PostMapping(value="/signup")
    public ResultJson createUser(@RequestBody UserBean userBean) {
        ResultJson json = new ResultJson();
        int result = userService.createUserService(userBean);
        System.out.println(result);

        if (result == 1) {
            String token = getJWTToken(userBean.getUsername());
            userBean.setToken(token);
            json.setResult(CODE);
            json.setMsg("user created！!!!");
            json.setResult(token);
        }else {
            json.setResult(ERRORCODE);
            json.setMsg("fail！");
            json.setResult(null);
        }
        return json;
    }

    @PostMapping(value="/login")
    public ResultJson signupUser(@RequestBody UserBean userBean) {
        ResultJson json = new ResultJson();
        int result = userService.loginUserService(userBean);
        System.out.println(result);

        if (result == 1) {
            String token = getJWTToken(userBean.getUsername());
            userBean.setToken(token);
            json.setResult(CODE);
            json.setMsg("login success");
            json.setResult(token);
        }else {
            json.setResult(ERRORCODE);
            json.setMsg("fail！");
            json.setResult(null);
        }
        return json;
    }

    //@PostMapping(value="/login")
    //public UserBean login(@RequestParam("username") String username, @RequestParam("password") String password) {
    //    String token = getJWTToken(username);
    //    UserBean user = new UserBean();
    //    user.setUsername(username);
    //    user.setToken(token);
    //    return user;
    //}

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return token;
    }


}
