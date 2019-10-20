package main.jpa.repository;


//import javax.annotation.PostConstruct;

//import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.context.Dependent;
//import javax.enterprise.context.RequestScoped;
//import javax.ejb.Stateless;
import javax.annotation.PostConstruct;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import javax.transaction.Transactional;

import main.jpa.entity.PaymentEntity;
import main.jpa.entity.DeclarationEntity;

import java.util.Collection;

@ApplicationScoped
public class PaymentRepository implements IPaymentRepository{

    private EntityManagerFactory emf = null;
    private EntityManager em;

    public PaymentRepository() {
        emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        em = emf.createEntityManager();
    }

//    @Override
//    public PaymentEntity addPayment(PaymentEntity Payment) {
//        return null;
//    }

    public PaymentEntity getPayment(int customerId) {
        return em.find(PaymentEntity.class, customerId);
    }

    //public AgentEntity getAgent(int AgentId) {
      //  return em.find(AgentEntity.class, AgentId);
    //}

    public PaymentEntity addPayment(PaymentEntity Payment) {

        em.getTransaction().begin();
        em.persist(Payment);
        //em.flush();
        em.getTransaction().commit();
        return Payment;
    }


    public PaymentEntity getPayment2(int DecID) {
        Query query = em.createQuery("select P from PaymentEntity P where P.declarationByDeclarationId = :DecID");
        query.setParameter("DecID", DecID);
        return (PaymentEntity) query.getSingleResult();
    }

    public DeclarationEntity getDeclaration(int DecId) {
        return em.find(DeclarationEntity.class, DecId);
    }

    public DeclarationEntity addDeclaration(DeclarationEntity Declaration) {

        em.getTransaction().begin();
        em.persist(Declaration);
        //em.flush();
        em.getTransaction().commit();
        return Declaration;
    }

    public DeclarationEntity getDeclaration2(int CustID) {
        Query query = em.createQuery("select D from DeclarationEntity D where D.customerByCustomerID = :CustomerID");
        query.setParameter("CustomerID", CustID);
        return (DeclarationEntity) query.getSingleResult();
    }
//
//    @PostConstruct
//    public void insertTestData() {
//
//        DeclarationEntity Dec1 = new DeclarationEntity();
//
//        // Create 2 orders
//        PaymentEntity Pay1 = new PaymentEntity();
//        Pay1.setAccountNo(1110021);
//        Pay1.setAmount(1000);
//        Pay1.setBankId("QNB123");
//        Dec1.setPaymentsByDeclarationId((Collection<PaymentEntity>) Pay1);
//        Pay1.setExpiryDate("20-5-2020");
//        Pay1.setHolderName("Salwa Omar");
//
//    }

}
