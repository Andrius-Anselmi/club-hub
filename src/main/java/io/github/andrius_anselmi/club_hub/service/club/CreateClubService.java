package io.github.andrius_anselmi.club_hub.service.club;

import io.github.andrius_anselmi.club_hub.entity.Club;
import io.github.andrius_anselmi.club_hub.entity.Stadium;
import io.github.andrius_anselmi.club_hub.repository.ClubRepository;
import io.github.andrius_anselmi.club_hub.service.stadium.FindStadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreateClubService {

    private final ClubRepository repository;
    private final FindStadiumService findStadiumService;

    public Club create(Club club){
        if(Objects.nonNull(club.getStadium())){
            club.setStadium(findStadiumService.findById(club.getStadium().getId()));
        }
        return repository.save(club);
    }




}
