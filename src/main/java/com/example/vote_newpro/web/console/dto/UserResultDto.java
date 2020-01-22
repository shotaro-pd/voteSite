package com.example.vote_newpro.web.console.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

@Data
@AllArgsConstructor
public class UserResultDto {
    private String happyoShaNo;
    private String userName;
    private int tohyosu;
    private int nyushaNensu;
    private int juni;
}
