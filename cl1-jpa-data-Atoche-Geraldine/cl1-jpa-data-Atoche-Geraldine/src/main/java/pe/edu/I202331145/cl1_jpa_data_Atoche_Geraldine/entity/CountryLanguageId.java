package pe.edu.I202331145.cl1_jpa_data_Atoche_Geraldine.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class CountryLanguageId implements Serializable{

    private String countryCode;
    private String language;


}
