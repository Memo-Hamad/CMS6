package main.jpa.repository;

import main.jpa.entity.PaymentEntity;

public interface IPaymentRepository {


    PaymentEntity addPayment(PaymentEntity Payment);

    PaymentEntity getPayment(int CustID);

    PaymentEntity getPayment2(int DecID);


  //  PaymentEntity getPayment();
}
