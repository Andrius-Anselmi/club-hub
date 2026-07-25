package io.github.andrius_anselmi.club_hub.service;

import io.github.andrius_anselmi.club_hub.Exception.StadiumNotFoundException;
import io.github.andrius_anselmi.club_hub.entity.Stadium;
import io.github.andrius_anselmi.club_hub.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindStadiumService {

    private final StadiumRepository repository;

    public Page<Stadium> findAll(Pageable pageable){
        return repository.findAll(pageable) ;
    }

    public Stadium findById(Long id){
        return repository.findById(id).orElseThrow(() -> new StadiumNotFoundException("Stadium not found this is"));
        }

    }


