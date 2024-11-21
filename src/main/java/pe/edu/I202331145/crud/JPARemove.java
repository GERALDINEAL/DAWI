package pe.edu.I202331145.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202331145.dominio.Country;

public class JPARemove {

    public static void main(String[] args) {

        //referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        //registre un país imaginario, que tenga 3 ciudades y 2 lenguajes nativos
        Country country = em.find(Country.class, "REY");

        // remover datos
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();

    }
}
