package io.github.andrius_anselmi.club_hub.controller;

import io.github.andrius_anselmi.club_hub.dto.request.ClubRequest;
import io.github.andrius_anselmi.club_hub.dto.response.ClubBasicResponse;
import io.github.andrius_anselmi.club_hub.dto.response.ClubDetailResponse;
import io.github.andrius_anselmi.club_hub.dto.response.PlayerBasicResponse;
import io.github.andrius_anselmi.club_hub.mapper.ClubMapper;
import io.github.andrius_anselmi.club_hub.mapper.PlayerMapper;
import io.github.andrius_anselmi.club_hub.service.club.CreateClubService;
import io.github.andrius_anselmi.club_hub.service.club.FindClubService;
import io.github.andrius_anselmi.club_hub.service.player.FindPlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")
@RequiredArgsConstructor
public class ClubController {

    private final FindClubService findClubService;
    private final CreateClubService createClubService;
    private final ClubMapper clubMapper;
    private final PlayerMapper playerMapper;
    private final FindPlayerService findPlayerService;

    @PostMapping()
    public ResponseEntity<ClubDetailResponse> save(@Valid @RequestBody ClubRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(clubMapper.toClubDetailResponse(createClubService.create(clubMapper.toClub(request))));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<ClubBasicResponse> findAll(Pageable pageable){
        return findClubService.findAll(pageable).map(clubMapper::toClubBasicResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubDetailResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(clubMapper.toClubDetailResponse(findClubService.findById(id)));
    }

    @GetMapping("/players/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerBasicResponse> findPlayersByClub(@PathVariable Long id){
        return findPlayerService.findPlayersByClubById(id).stream().map(playerMapper::toPlayerBasicResponse).toList();
    }
}
