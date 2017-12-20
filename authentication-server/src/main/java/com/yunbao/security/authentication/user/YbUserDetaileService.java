package com.yunbao.security.authentication.user;

import com.yunbao.security.api.IUserInterfaces;
import com.yunbao.security.model.LaosijiUser;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class YbUserDetaileService implements UserDetailsService {
    //把操作用户表的类注入进来，

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    IUserInterfaces iUserInterfaces;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户名"+username);
        List<LaosijiUser> laosijiUsers = iUserInterfaces.findByUsername(username);
        if (laosijiUsers.size()<=0){
            throw  new UsernameNotFoundException("没有该用户");
        }
        LaosijiUser laosijiUser = laosijiUsers.get(0);
//        logger.info("密码"+passwordEncoder.encode("123123"));
        log.info(laosijiUser.getHasRole());
        //,ROLE_USER
        return new User(username,passwordEncoder.encode(laosijiUser.getPassword()),true,true,true,true, AuthorityUtils.commaSeparatedStringToAuthorityList(""+laosijiUser.getHasRole()+""));
    }
}
