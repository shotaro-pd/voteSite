package com.example.vote_newpro.web.console.controller.form;

import com.example.vote_newpro.web.console.domain.entity.TableUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ValidForm  implements Serializable {
    @NotNull
    @Size(min = 2,max = 2)
    private List<String> shinjinId;

    @NotNull
    @Size(min = 2,max = 2)
    private List<String> ninenmeId;

    @NotNull
    @Size(min = 2)
    private List<String> shinjinComment;

    @NotNull
    @Size(min = 2)
    private List<String> ninenmeComment;
}
