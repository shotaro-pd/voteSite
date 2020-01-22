package com.example.vote_newpro.web.console.framework.auth.service;

import com.example.vote_newpro.web.console.domain.dao.TableUserDao;
import com.example.vote_newpro.web.console.domain.entity.TableUserEntity;
import com.example.vote_newpro.web.console.framework.auth.LoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TableUserDao loginUserDao;



    @Override
    public LoginUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        TableUserEntity loginUserEntity = loginUserDao.selectAll(userName)
                .orElseThrow(() -> new UsernameNotFoundException("UsernameNotFound"));

        //権限のリスト
        //AdminやUserなどが存在するが、今回は利用しないのでUSERのみを仮で設定
        //権限を利用する場合は、DB上で権限テーブル、ユーザ権限テーブルを作成し管理が必要
        List<GrantedAuthority> grantList = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
        grantList.add(authority);

        return  LoginUserDetails.create(
                loginUserEntity.getUserId(),
                loginUserEntity.getPassword(),
                loginUserEntity.getUserName(),
                grantList);
    }
}
