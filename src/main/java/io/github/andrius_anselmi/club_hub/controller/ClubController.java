package io.github.andrius_anselmi.club_hub.controller;

import io.github.andrius_anselmi.club_hub.dto.request.ClubRequest;
import io.github.andrius_anselmi.club_hub.dto.response.ClubDetailResponse;
import io.github.andrius_anselmi.club_hub.dto.response.ClubResponse;
import io.github.andrius_anselmi.club_hub.mapper.ClubMapper;
import io.github.andrius_anselmi.club_hub.service.club.CreateClubService;
import io.github.andrius_anselmi.club_hub.service.club.FindClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/club")
@RequiredArgsConstructor
public class ClubController {

    private final FindClubService findClubService;
    private final CreateClubService createClubService;
    private final ClubMapper clubMapper;

    @PostMapping()
    public ResponseEntity<ClubDetailResponse> save(@RequestBody ClubRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(clubMapper.toClubDetailResponse(createClubService.create(clubMapper.toClub(request))));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<ClubResponse> findAll(Pageable pageable){
        return findClubService.findAll(pageable).map(clubMapper::toClubResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubDetailResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(clubMapper.toClubDetailResponse(findClubService.findById(id)));
    }
}
