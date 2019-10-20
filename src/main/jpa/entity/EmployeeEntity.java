package main.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Employee", schema = "dbo", catalog = "CustomDB")
public class EmployeeEntity {
  //  private int empId;
    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private int salary;
    private String loginId;
    private String loginPass;
    private Collection<DeclarationEntity> declarationsByEmpId;
    private EmpPositionEntity empPositionByPositionCode;
    private Collection<RewardEntity> rewardsByEmpId;

    @Id
    @Column(name = "EmpID", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int empId;
    public int getEmpId() {
        return empId;
    }

   // public void setEmpId(int empId) {
     //   this.empId = empId;
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
    @Column(name = "City", nullable = false, length = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "Street", nullable = true, length = 255)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "Salary", nullable = false)
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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

        EmployeeEntity that = (EmployeeEntity) o;

        if (empId != that.empId) return false;
        if (salary != that.salary) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (loginId != null ? !loginId.equals(that.loginId) : that.loginId != null) return false;
        if (loginPass != null ? !loginPass.equals(that.loginPass) : that.loginPass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + (loginId != null ? loginId.hashCode() : 0);
        result = 31 * result + (loginPass != null ? loginPass.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "employeeByEmpId")
    public Collection<DeclarationEntity> getDeclarationsByEmpId() {
        return declarationsByEmpId;
    }

    public void setDeclarationsByEmpId(Collection<DeclarationEntity> declarationsByEmpId) {
        this.declarationsByEmpId = declarationsByEmpId;
    }

    @ManyToOne
    @JoinColumn(name = "PositionCode", referencedColumnName = "PositionCode", nullable = false)
    public EmpPositionEntity getEmpPositionByPositionCode() {
        return empPositionByPositionCode;
    }

    public void setEmpPositionByPositionCode(EmpPositionEntity empPositionByPositionCode) {
        this.empPositionByPositionCode = empPositionByPositionCode;
    }

    @OneToMany(mappedBy = "employeeByEmpId")
    public Collection<RewardEntity> getRewardsByEmpId() {
        return rewardsByEmpId;
    }

    public void setRewardsByEmpId(Collection<RewardEntity> rewardsByEmpId) {
        this.rewardsByEmpId = rewardsByEmpId;
    }
}
