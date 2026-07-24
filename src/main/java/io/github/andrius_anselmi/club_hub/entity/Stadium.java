package io.github.andrius_anselmi.club_hub.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stadium_seq")
    @SequenceGenerator(name = "stadium_seq", sequenceName = "stadium_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    private Integer capacity;

    @Column(name = "url_img")
    private String urlImg;
}
