package main.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Country", schema = "dbo", catalog = "CustomDB")
public class CountryEntity {
    private String countryCode;
    private String countryName;
    private Collection<DeclarationEntity> declarationsByCountryCode;

    @Id
    @Column(name = "CountryCode", nullable = false, length = 3)
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "CountryName", nullable = false, length = 255)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryEntity that = (CountryEntity) o;

        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryCode != null ? countryCode.hashCode() : 0;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "countryByCountryCode")
    public Collection<DeclarationEntity> getDeclarationsByCountryCode() {
        return declarationsByCountryCode;
    }

    public void setDeclarationsByCountryCode(Collection<DeclarationEntity> declarationsByCountryCode) {
        this.declarationsByCountryCode = declarationsByCountryCode;
    }
}
