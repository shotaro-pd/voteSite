package com.example.vote_newpro.web.console.dto;

import com.example.vote_newpro.web.console.domain.entity.TableUserEntity;
import com.example.vote_newpro.web.console.domain.entity.UserResultEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class NenbetsUserResultDto {
    List<UserResultDto> shinjin;
    List<UserResultDto> ninenme;
}
