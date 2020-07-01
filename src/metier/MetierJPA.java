package metier;

import model.Client;
import model.Produit;
import util.Catalog;
import util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetierJPA {
    //Gestion d'un Singleton
    private static MetierJPA metierJPA = null;

    private MetierJPA() {
    }

    public static MetierJPA getSingleton() {
        if (metierJPA == null) {
            metierJPA = new MetierJPA();
        }
        return metierJPA;
    }

    public Client findByNomandPassword(String nom, String motdepasse) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        Client client = em.createNamedQuery("Client.findByNom&Password", Client.class)
                .setParameter("nom", nom)
                .setParameter("motdepasse", motdepasse)
                .getSingleResult();
        em.close();
        return client;
    }

    public List<Produit> findAllProducts() {
        List<Produit> produits = new ArrayList<>();
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        try {
            produits = em.createNamedQuery("Produit.findAll", Produit.class).getResultList();
        } finally {
            em.close();
        }
        return produits;
    }

    public Catalog getCatalog() {
        Map<String, Produit> produit = new HashMap<>();
        for (Produit p : findAllProducts()) {
            produit.put(p.getNproduit(), p);
        }
        return new Catalog(produit);
    }

}
