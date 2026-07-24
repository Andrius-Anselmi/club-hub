package io.github.andrius_anselmi.club_hub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.net.Proxy;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    @SequenceGenerator(name = "player_seq", sequenceName = "player_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Position position;

    @Column(name = "shirt_number", nullable = false)
    private int shirtNumber;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

}
