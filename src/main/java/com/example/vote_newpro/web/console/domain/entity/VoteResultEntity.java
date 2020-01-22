package com.example.vote_newpro.web.console.domain.entity;

import lombok.Value;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_LOWER_CASE, immutable = true)
@Table(name = "vote_result")
@Value
public class VoteResultEntity {
    private String tohyoShaNo;
    private String happyoShaNo;
    private String comment;
}
