package main.jpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "Offence", schema = "dbo", catalog = "CustomDB")
public class OffenceEntity {
  //  private int offenceId;
    private Timestamp offenceDate;
    private String description;
    private OffenceTypeEntity offenceTypeByOffenseTypeCode;
    private ItemEntity itemByItemId;
    private DeclarationEntity declarationByDeclarationId;
    private Collection<RewardEntity> rewardsByOffenceId;

    @Id
    @Column(name = "OffenceID", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int offenceId;
    public int getOffenceId() {
        return offenceId;
    }

    //public void setOffenceId(int offenceId) {
      //  this.offenceId = offenceId;
    //}

    @Basic
    @Column(name = "OffenceDate", nullable = false)
    public Timestamp getOffenceDate() {
        return offenceDate;
    }

    public void setOffenceDate(Timestamp offenceDate) {
        this.offenceDate = offenceDate;
    }

    @Basic
    @Column(name = "Description", nullable = false, length = 2000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OffenceEntity that = (OffenceEntity) o;

        if (offenceId != that.offenceId) return false;
        if (offenceDate != null ? !offenceDate.equals(that.offenceDate) : that.offenceDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = offenceId;
        result = 31 * result + (offenceDate != null ? offenceDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "OffenseTypeCode", referencedColumnName = "OffenceTypeCode", nullable = false)
    public OffenceTypeEntity getOffenceTypeByOffenseTypeCode() {
        return offenceTypeByOffenseTypeCode;
    }

    public void setOffenceTypeByOffenseTypeCode(OffenceTypeEntity offenceTypeByOffenseTypeCode) {
        this.offenceTypeByOffenseTypeCode = offenceTypeByOffenseTypeCode;
    }

    @ManyToOne
    @JoinColumn(name = "ItemID", referencedColumnName = "ItemID")
    public ItemEntity getItemByItemId() {
        return itemByItemId;
    }

    public void setItemByItemId(ItemEntity itemByItemId) {
        this.itemByItemId = itemByItemId;
    }

    @ManyToOne
    @JoinColumn(name = "DeclarationID", referencedColumnName = "DeclarationID")
    public DeclarationEntity getDeclarationByDeclarationId() {
        return declarationByDeclarationId;
    }

    public void setDeclarationByDeclarationId(DeclarationEntity declarationByDeclarationId) {
        this.declarationByDeclarationId = declarationByDeclarationId;
    }

    @OneToMany(mappedBy = "offenceByOffenseId")
    public Collection<RewardEntity> getRewardsByOffenceId() {
        return rewardsByOffenceId;
    }

    public void setRewardsByOffenceId(Collection<RewardEntity> rewardsByOffenceId) {
        this.rewardsByOffenceId = rewardsByOffenceId;
    }
}
