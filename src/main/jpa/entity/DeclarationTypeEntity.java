package main.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "DeclarationType", schema = "dbo", catalog = "CustomDB")
public class DeclarationTypeEntity {
    private String decTypeCode;
    private String decType;
    private Collection<DeclarationEntity> declarationsByDecTypeCode;

    @Id
    @Column(name = "DecTypeCode", nullable = false, length = 1)
    public String getDecTypeCode() {
        return decTypeCode;
    }

    public void setDecTypeCode(String decTypeCode) {
        this.decTypeCode = decTypeCode;
    }

    @Basic
    @Column(name = "DecType", nullable = false, length = 255)
    public String getDecType() {
        return decType;
    }

    public void setDecType(String decType) {
        this.decType = decType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeclarationTypeEntity that = (DeclarationTypeEntity) o;

        if (decTypeCode != null ? !decTypeCode.equals(that.decTypeCode) : that.decTypeCode != null) return false;
        if (decType != null ? !decType.equals(that.decType) : that.decType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = decTypeCode != null ? decTypeCode.hashCode() : 0;
        result = 31 * result + (decType != null ? decType.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "declarationTypeByDecTypeCode")
    public Collection<DeclarationEntity> getDeclarationsByDecTypeCode() {
        return declarationsByDecTypeCode;
    }

    public void setDeclarationsByDecTypeCode(Collection<DeclarationEntity> declarationsByDecTypeCode) {
        this.declarationsByDecTypeCode = declarationsByDecTypeCode;
    }
}
