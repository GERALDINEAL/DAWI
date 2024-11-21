package pe.edu.I202331145.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202331145.dominio.Country;
import pe.edu.I202331145.dominio.City;

import java.util.List;
import java.util.stream.Collectors;

public class JPAFind {

    public static void main(String[] args) {

        //referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        //obtener country
        // Country country = em.find(Country.class,"ABW") ;
        // System.out.println(country);

        // Buscar el país con código "PER"
        Country country = em.find(Country.class, "PER");

        if (country != null) {
            // Obtener la lista de ciudades de Perú
            List<City> cities = country.getCity();

            // Filtrar las ciudades con población mayor a 700k usando una función lambda
            List<String> citiesWithPopulationOver700k = cities.stream()
                    .filter(city -> city.getPopulation() > 700000) // Filtra ciudades con población > 700,000
                    .map(City::getName) // Mapea las ciudades a sus nombres
                    .collect(Collectors.toList()); // Recoge el resultado en una lista

            // Imprimir el nombre de las ciudades
            if (!citiesWithPopulationOver700k.isEmpty()) {
                System.out.println("Ciudades peruanas con población mayor a 700,000:");
                citiesWithPopulationOver700k.forEach(System.out::println);
            } else {
                System.out.println("No se encontraron ciudades con población mayor a 700,000.");
            }
        } else {
            System.out.println("No se encontró el país con código 'PER'.");
        }

        // Cerrar la conexión con la base de datos
        em.close();
        emf.close();
    }
}
