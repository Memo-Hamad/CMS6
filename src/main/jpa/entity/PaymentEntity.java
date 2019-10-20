package main.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "Payment", schema = "dbo", catalog = "CustomDB")
public class PaymentEntity {
//    private int paymentId;
    private int amount;
    private String bankId;
    private int accountNo;
    private String holderName;
    private String expiryDate;
    private DeclarationEntity declarationByDeclarationId;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int paymentId;
    @Column(name = "PaymentID", nullable = false)

    public int getPaymentId() {
        return paymentId;
    }



//    public void setPaymentId(int paymentId) {
//        this.paymentId = paymentId;
//    }


    @Basic
    @Column(name = "Amount", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "BankID", nullable = false, length = 255)
    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    @Basic
    @Column(name = "AccountNo", nullable = false)
    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    @Basic
    @Column(name = "HolderName", nullable = false, length = 255)
    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    @Basic
    @Column(name = "ExpiryDate", nullable = false)
    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentEntity that = (PaymentEntity) o;

        if (paymentId != that.paymentId) return false;
        if (amount != that.amount) return false;
        if (accountNo != that.accountNo) return false;
        if (bankId != null ? !bankId.equals(that.bankId) : that.bankId != null) return false;
        if (holderName != null ? !holderName.equals(that.holderName) : that.holderName != null) return false;
        if (expiryDate != null ? !expiryDate.equals(that.expiryDate) : that.expiryDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paymentId;
        result = 31 * result + amount;
        result = 31 * result + (bankId != null ? bankId.hashCode() : 0);
        result = 31 * result + accountNo;
        result = 31 * result + (holderName != null ? holderName.hashCode() : 0);
        result = 31 * result + (expiryDate != null ? expiryDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "DeclarationID", referencedColumnName = "DeclarationID", nullable = false)
    public Object getDeclarationByDeclarationId() {
        return declarationByDeclarationId;
    }

    public void setDeclarationByDeclarationId(DeclarationEntity declarationByDeclarationId) {
        this.declarationByDeclarationId = declarationByDeclarationId;
    }
}
