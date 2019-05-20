/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.ceset.dto.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "tbl_notifficationbycheck")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notifficationbycheck.findAll", query = "SELECT n FROM Notifficationbycheck n"),
    @NamedQuery(name = "Notifficationbycheck.findById", query = "SELECT n FROM Notifficationbycheck n WHERE n.id = :id"),
    @NamedQuery(name = "Notifficationbycheck.findByIdNotif", query = "SELECT n FROM Notifficationbycheck n WHERE n.idNotif = :idNotif"),
    @NamedQuery(name = "Notifficationbycheck.findByIdCheck", query = "SELECT n FROM Notifficationbycheck n WHERE n.idCheck = :idCheck")})
public class Notifficationbycheck implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "idNotif")
    private Integer idNotif;
    @Column(name = "idCheck")
    private Integer idCheck;

    public Notifficationbycheck() {
    }

    public Notifficationbycheck(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdNotif() {
        return idNotif;
    }

    public void setIdNotif(Integer idNotif) {
        this.idNotif = idNotif;
    }

    public Integer getIdCheck() {
        return idCheck;
    }

    public void setIdCheck(Integer idCheck) {
        this.idCheck = idCheck;
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
        if (!(object instanceof Notifficationbycheck)) {
            return false;
        }
        Notifficationbycheck other = (Notifficationbycheck) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ceset.dto.entities.Notifficationbycheck[ id=" + id + " ]";
    }
    
}
