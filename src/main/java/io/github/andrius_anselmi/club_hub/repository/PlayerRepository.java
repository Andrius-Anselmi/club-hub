package io.github.andrius_anselmi.club_hub.repository;

import io.github.andrius_anselmi.club_hub.entity.Player;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @EntityGraph(attributePaths = "club")
    List<Player> findPlayerByClubId(Long id);
}
