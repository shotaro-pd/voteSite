package com.example.vote_newpro.web.console.domain.dao;

import com.example.vote_newpro.web.console.domain.entity.UserCommentEntity;
import com.example.vote_newpro.web.console.domain.entity.UserResultEntity;
import com.example.vote_newpro.web.console.domain.entity.VoteResultEntity;
import org.seasar.doma.BatchInsert;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.BatchResult;

import java.util.List;
import java.util.stream.Collector;

@Dao
@ConfigAutowireable
public interface VoteResultDao {
    @BatchInsert
    BatchResult<VoteResultEntity> insert(List<VoteResultEntity> voteResultEntityList);

    @Select(strategy = SelectType.COLLECT)
     <R> R findUserAndCount(Collector<UserResultEntity, ?, R> collector);

    @Select(strategy = SelectType.COLLECT)
    <R> R findUserComment(String happyoShaNo,Collector<UserCommentEntity, ?, R> collector);
}
