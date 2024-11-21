package pe.edu.I202331145.cl1_jpa_data_Atoche_Geraldine.repository;


import org.springframework.data.repository.CrudRepository;
import pe.edu.I202331145.cl1_jpa_data_Atoche_Geraldine.entity.Country;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, String> {

}
