package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Commande {
    private int ncommande;
    private Date dateCde;
    private Client client;
    private Collection<DetailCde> detailCdes;

    @Id
    @Column(name = "NCOMMANDE")
    public int getNcommande() {
        return ncommande;
    }

    public void setNcommande(int ncommande) {
        this.ncommande = ncommande;
    }

    @Basic
    @Column(name = "DATE_CDE")
    public Date getDateCde() {
        return dateCde;
    }

    public void setDateCde(Date dateCde) {
        this.dateCde = dateCde;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return ncommande == commande.ncommande &&
                Objects.equals(dateCde, commande.dateCde);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ncommande, dateCde);
    }

    @ManyToOne
    @JoinColumn(name = "NOMCLIENT", referencedColumnName = "NOM", nullable = false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @OneToMany(mappedBy = "commande")
    public Collection<DetailCde> getDetailCdes() {
        return detailCdes;
    }

    public void setDetailCdes(Collection<DetailCde> detailCdes) {
        this.detailCdes = detailCdes;
    }
}
