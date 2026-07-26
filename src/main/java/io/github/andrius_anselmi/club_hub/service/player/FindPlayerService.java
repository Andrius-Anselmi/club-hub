package io.github.andrius_anselmi.club_hub.service.player;

import io.github.andrius_anselmi.club_hub.entity.Player;
import io.github.andrius_anselmi.club_hub.exception.ResourceNotFoundException;
import io.github.andrius_anselmi.club_hub.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindPlayerService {

    private final PlayerRepository repository;


    public Page<Player> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Player findById(Long id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("this not found " + id));
    }

}
