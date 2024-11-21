package pe.edu.I202331145.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202331145.dominio.Country;

public class JPAOneToManyCountryLanguage {

    public static void main(String[] args) {

        //referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        //obtener country
        Country country = em.find(Country.class, "ABW");

        //mostrar resultados
        country.getCountrylanguage().forEach(System.out::println);


}
}
