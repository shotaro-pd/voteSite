package com.example.vote_newpro.web.console.domain.entity;

import lombok.Value;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_LOWER_CASE, immutable = true)
@Table(name = "table_user")
@Value
public class TableUserEntity {
    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "nyusha_nensu")
    private int nyushaNensu;

}
