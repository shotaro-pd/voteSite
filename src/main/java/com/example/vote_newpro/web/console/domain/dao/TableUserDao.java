package com.example.vote_newpro.web.console.domain.dao;

import com.example.vote_newpro.web.console.domain.entity.TableUserEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.Optional;
import java.util.stream.Collector;

@Dao
@ConfigAutowireable
public interface TableUserDao {
    @Select
    Optional<TableUserEntity> selectAll(String userId);

    @Select(strategy = SelectType.COLLECT)
    <R> R selectHappyoSha(String userId,Collector<TableUserEntity, ?, R> collector);
}
