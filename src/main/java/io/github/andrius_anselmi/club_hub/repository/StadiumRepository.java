package io.github.andrius_anselmi.club_hub.repository;

import io.github.andrius_anselmi.club_hub.entity.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}
