package io.github.andrius_anselmi.club_hub.service;

import io.github.andrius_anselmi.club_hub.entity.Stadium;
import io.github.andrius_anselmi.club_hub.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StadiumService {

    private final StadiumRepository repository;

    public Stadium save(Stadium stadium){
        return repository.save(stadium);
    }

}
