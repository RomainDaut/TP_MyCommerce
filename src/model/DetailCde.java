package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DETAIL_CDE", schema = "mycommerce")
public class DetailCde {
    @Id
    @GeneratedValue
    private int id;
    private int quantite;
    private Commande commande;
    private Produit produit;

    @Basic
    @Column(name = "QUANTITE")
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailCde detailCde = (DetailCde) o;
        return quantite == detailCde.quantite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantite);
    }

    @ManyToOne
    @JoinColumn(name = "NCOMMANDE", referencedColumnName = "NCOMMANDE", nullable = false)
    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @ManyToOne
    @JoinColumn(name = "NPRODUIT", referencedColumnName = "NPRODUIT", nullable = false)
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
