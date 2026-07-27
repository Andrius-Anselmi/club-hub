package io.github.andrius_anselmi.club_hub.controller;

import io.github.andrius_anselmi.club_hub.dto.response.PositionResponse;
import io.github.andrius_anselmi.club_hub.entity.Position;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PositionResponse> findPositions(){
        return Arrays.stream(Position.values()).map(position -> new PositionResponse(position.name(), position.getLabel())).toList();
    }
}
