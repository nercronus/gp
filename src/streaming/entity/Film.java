/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Formation
 */
@Entity
@Table(name="movie")
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id // clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // mes variables ici (avec getter and setter)
    
    @Column(nullable = false, length = 32, unique = true)
    private String titre;
    
    
    @Column(length = 4000)
    private String synopsis;
    
    @Column(nullable = false)
    private int anneeProd;
    
    @ManyToMany(mappedBy = "films")
    private List<Acteur> acteurs = new ArrayList<>();
    
 
    /*
    @Temporal(javax.persistence.TemporalType.DATE) // J'ai cliqué sur la petite ampoule pour obtenir cette ligne
    private Date dateSortie;
    */

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getAnneeProd() {
        return anneeProd;
    }

    public void setAnneeProd(int anneeProd) {
        this.anneeProd = anneeProd;
    }
    
    

    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Film[ id=" + id + " ]";
    }
    
}
