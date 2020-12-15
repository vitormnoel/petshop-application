/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vitor Manoel
 */
@Embeddable
public class AppointmentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "date_query")
    @Temporal(TemporalType.DATE)
    private Date dateQuery;
    @Basic(optional = false)
    @Column(name = "hour_query")
    @Temporal(TemporalType.TIME)
    private Date hourQuery;

    public AppointmentPK() {
    }

    public AppointmentPK(Date dateQuery, Date hourQuery) {
        this.dateQuery = dateQuery;
        this.hourQuery = hourQuery;
    }

    public Date getDateQuery() {
        return dateQuery;
    }

    public void setDateQuery(Date dateQuery) {
        this.dateQuery = dateQuery;
    }

    public Date getHourQuery() {
        return hourQuery;
    }

    public void setHourQuery(Date hourQuery) {
        this.hourQuery = hourQuery;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dateQuery != null ? dateQuery.hashCode() : 0);
        hash += (hourQuery != null ? hourQuery.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppointmentPK)) {
            return false;
        }
        AppointmentPK other = (AppointmentPK) object;
        if ((this.dateQuery == null && other.dateQuery != null) || (this.dateQuery != null && !this.dateQuery.equals(other.dateQuery))) {
            return false;
        }
        if ((this.hourQuery == null && other.hourQuery != null) || (this.hourQuery != null && !this.hourQuery.equals(other.hourQuery))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "application.AppointmentPK[ dateQuery=" + dateQuery + ", hourQuery=" + hourQuery + " ]";
    }
    
}
