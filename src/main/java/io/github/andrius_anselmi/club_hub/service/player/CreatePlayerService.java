package io.github.andrius_anselmi.club_hub.service.player;

import io.github.andrius_anselmi.club_hub.entity.Player;
import io.github.andrius_anselmi.club_hub.repository.PlayerRepository;
import io.github.andrius_anselmi.club_hub.service.club.FindClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreatePlayerService {

    private final PlayerRepository repository;
    private final FindClubService findClubService;

    public Player save(Player player){
        player.setClub(findClubService.findById(player.getClub().getId()));
        return repository.save(player);
    }

}
