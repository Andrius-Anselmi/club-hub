package io.github.andrius_anselmi.club_hub.mapper;

import io.github.andrius_anselmi.club_hub.dto.request.ClubRequest;
import io.github.andrius_anselmi.club_hub.dto.response.ClubDetailResponse;
import io.github.andrius_anselmi.club_hub.dto.response.ClubResponse;
import io.github.andrius_anselmi.club_hub.entity.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClubMapper {

    @Mapping(target = "stadium.id", source = "stadiumId")
    Club toClub(ClubRequest request);

    ClubResponse toClubResponse(Club club);

    ClubDetailResponse toClubDetailResponse(Club club);
}
