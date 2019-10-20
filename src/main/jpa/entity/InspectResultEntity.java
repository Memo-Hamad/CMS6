package main.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "InspectResult", schema = "dbo", catalog = "CustomDB")
public class InspectResultEntity {
    private String inspectResultCode;
    private String inspectResult;
    private Collection<ItemEntity> itemsByInspectResultCode;

    @Id
    @Column(name = "InspectResultCode", nullable = false, length = 2)
    public String getInspectResultCode() {
        return inspectResultCode;
    }

    public void setInspectResultCode(String inspectResultCode) {
        this.inspectResultCode = inspectResultCode;
    }

    @Basic
    @Column(name = "InspectResult", nullable = false, length = 255)
    public String getInspectResult() {
        return inspectResult;
    }

    public void setInspectResult(String inspectResult) {
        this.inspectResult = inspectResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InspectResultEntity that = (InspectResultEntity) o;

        if (inspectResultCode != null ? !inspectResultCode.equals(that.inspectResultCode) : that.inspectResultCode != null)
            return false;
        if (inspectResult != null ? !inspectResult.equals(that.inspectResult) : that.inspectResult != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = inspectResultCode != null ? inspectResultCode.hashCode() : 0;
        result = 31 * result + (inspectResult != null ? inspectResult.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "inspectResultByInspectResultCode")
    public Collection<ItemEntity> getItemsByInspectResultCode() {
        return itemsByInspectResultCode;
    }

    public void setItemsByInspectResultCode(Collection<ItemEntity> itemsByInspectResultCode) {
        this.itemsByInspectResultCode = itemsByInspectResultCode;
    }
}
