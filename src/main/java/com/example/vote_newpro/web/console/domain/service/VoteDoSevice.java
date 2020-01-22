package com.example.vote_newpro.web.console.domain.service;

import com.example.vote_newpro.web.console.controller.form.ValidForm;
import com.example.vote_newpro.web.console.domain.dao.TableUserDao;
import com.example.vote_newpro.web.console.domain.dao.VoteResultDao;
import com.example.vote_newpro.web.console.domain.entity.TableUserEntity;
import com.example.vote_newpro.web.console.domain.entity.VoteResultEntity;
import com.example.vote_newpro.web.console.dto.NenbetsDto;
import com.example.vote_newpro.web.console.framework.auth.LoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoteDoSevice {
    @Autowired
    private TableUserDao tableUserDao;

    @Autowired
    private VoteResultDao voteResultDao;

    public NenbetsDto showHappyoshaForm(String userId){

        List<TableUserEntity> entityList = tableUserDao.selectHappyoSha(userId,Collectors.toList());

        List<TableUserEntity> shinjin = new ArrayList<>();
        List<TableUserEntity> ninenme = new ArrayList<>();

        for (TableUserEntity tableUserEntity : entityList) {
            switch (tableUserEntity.getNyushaNensu()){
                case 1:
                    shinjin.add(tableUserEntity);
                    break;
                case 2:
                    ninenme.add(tableUserEntity);
                    break;
                default:
                    break;
            }
        }
        return new NenbetsDto(shinjin,ninenme);
    }

    public void insertTohyo(ValidForm form, LoginUserDetails userDetails){
        List<VoteResultEntity> voteResultEntities = new ArrayList<>();
        for(int i=0;i<form.getNinenmeId().size();i++){
            voteResultEntities.add(new VoteResultEntity(userDetails.getUserId(),form.getNinenmeId().get(i),form.getNinenmeComment().get(i)));
        }
        for(int i=0;i<form.getShinjinId().size();i++){
            voteResultEntities.add(new VoteResultEntity(userDetails.getUserId(),form.getShinjinId().get(i),form.getShinjinComment().get(i)));
        }
        voteResultDao.insert(voteResultEntities);
    }

}
