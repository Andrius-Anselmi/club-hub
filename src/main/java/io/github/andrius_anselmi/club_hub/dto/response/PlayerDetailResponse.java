package io.github.andrius_anselmi.club_hub.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
        "id",
        "name",
        "position",
        "shirtNumber",
        "club",
        "urlImg"
})

@Getter
@Setter
public class PlayerDetailResponse {

    private Long id;
    private String name;
    private String position;
    private int shirtNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String urlImg;
    private ClubBasicResponse club;
}
