package io.github.andrius_anselmi.club_hub.mapper;

import io.github.andrius_anselmi.club_hub.dto.request.PlayerRequest;
import io.github.andrius_anselmi.club_hub.dto.response.*;
import io.github.andrius_anselmi.club_hub.entity.Player;
import io.github.andrius_anselmi.club_hub.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "club.id", source = "clubId")
    Player toPlayer(PlayerRequest request);

    PlayerResponse toPlayerResponse(Player player);

    default String mapPositionToString(Position position){
        return position != null ? position.getLabel() : null;
    }

    PlayerDetailResponse toPlayerDetailResponse(Player player);

}
