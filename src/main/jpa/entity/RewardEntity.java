package main.jpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Reward", schema = "dbo", catalog = "CustomDB")
public class RewardEntity {
   // private int rewardId;
    private int amount;
    private Timestamp rewardDate;
    private OffenceEntity offenceByOffenseId;
    private EmployeeEntity employeeByEmpId;

    @Id
    @Column(name = "RewardID", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int rewardId;
    public int getRewardId() {
        return rewardId;
    }

   // public void setRewardId(int rewardId) {
     //   this.rewardId = rewardId;
    //}

    @Basic
    @Column(name = "Amount", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "RewardDate", nullable = false)
    public Timestamp getRewardDate() {
        return rewardDate;
    }

    public void setRewardDate(Timestamp rewardDate) {
        this.rewardDate = rewardDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RewardEntity that = (RewardEntity) o;

        if (rewardId != that.rewardId) return false;
        if (amount != that.amount) return false;
        if (rewardDate != null ? !rewardDate.equals(that.rewardDate) : that.rewardDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rewardId;
        result = 31 * result + amount;
        result = 31 * result + (rewardDate != null ? rewardDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "OffenseID", referencedColumnName = "OffenceID", nullable = false)
    public OffenceEntity getOffenceByOffenseId() {
        return offenceByOffenseId;
    }

    public void setOffenceByOffenseId(OffenceEntity offenceByOffenseId) {
        this.offenceByOffenseId = offenceByOffenseId;
    }

    @ManyToOne
    @JoinColumn(name = "EmpID", referencedColumnName = "EmpID", nullable = false)
    public EmployeeEntity getEmployeeByEmpId() {
        return employeeByEmpId;
    }

    public void setEmployeeByEmpId(EmployeeEntity employeeByEmpId) {
        this.employeeByEmpId = employeeByEmpId;
    }
}
