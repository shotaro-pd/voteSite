package com.example.vote_newpro.web.console.dto;

import com.example.vote_newpro.web.console.domain.entity.TableUserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class NenbetsDto {
    List<TableUserEntity> shinjin;
    List<TableUserEntity> ninenme;
}
