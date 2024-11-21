package pe.edu.I202331145.cl1_jpa_data_Atoche_Geraldine.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String district;
    private Integer population;

    @ManyToOne
    @JoinColumn(name="CountryCode")
    private Country country;



}
