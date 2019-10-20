package main.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "EmpPosition", schema = "dbo", catalog = "CustomDB")
public class EmpPositionEntity {
    private String positionCode;
    private String position;
    private Collection<EmployeeEntity> employeesByPositionCode;

    @Id
    @Column(name = "PositionCode", nullable = false, length = 1)
    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    @Basic
    @Column(name = "Position", nullable = false, length = 255)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpPositionEntity that = (EmpPositionEntity) o;

        if (positionCode != null ? !positionCode.equals(that.positionCode) : that.positionCode != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = positionCode != null ? positionCode.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "empPositionByPositionCode")
    public Collection<EmployeeEntity> getEmployeesByPositionCode() {
        return employeesByPositionCode;
    }

    public void setEmployeesByPositionCode(Collection<EmployeeEntity> employeesByPositionCode) {
        this.employeesByPositionCode = employeesByPositionCode;
    }
}
