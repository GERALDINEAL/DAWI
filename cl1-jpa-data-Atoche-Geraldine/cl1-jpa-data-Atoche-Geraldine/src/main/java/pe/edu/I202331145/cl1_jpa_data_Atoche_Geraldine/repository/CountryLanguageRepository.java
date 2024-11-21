package pe.edu.I202331145.cl1_jpa_data_Atoche_Geraldine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.I202331145.cl1_jpa_data_Atoche_Geraldine.entity.CountryLanguage;

import java.util.List;
import java.util.Optional;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, String> {

    @Query("SELECT cl.language FROM CountryLanguage cl WHERE cl.CountryCode = :countryCode")
    Optional<List<String>> findLanguagesByCountryCode(String countryCode);
}
