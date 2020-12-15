/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Vitor Manoel
 */
@Entity
@Table(name = "service", catalog = "empresa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s")
    , @NamedQuery(name = "Service.findById", query = "SELECT s FROM Service s WHERE s.servicePK.id = :id")
    , @NamedQuery(name = "Service.findByName", query = "SELECT s FROM Service s WHERE s.servicePK.name = :name")
    , @NamedQuery(name = "Service.findByPrice", query = "SELECT s FROM Service s WHERE s.price = :price")
    , @NamedQuery(name = "Service.findByServiceTime", query = "SELECT s FROM Service s WHERE s.serviceTime = :serviceTime")
    , @NamedQuery(name = "Service.findByIdClinic", query = "SELECT s FROM Service s WHERE s.idClinic = :idClinic")})
public class Service implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServicePK servicePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Float price;
    @Column(name = "service_time")
    @Temporal(TemporalType.TIME)
    private Date serviceTime;
    @Column(name = "id_clinic")
    private BigInteger idClinic;

    public Service() {
    }

    public Service(ServicePK servicePK) {
        this.servicePK = servicePK;
    }

    public Service(int id, String name) {
        this.servicePK = new ServicePK(id, name);
    }

    public ServicePK getServicePK() {
        return servicePK;
    }

    public void setServicePK(ServicePK servicePK) {
        this.servicePK = servicePK;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        Float oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        Date oldServiceTime = this.serviceTime;
        this.serviceTime = serviceTime;
        changeSupport.firePropertyChange("serviceTime", oldServiceTime, serviceTime);
    }

    public BigInteger getIdClinic() {
        return idClinic;
    }

    public void setIdClinic(BigInteger idClinic) {
        BigInteger oldIdClinic = this.idClinic;
        this.idClinic = idClinic;
        changeSupport.firePropertyChange("idClinic", oldIdClinic, idClinic);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicePK != null ? servicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.servicePK == null && other.servicePK != null) || (this.servicePK != null && !this.servicePK.equals(other.servicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "application.Service[ servicePK=" + servicePK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
