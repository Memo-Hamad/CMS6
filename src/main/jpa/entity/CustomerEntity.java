package main.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Customer", schema = "dbo", catalog = "CustomDB")
public class CustomerEntity {
   // private int customerId;
    private String firstName;
    private String lastName;
    private int mobile;
    private CustomerTypeEntity customerTypeByCustomerTypeCode;
    private Collection<DeclarationEntity> declarationsByCustomerId;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID", nullable = false)
    int customerId;

    public int getCustomerId() {
        return customerId;
    }

   // public void setCustomerId(int customerId) {
     //   this.customerId = customerId;
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
    @Column(name = "Mobile", nullable = false)
    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEntity that = (CustomerEntity) o;

        if (customerId != that.customerId) return false;
        if (mobile != that.mobile) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + mobile;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CustomerTypeCode", referencedColumnName = "CustomerTypeCode", nullable = false)
    public CustomerTypeEntity getCustomerTypeByCustomerTypeCode() {
        return customerTypeByCustomerTypeCode;
    }

    public void setCustomerTypeByCustomerTypeCode(CustomerTypeEntity customerTypeByCustomerTypeCode) {
        this.customerTypeByCustomerTypeCode = customerTypeByCustomerTypeCode;
    }

    @OneToMany(mappedBy = "customerByCustomerID")
    public Collection<DeclarationEntity> getDeclarationsByCustomerId() {
        return declarationsByCustomerId;
    }

    public void setDeclarationsByCustomerId(Collection<DeclarationEntity> declarationsByCustomerId) {
        this.declarationsByCustomerId = declarationsByCustomerId;
    }




}
