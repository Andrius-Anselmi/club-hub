package io.github.andrius_anselmi.club_hub.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StadiumRequest {
        @NotBlank
        private String name;
        @NotBlank
        private String city;
        private Integer capacity;
        private String urlImg;

}
