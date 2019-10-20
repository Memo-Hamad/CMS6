package main.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Agent", schema = "dbo", catalog = "CustomDB")
public class AgentEntity {
  //  private int agentId;
    private String firstName;
    private String lastName;
    private int agencyCode;
    private String agentCompany;
    private String loginId;
    private String loginPass;
    private Collection<DeclarationEntity> declarationsByAgentId;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "AgentID", nullable = false)
    int agentId;
    public int getAgentId() {
        return agentId;
    }


    //public void setAgentId(int agentId) {
       // this.agentId = agentId;
    //}

    @Basic
    @Column(name = "FirstName", nullable = false, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LastName", nullable = false, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "AgencyCode", nullable = false)
    public int getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(int agencyCode) {
        this.agencyCode = agencyCode;
    }

    @Basic
    @Column(name = "AgentCompany", nullable = false, length = 255)
    public String getAgentCompany() {
        return agentCompany;
    }

    public void setAgentCompany(String agentCompany) {
        this.agentCompany = agentCompany;
    }

    @Basic
    @Column(name = "LoginID", nullable = true, length = 255)
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "LoginPass", nullable = true, length = 255)
    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgentEntity that = (AgentEntity) o;

        if (agentId != that.agentId) return false;
        if (agencyCode != that.agencyCode) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (agentCompany != null ? !agentCompany.equals(that.agentCompany) : that.agentCompany != null) return false;
        if (loginId != null ? !loginId.equals(that.loginId) : that.loginId != null) return false;
        if (loginPass != null ? !loginPass.equals(that.loginPass) : that.loginPass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = agentId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + agencyCode;
        result = 31 * result + (agentCompany != null ? agentCompany.hashCode() : 0);
        result = 31 * result + (loginId != null ? loginId.hashCode() : 0);
        result = 31 * result + (loginPass != null ? loginPass.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "agentByAgentId")
    public Collection<DeclarationEntity> getDeclarationsByAgentId() {
        return declarationsByAgentId;
    }

    public void setDeclarationsByAgentId(Collection<DeclarationEntity> declarationsByAgentId) {
        this.declarationsByAgentId = declarationsByAgentId;
    }
}
