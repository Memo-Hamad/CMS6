package main.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Item", schema = "dbo", catalog = "CustomDB")
public class ItemEntity {
   // private int itemId;
    private int quantity;
    private int price;
    private int itemWeight;
    private String description;
    private ItemTypeEntity itemTypeByItemTypeCode;
    private DeclarationEntity declarationByDeclarationId;
    private InspectResultEntity inspectResultByInspectResultCode;
    private Collection<OffenceEntity> offencesByItemId;

    @Id
    @Column(name = "ItemID", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int itemId;
    public int getItemId() {
        return itemId;
    }

   // public void setItemId(int itemId) {
     //   this.itemId = itemId;
    //}

    @Basic
    @Column(name = "Quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "Price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "ItemWeight", nullable = false)
    public int getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(int itemWeight) {
        this.itemWeight = itemWeight;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 255)
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

        ItemEntity that = (ItemEntity) o;

        if (itemId != that.itemId) return false;
        if (quantity != that.quantity) return false;
        if (price != that.price) return false;
        if (itemWeight != that.itemWeight) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId;
        result = 31 * result + quantity;
        result = 31 * result + price;
        result = 31 * result + itemWeight;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ItemTypeCode", referencedColumnName = "ItemTypeCode", nullable = false)
    public ItemTypeEntity getItemTypeByItemTypeCode() {
        return itemTypeByItemTypeCode;
    }

    public void setItemTypeByItemTypeCode(ItemTypeEntity itemTypeByItemTypeCode) {
        this.itemTypeByItemTypeCode = itemTypeByItemTypeCode;
    }

    @ManyToOne
    @JoinColumn(name = "DeclarationID", referencedColumnName = "DeclarationID", nullable = false)
    public DeclarationEntity getDeclarationByDeclarationId() {
        return declarationByDeclarationId;
    }

    public void setDeclarationByDeclarationId(DeclarationEntity declarationByDeclarationId) {
        this.declarationByDeclarationId = declarationByDeclarationId;
    }

    @ManyToOne
    @JoinColumn(name = "InspectResultCode", referencedColumnName = "InspectResultCode", nullable = false)
    public InspectResultEntity getInspectResultByInspectResultCode() {
        return inspectResultByInspectResultCode;
    }

    public void setInspectResultByInspectResultCode(InspectResultEntity inspectResultByInspectResultCode) {
        this.inspectResultByInspectResultCode = inspectResultByInspectResultCode;
    }

    @OneToMany(mappedBy = "itemByItemId")
    public Collection<OffenceEntity> getOffencesByItemId() {
        return offencesByItemId;
    }

    public void setOffencesByItemId(Collection<OffenceEntity> offencesByItemId) {
        this.offencesByItemId = offencesByItemId;
    }
}
