package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Client.findAll",
                query = "SELECT c from Client c"),
        @NamedQuery(name = "Client.findByNom&Password",
                query = "SELECT c FROM Client c WHERE c.nom= :nom and c.motdepasse= :motdepasse")
})

public class Client {
    private String nom;
    private String motdepasse;
    private Collection<Commande> commandes;

    @Id
    @Column(name = "NOM")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "MOTDEPASSE")
    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(nom, client.nom) &&
                Objects.equals(motdepasse, client.motdepasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, motdepasse);
    }

    @OneToMany(mappedBy = "client")
    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }
}
