package io.github.andrius_anselmi.club_hub.mapper;

import io.github.andrius_anselmi.club_hub.dto.request.StadiumRequest;
import io.github.andrius_anselmi.club_hub.dto.response.StadiumResponse;
import io.github.andrius_anselmi.club_hub.entity.Stadium;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StadiumMapper {

    Stadium toStadium(StadiumRequest request);

    StadiumResponse toStadiumResponse(Stadium stadium);
}
