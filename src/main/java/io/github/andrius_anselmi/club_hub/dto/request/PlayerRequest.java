package io.github.andrius_anselmi.club_hub.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.andrius_anselmi.club_hub.entity.Position;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerRequest {

    @NotBlank
    private String name;
    @NotNull
    private Position position;
    @NotNull
    private int shirtNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String urlImg;

    @NotNull
    private Long clubId;

}
