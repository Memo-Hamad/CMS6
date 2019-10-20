package main.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "DeclarationStatus", schema = "dbo", catalog = "CustomDB")
public class DeclarationStatusEntity {
    private String decStatusCode;
    private String decStatus;
    private Collection<DeclarationEntity> declarationsByDecStatusCode;

    @Id
    @Column(name = "DecStatusCode", nullable = false, length = 2)
    public String getDecStatusCode() {
        return decStatusCode;
    }

    public void setDecStatusCode(String decStatusCode) {
        this.decStatusCode = decStatusCode;
    }

    @Basic
    @Column(name = "DecStatus", nullable = false, length = 255)
    public String getDecStatus() {
        return decStatus;
    }

    public void setDecStatus(String decStatus) {
        this.decStatus = decStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeclarationStatusEntity that = (DeclarationStatusEntity) o;

        if (decStatusCode != null ? !decStatusCode.equals(that.decStatusCode) : that.decStatusCode != null)
            return false;
        if (decStatus != null ? !decStatus.equals(that.decStatus) : that.decStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = decStatusCode != null ? decStatusCode.hashCode() : 0;
        result = 31 * result + (decStatus != null ? decStatus.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "declarationStatusByDecStatusCode")
    public Collection<DeclarationEntity> getDeclarationsByDecStatusCode() {
        return declarationsByDecStatusCode;
    }

    public void setDeclarationsByDecStatusCode(Collection<DeclarationEntity> declarationsByDecStatusCode) {
        this.declarationsByDecStatusCode = declarationsByDecStatusCode;
    }
}
