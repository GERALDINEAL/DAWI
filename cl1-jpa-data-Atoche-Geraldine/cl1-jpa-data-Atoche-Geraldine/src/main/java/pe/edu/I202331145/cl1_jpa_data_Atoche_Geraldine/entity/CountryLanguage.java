package pe.edu.I202331145.cl1_jpa_data_Atoche_Geraldine.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "countrylanguage")
@IdClass(CountryLanguageId.class)
public class CountryLanguage {

    @Id
    private String language;
    private String isOfficial;
    private Double percentage;

    @ManyToOne
    @JoinColumn(name = "CountryCode")
    private Country country;


}
