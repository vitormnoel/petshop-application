/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Vitor Manoel
 */
@Entity
@Table(name = "appointment", catalog = "empresa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a")
    , @NamedQuery(name = "Appointment.findByDateQuery", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.dateQuery = :dateQuery")
    , @NamedQuery(name = "Appointment.findByHourQuery", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.hourQuery = :hourQuery")
    , @NamedQuery(name = "Appointment.findById", query = "SELECT a FROM Appointment a WHERE a.id = :id")
    , @NamedQuery(name = "Appointment.findByIdVet", query = "SELECT a FROM Appointment a WHERE a.idVet = :idVet")})
public class Appointment implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AppointmentPK appointmentPK;
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_vet")
    private Integer idVet;

    public Appointment() {
    }

    public Appointment(AppointmentPK appointmentPK) {
        this.appointmentPK = appointmentPK;
    }

    public Appointment(Date dateQuery, Date hourQuery) {
        this.appointmentPK = new AppointmentPK(dateQuery, hourQuery);
    }

    public AppointmentPK getAppointmentPK() {
        return appointmentPK;
    }

    public void setAppointmentPK(AppointmentPK appointmentPK) {
        this.appointmentPK = appointmentPK;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getIdVet() {
        return idVet;
    }

    public void setIdVet(Integer idVet) {
        Integer oldIdVet = this.idVet;
        this.idVet = idVet;
        changeSupport.firePropertyChange("idVet", oldIdVet, idVet);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentPK != null ? appointmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.appointmentPK == null && other.appointmentPK != null) || (this.appointmentPK != null && !this.appointmentPK.equals(other.appointmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "application.Appointment[ appointmentPK=" + appointmentPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
