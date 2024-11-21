package pe.edu.I202331145.cl1_jpa_data_Atoche_Geraldine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.I202331145.cl1_jpa_data_Atoche_Geraldine.entity.Country;
import pe.edu.I202331145.cl1_jpa_data_Atoche_Geraldine.entity.CountryLanguage;
import pe.edu.I202331145.cl1_jpa_data_Atoche_Geraldine.repository.CountryLanguageRepository;
import pe.edu.I202331145.cl1_jpa_data_Atoche_Geraldine.repository.CountryRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataAtocheGeraldineApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;


	@Autowired
	private CountryLanguageRepository countryLanguageRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataAtocheGeraldineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 1. Consulta ifPresentOrElse
		System.out.println("=== Consulta de lenguajes en 'ARG' o 'PER' ===");
		Optional<List<String>> languagesArg = countryLanguageRepository.findLanguagesByCountryCode("ARG");
		languagesArg.ifPresentOrElse(
				languages -> languages.forEach(lang -> System.out.println("Lenguaje (ARG): " + lang)),
				() -> {
					System.out.println("No se encontraron lenguajes para 'ARG'. Mostrando lenguajes de 'PER':");
					countryLanguageRepository.findLanguagesByCountryCode("PER")
							.ifPresent(
									languagesPer -> languagesPer.forEach(lang -> System.out.println("Lenguaje (PER): " + lang)));

				}
		);

		// 2. Eliminar países 'COL' y 'ARG'
		System.out.println("\n=== Eliminando países 'COL' y 'ARG' ===");
		countryRepository.deleteAllById(Arrays.asList("COL", "ARG"));
		System.out.println("Países eliminados: COL, ARG");

		// 3. Volver a ejecutar la primera consulta
		System.out.println("\n=== Consulta de lenguajes en 'ARG' o 'PER' después de eliminación ===");
		languagesArg = countryLanguageRepository.findLanguagesByCountryCode("ARG");
		languagesArg.ifPresentOrElse(
				languages -> languages.forEach(lang -> System.out.println("Lenguaje (ARG): " + lang)),
				() -> {
					System.out.println("No se encontraron lenguajes para 'ARG'. Mostrando lenguajes de 'PER':");
					countryLanguageRepository.findLanguagesByCountryCode("PER")
							.ifPresent(languagesPer -> languagesPer.forEach(lang -> System.out.println("Lenguaje (PER): " + lang)));
				}
		);
	}
}





