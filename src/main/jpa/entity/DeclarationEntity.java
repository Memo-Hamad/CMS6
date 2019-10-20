package main.jpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "Declaration", schema = "dbo", catalog = "CustomDB")
public class DeclarationEntity {
   // private int declarationId;
    private Timestamp submittedOn;
    private int totalWeight;
    private int dutyAmount;
    private byte[] attachment;
    private DeclarationTypeEntity declarationTypeByDecTypeCode;
    private CustomerEntity customerByCustomerID;
    private PortEntity portByPortID;
    private CountryEntity countryByCountryCode;
    private AgentEntity agentByAgentId;
    private EmployeeEntity employeeByEmpId;
    private DeclarationStatusEntity declarationStatusByDecStatusCode;
    private Collection<ItemEntity> itemsByDeclarationId;
    private Collection<OffenceEntity> offencesByDeclarationId;
    private Collection<PaymentEntity> paymentsByDeclarationId;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "DeclarationID", nullable = false)
    int declarationId;
    public int getDeclarationId() {
        return declarationId;
    }


    //public void setDeclarationId(int declarationId) {
      //  this.declarationId = declarationId;
    //}

    @Basic
    @Column(name = "SubmittedOn", nullable = false)
    public Timestamp getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(Timestamp submittedOn) {
        this.submittedOn = submittedOn;
    }

    @Basic
    @Column(name = "TotalWeight", nullable = false)
    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    @Basic
    @Column(name = "DutyAmount", nullable = false)
    public int getDutyAmount() {
        return dutyAmount;
    }

    public void setDutyAmount(int dutyAmount) {
        this.dutyAmount = dutyAmount;
    }

    @Basic
    @Column(name = "Attachment", nullable = true)
    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeclarationEntity that = (DeclarationEntity) o;

        if (declarationId != that.declarationId) return false;
        if (totalWeight != that.totalWeight) return false;
        if (dutyAmount != that.dutyAmount) return false;
        if (submittedOn != null ? !submittedOn.equals(that.submittedOn) : that.submittedOn != null) return false;
        if (!Arrays.equals(attachment, that.attachment)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = declarationId;
        result = 31 * result + (submittedOn != null ? submittedOn.hashCode() : 0);
        result = 31 * result + totalWeight;
        result = 31 * result + dutyAmount;
        result = 31 * result + Arrays.hashCode(attachment);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "DecTypeCode", referencedColumnName = "DecTypeCode", nullable = false)
    public DeclarationTypeEntity getDeclarationTypeByDecTypeCode() {
        return declarationTypeByDecTypeCode;
    }

    public void setDeclarationTypeByDecTypeCode(DeclarationTypeEntity declarationTypeByDecTypeCode) {
        this.declarationTypeByDecTypeCode = declarationTypeByDecTypeCode;
    }

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID", nullable = false)
    public CustomerEntity getCustomerByCustomerID() {
        return customerByCustomerID;
    }

    public void setCustomerByCustomerID(CustomerEntity customerByCustomerID) {
        this.customerByCustomerID = customerByCustomerID;
    }

    @ManyToOne
    @JoinColumn(name = "PortID", referencedColumnName = "PortID", nullable = false)
    public PortEntity getPortByPortID() {
        return portByPortID;
    }

    public void setPortByPortID(PortEntity portByPortID) {
        this.portByPortID = portByPortID;
    }

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "CountryCode", nullable = false)
    public CountryEntity getCountryByCountryCode() {
        return countryByCountryCode;
    }

    public void setCountryByCountryCode(CountryEntity countryByCountryCode) {
        this.countryByCountryCode = countryByCountryCode;
    }

    @ManyToOne
    @JoinColumn(name = "AgentID", referencedColumnName = "AgentID", nullable = false)
    public AgentEntity getAgentByAgentId() {
        return agentByAgentId;
    }

    public void setAgentByAgentId(AgentEntity agentByAgentId) {
        this.agentByAgentId = agentByAgentId;
    }

    @ManyToOne
    @JoinColumn(name = "EmpID", referencedColumnName = "EmpID", nullable = false)
    public EmployeeEntity getEmployeeByEmpId() {
        return employeeByEmpId;
    }

    public void setEmployeeByEmpId(EmployeeEntity employeeByEmpId) {
        this.employeeByEmpId = employeeByEmpId;
    }

    @ManyToOne
    @JoinColumn(name = "DecStatusCode", referencedColumnName = "DecStatusCode", nullable = false)
    public DeclarationStatusEntity getDeclarationStatusByDecStatusCode() {
        return declarationStatusByDecStatusCode;
    }

    public void setDeclarationStatusByDecStatusCode(DeclarationStatusEntity declarationStatusByDecStatusCode) {
        this.declarationStatusByDecStatusCode = declarationStatusByDecStatusCode;
    }

    @OneToMany(mappedBy = "declarationByDeclarationId")
    public Collection<ItemEntity> getItemsByDeclarationId() {
        return itemsByDeclarationId;
    }

    public void setItemsByDeclarationId(Collection<ItemEntity> itemsByDeclarationId) {
        this.itemsByDeclarationId = itemsByDeclarationId;
    }

    @OneToMany(mappedBy = "declarationByDeclarationId")
    public Collection<OffenceEntity> getOffencesByDeclarationId() {
        return offencesByDeclarationId;
    }

    public void setOffencesByDeclarationId(Collection<OffenceEntity> offencesByDeclarationId) {
        this.offencesByDeclarationId = offencesByDeclarationId;
    }

    @OneToMany(mappedBy = "declarationByDeclarationId")
    public Collection<PaymentEntity> getPaymentsByDeclarationId() {
        return paymentsByDeclarationId;
    }

    public void setPaymentsByDeclarationId(Collection<PaymentEntity> paymentsByDeclarationId) {
        this.paymentsByDeclarationId = paymentsByDeclarationId;
    }
}
