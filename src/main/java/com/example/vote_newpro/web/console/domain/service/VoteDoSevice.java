package com.example.vote_newpro.web.console.domain.service;

import com.example.vote_newpro.web.console.controller.form.ValidForm;
import com.example.vote_newpro.web.console.domain.dao.TableUserDao;
import com.example.vote_newpro.web.console.domain.dao.VoteResultDao;
import com.example.vote_newpro.web.console.domain.entity.UserCommentEntity;
import com.example.vote_newpro.web.console.domain.entity.UserResultEntity;
import com.example.vote_newpro.web.console.domain.entity.TableUserEntity;
import com.example.vote_newpro.web.console.domain.entity.VoteResultEntity;
import com.example.vote_newpro.web.console.dto.NenbetsUserDto;
import com.example.vote_newpro.web.console.dto.NenbetsUserResultDto;
import com.example.vote_newpro.web.console.dto.UserResultDto;
import com.example.vote_newpro.web.console.framework.auth.LoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
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

    public NenbetsUserDto showHappyoshaForm(String userId){

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
        return new NenbetsUserDto(shinjin,ninenme);
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


    public NenbetsUserResultDto result(){
        List<UserResultEntity> userResultEntityList = voteResultDao.findUserAndCount(Collectors.toList());
        NenbetsUserResultDto nenbetsUserResultDto = new NenbetsUserResultDto(
                new ArrayList<>(),
                new ArrayList<>()
        );
        for (UserResultEntity userResultEntity : userResultEntityList) {
            switch (userResultEntity.getNyushaNensu()){
                case 1:
                    nenbetsUserResultDto.getShinjin().add(
                            new UserResultDto(
                                    userResultEntity.getHappyoShaNo(),
                                    userResultEntity.getUserName(),
                                    userResultEntity.getTohyosu(),
                                    userResultEntity.getNyushaNensu(),
                                    1
                            )
                    );
                    break;
                case 2:
                    nenbetsUserResultDto.getNinenme().add(
                            new UserResultDto(
                                    userResultEntity.getHappyoShaNo(),
                                    userResultEntity.getUserName(),
                                    userResultEntity.getTohyosu(),
                                    userResultEntity.getNyushaNensu(),
                                    1
                            )
                    );
                    break;
                default:
                    break;
            }
        }
        for(UserResultDto shinjin1:nenbetsUserResultDto.getShinjin()){
            for(UserResultDto shinjin2:nenbetsUserResultDto.getShinjin()){
                if (shinjin1.getTohyosu()<shinjin2.getTohyosu()){
                    shinjin1.setJuni(shinjin1.getJuni()+1);
                }
            }
        }
        for(UserResultDto ninenme1:nenbetsUserResultDto.getNinenme()){
            for(UserResultDto ninenme2:nenbetsUserResultDto.getNinenme()){
                if (ninenme1.getTohyosu()<ninenme2.getTohyosu()){
                    ninenme1.setJuni(ninenme2.getJuni()+1);
                }
            }
        }
        return nenbetsUserResultDto;
    }

    public List<UserCommentEntity> showDetails(String happyoShaNo){
        return voteResultDao.findUserComment(happyoShaNo,Collectors.toList());
    }
}
