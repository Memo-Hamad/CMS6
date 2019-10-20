package main.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ItemType", schema = "dbo", catalog = "CustomDB")
public class ItemTypeEntity {
    private String itemTypeCode;
    private String itemType;
    private Collection<ItemEntity> itemsByItemTypeCode;

    @Id
    @Column(name = "ItemTypeCode", nullable = false, length = 20)
    public String getItemTypeCode() {
        return itemTypeCode;
    }

    public void setItemTypeCode(String itemTypeCode) {
        this.itemTypeCode = itemTypeCode;
    }

    @Basic
    @Column(name = "ItemType", nullable = false, length = 255)
    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemTypeEntity that = (ItemTypeEntity) o;

        if (itemTypeCode != null ? !itemTypeCode.equals(that.itemTypeCode) : that.itemTypeCode != null) return false;
        if (itemType != null ? !itemType.equals(that.itemType) : that.itemType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemTypeCode != null ? itemTypeCode.hashCode() : 0;
        result = 31 * result + (itemType != null ? itemType.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "itemTypeByItemTypeCode")
    public Collection<ItemEntity> getItemsByItemTypeCode() {
        return itemsByItemTypeCode;
    }

    public void setItemsByItemTypeCode(Collection<ItemEntity> itemsByItemTypeCode) {
        this.itemsByItemTypeCode = itemsByItemTypeCode;
    }
}
