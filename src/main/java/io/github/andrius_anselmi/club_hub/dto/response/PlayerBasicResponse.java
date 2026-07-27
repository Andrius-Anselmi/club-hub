package io.github.andrius_anselmi.club_hub.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerBasicResponse {

    private String name;
    private String position;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String urlImg;
}
