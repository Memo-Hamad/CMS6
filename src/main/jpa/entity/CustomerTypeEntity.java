package main.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CustomerType", schema = "dbo", catalog = "CustomDB")
public class CustomerTypeEntity {
    private String customerTypeCode;
    private String customerType;
    private Collection<CustomerEntity> customersByCustomerTypeCode;

    @Id
    @Column(name = "CustomerTypeCode", nullable = false, length = 1)
    public String getCustomerTypeCode() {
        return customerTypeCode;
    }

    public void setCustomerTypeCode(String customerTypeCode) {
        this.customerTypeCode = customerTypeCode;
    }

    @Basic
    @Column(name = "CustomerType", nullable = false, length = 255)
    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerTypeEntity that = (CustomerTypeEntity) o;

        if (customerTypeCode != null ? !customerTypeCode.equals(that.customerTypeCode) : that.customerTypeCode != null)
            return false;
        if (customerType != null ? !customerType.equals(that.customerType) : that.customerType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerTypeCode != null ? customerTypeCode.hashCode() : 0;
        result = 31 * result + (customerType != null ? customerType.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "customerTypeByCustomerTypeCode")
    public Collection<CustomerEntity> getCustomersByCustomerTypeCode() {
        return customersByCustomerTypeCode;
    }

    public void setCustomersByCustomerTypeCode(Collection<CustomerEntity> customersByCustomerTypeCode) {
        this.customersByCustomerTypeCode = customersByCustomerTypeCode;
    }
}
