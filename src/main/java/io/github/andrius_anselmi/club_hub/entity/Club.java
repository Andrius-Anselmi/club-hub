package io.github.andrius_anselmi.club_hub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_seq")
    @SequenceGenerator(name = "club_seq", sequenceName = "club_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDate founded;

    @Column(nullable = false, name = "url_img")
    private String urlImg;

    @OneToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    @OneToMany(mappedBy = "club")
    private List<Player> players;





}
