package io.github.andrius_anselmi.club_hub.controller;

import io.github.andrius_anselmi.club_hub.dto.request.PlayerRequest;
import io.github.andrius_anselmi.club_hub.dto.response.PlayerResponse;
import io.github.andrius_anselmi.club_hub.dto.response.PlayerDetailResponse;
import io.github.andrius_anselmi.club_hub.mapper.PlayerMapper;
import io.github.andrius_anselmi.club_hub.service.player.CreatePlayerService;
import io.github.andrius_anselmi.club_hub.service.player.FindPlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final FindPlayerService findPlayerService;
    private final CreatePlayerService createPlayerService;
    private final PlayerMapper playerMapper;

    @PostMapping()
    public ResponseEntity<PlayerDetailResponse> create(@Valid @RequestBody PlayerRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(playerMapper.toPlayerDetailResponse(createPlayerService.save(playerMapper.toPlayer(request))));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<PlayerResponse> findAll(Pageable pageable){
        return findPlayerService.findAll(pageable).map(playerMapper::toPlayerResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDetailResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(playerMapper.toPlayerDetailResponse(findPlayerService.findById(id)));
    }

}
