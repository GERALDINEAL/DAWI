package pe.edu.I202331145.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202331145.dominio.City;
import pe.edu.I202331145.dominio.Country;
import pe.edu.I202331145.dominio.CountryLanguage;

public class JPAPersist {

    public static void main(String[] args) {

        //referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        //registre un país imaginario, que tenga 3 ciudades y 2 lenguajes nativos
        Country country = new Country();
        country.setCode("REY");
        country.setName("Reylandia");
        country.setContinent("South America");
        country.setRegion("South");
        country.setSurfaceArea(50000.0);
        country.setIndepYear(2024);
        country.setPopulation(10000000);
        country.setLifeExpectancy(75.0);
        country.setGnp(20000.0);
        country.setGnpOld(19000.0);
        country.setLocalName("Reylandia");
        country.setGovernmentForm("Republic");
        country.setHeadOfState("President");
        country.setCapital(1);
        country.setCode2("RE");


        // Crear ciudades
        City city1 = new City();
        city1.setName("Peru City");
        city1.setDistrict("Lima District");
        city1.setPopulation(3000000);
        city1.setCountry(country);

        City city2 = new City();
        city2.setName("New Peru");
        city2.setDistrict("XY District");
        city2.setPopulation(1500000);
        city2.setCountry(country);

        City city3 = new City();
        city3.setName("Old Peru");
        city3.setDistrict("XZ");
        city3.setPopulation(500000);
        city3.setCountry(country);

        // Crear lenguajes
        CountryLanguage lang1 = new CountryLanguage();
        lang1.setCountry(country);
        lang1.setLanguage("Peruano");
        lang1.setIsOfficial("T");
        lang1.setPercentage(90.0);

        CountryLanguage lang2 = new CountryLanguage();
        lang2.setCountry(country);
        lang2.setLanguage("Quechua");
        lang2.setIsOfficial("F");
        lang2.setPercentage(10.0);


        // Persistir datos
        em.getTransaction().begin();
        em.persist(country);
        em.persist(city1);
        em.persist(city2);
        em.persist(city3);
        em.persist(lang1);
        em.persist(lang2);
        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}
