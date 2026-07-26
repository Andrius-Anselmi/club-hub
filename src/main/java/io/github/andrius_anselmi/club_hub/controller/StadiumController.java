package io.github.andrius_anselmi.club_hub.controller;

import io.github.andrius_anselmi.club_hub.dto.request.StadiumRequest;
import io.github.andrius_anselmi.club_hub.dto.response.StadiumResponse;
import io.github.andrius_anselmi.club_hub.entity.Stadium;
import io.github.andrius_anselmi.club_hub.mapper.StadiumMapper;
import io.github.andrius_anselmi.club_hub.service.stadium.FindStadiumService;
import io.github.andrius_anselmi.club_hub.service.stadium.CreateStadiumService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/stadium")
@RequiredArgsConstructor
public class StadiumController {

    private final CreateStadiumService createStadiumService;
    private final FindStadiumService findStadiumService;
    private final StadiumMapper stadiumMapper;

    @PostMapping()
    public ResponseEntity<StadiumResponse> create(@Valid @RequestBody StadiumRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(stadiumMapper.toStadiumResponse(createStadiumService.save(stadiumMapper.toStadium(request))));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public Page<StadiumResponse> getAll(Pageable pageable){
        return findStadiumService.findAll(pageable).map(stadiumMapper::toStadiumResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stadium> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(findStadiumService.findById(id));
    }


}
