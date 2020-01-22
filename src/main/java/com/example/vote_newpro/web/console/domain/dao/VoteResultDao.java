package com.example.vote_newpro.web.console.domain.dao;

import com.example.vote_newpro.web.console.domain.entity.VoteResultEntity;
import org.seasar.doma.BatchInsert;
import org.seasar.doma.Dao;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.BatchResult;

import java.util.List;

@Dao
@ConfigAutowireable
public interface VoteResultDao {
    @BatchInsert
    BatchResult<VoteResultEntity> insert(List<VoteResultEntity> voteResultEntityList);
}
