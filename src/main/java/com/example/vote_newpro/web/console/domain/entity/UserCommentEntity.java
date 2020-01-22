package com.example.vote_newpro.web.console.domain.entity;

import lombok.Value;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_LOWER_CASE, immutable = true)
@Table
@Value
public class UserCommentEntity {
    private String userName;
    private String comment;
}
