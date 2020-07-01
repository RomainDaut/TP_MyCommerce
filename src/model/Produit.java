package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = "Produit.findAll",
                        query = "select p from Produit p"),
                @NamedQuery(name = "Produit.findbyId",
                        query = "select p from Produit p where p.nproduit= :id")
        }
)
public class Produit {
    private String nproduit;
    private String descriptif;
    private BigDecimal prix;
    private String disponible;
    private int qteenstock;
    private Collection<DetailCde> detailCdes;

    @Id
    @Column(name = "NPRODUIT")
    public String getNproduit() {
        return nproduit;
    }

    public void setNproduit(String nproduit) {
        this.nproduit = nproduit;
    }

    @Basic
    @Column(name = "DESCRIPTIF")
    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    @Basic
    @Column(name = "PRIX")
    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "DISPONIBLE")
    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    @Basic
    @Column(name = "QTEENSTOCK")
    public int getQteenstock() {
        return qteenstock;
    }

    public void setQteenstock(int qteenstock) {
        this.qteenstock = qteenstock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return qteenstock == produit.qteenstock &&
                Objects.equals(nproduit, produit.nproduit) &&
                Objects.equals(descriptif, produit.descriptif) &&
                Objects.equals(prix, produit.prix) &&
                Objects.equals(disponible, produit.disponible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nproduit, descriptif, prix, disponible, qteenstock);
    }

    @OneToMany(mappedBy = "produit")
    public Collection<DetailCde> getDetailCdes() {
        return detailCdes;
    }

    public void setDetailCdes(Collection<DetailCde> detailCdes) {
        this.detailCdes = detailCdes;
    }
}
