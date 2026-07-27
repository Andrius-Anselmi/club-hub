package io.github.andrius_anselmi.club_hub.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({
        "id",
        "name",
        "city",
        "capacity",
        "urlImg"
})
public class StadiumResponse{

    private Long id;
    private String name;
    private String city;
    private Integer capacity;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String urlImg;


}
