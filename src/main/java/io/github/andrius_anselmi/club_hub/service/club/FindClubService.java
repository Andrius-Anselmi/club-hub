package io.github.andrius_anselmi.club_hub.service.club;

import io.github.andrius_anselmi.club_hub.exception.ResourceNotFoundException;
import io.github.andrius_anselmi.club_hub.entity.Club;
import io.github.andrius_anselmi.club_hub.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindClubService {

    private final ClubRepository repository;

    public Page<Club> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Club findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Club not found for id " + id));
    }
}
