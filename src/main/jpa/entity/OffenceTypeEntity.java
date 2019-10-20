package main.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "OffenceType", schema = "dbo", catalog = "CustomDB")
public class OffenceTypeEntity {
    private String offenceTypeCode;
    private String offenceType;
    private Collection<OffenceEntity> offencesByOffenceTypeCode;

    @Id
    @Column(name = "OffenceTypeCode", nullable = false, length = 1)
    public String getOffenceTypeCode() {
        return offenceTypeCode;
    }

    public void setOffenceTypeCode(String offenceTypeCode) {
        this.offenceTypeCode = offenceTypeCode;
    }

    @Basic
    @Column(name = "OffenceType", nullable = false, length = 255)
    public String getOffenceType() {
        return offenceType;
    }

    public void setOffenceType(String offenceType) {
        this.offenceType = offenceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OffenceTypeEntity that = (OffenceTypeEntity) o;

        if (offenceTypeCode != null ? !offenceTypeCode.equals(that.offenceTypeCode) : that.offenceTypeCode != null)
            return false;
        if (offenceType != null ? !offenceType.equals(that.offenceType) : that.offenceType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = offenceTypeCode != null ? offenceTypeCode.hashCode() : 0;
        result = 31 * result + (offenceType != null ? offenceType.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "offenceTypeByOffenseTypeCode")
    public Collection<OffenceEntity> getOffencesByOffenceTypeCode() {
        return offencesByOffenceTypeCode;
    }

    public void setOffencesByOffenceTypeCode(Collection<OffenceEntity> offencesByOffenceTypeCode) {
        this.offencesByOffenceTypeCode = offencesByOffenceTypeCode;
    }
}
