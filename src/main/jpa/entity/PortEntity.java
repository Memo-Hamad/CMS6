package main.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Port", schema = "dbo", catalog = "CustomDB")
public class PortEntity {
  //  private int portId;
    private String portName;
    private String location;
    private Collection<DeclarationEntity> declarationsByPortId;
    private PortTypeEntity portTypeByPortTypeCode;

    @Id
    @Column(name = "PortID", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int portId;
    public int getPortId() {
        return portId;
    }

    //public void setPortId(int portId) {
      //  this.portId = portId;
    //}

    @Basic
    @Column(name = "PortName", nullable = false, length = 255)
    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    @Basic
    @Column(name = "Location", nullable = true, length = 255)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PortEntity that = (PortEntity) o;

        if (portId != that.portId) return false;
        if (portName != null ? !portName.equals(that.portName) : that.portName != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = portId;
        result = 31 * result + (portName != null ? portName.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "portByPortID")
    public Collection<DeclarationEntity> getDeclarationsByPortId() {
        return declarationsByPortId;
    }

    public void setDeclarationsByPortId(Collection<DeclarationEntity> declarationsByPortId) {
        this.declarationsByPortId = declarationsByPortId;
    }

    @ManyToOne
    @JoinColumn(name = "PortTypeCode", referencedColumnName = "PortTypeCode", nullable = false)
    public PortTypeEntity getPortTypeByPortTypeCode() {
        return portTypeByPortTypeCode;
    }

    public void setPortTypeByPortTypeCode(PortTypeEntity portTypeByPortTypeCode) {
        this.portTypeByPortTypeCode = portTypeByPortTypeCode;
    }
}
