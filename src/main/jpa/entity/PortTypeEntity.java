package main.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PortType", schema = "dbo", catalog = "CustomDB")
public class PortTypeEntity {
    private String portTypeCode;
    private String portType;
    private Collection<PortEntity> portsByPortTypeCode;

    @Id
    @Column(name = "PortTypeCode", nullable = false, length = 1)
    public String getPortTypeCode() {
        return portTypeCode;
    }

    public void setPortTypeCode(String portTypeCode) {
        this.portTypeCode = portTypeCode;
    }

    @Basic
    @Column(name = "PortType", nullable = false, length = 255)
    public String getPortType() {
        return portType;
    }

    public void setPortType(String portType) {
        this.portType = portType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PortTypeEntity that = (PortTypeEntity) o;

        if (portTypeCode != null ? !portTypeCode.equals(that.portTypeCode) : that.portTypeCode != null) return false;
        if (portType != null ? !portType.equals(that.portType) : that.portType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = portTypeCode != null ? portTypeCode.hashCode() : 0;
        result = 31 * result + (portType != null ? portType.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "portTypeByPortTypeCode")
    public Collection<PortEntity> getPortsByPortTypeCode() {
        return portsByPortTypeCode;
    }

    public void setPortsByPortTypeCode(Collection<PortEntity> portsByPortTypeCode) {
        this.portsByPortTypeCode = portsByPortTypeCode;
    }
}
