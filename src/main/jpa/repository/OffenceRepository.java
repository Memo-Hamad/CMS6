package main.jpa.repository;

//import io.helidon.config.Config;
//import io.helidon.microprofile.config.MpConfig;
//import io.helidon.microprofile.server.Server;
import main.jpa.entity.*;
//import org.jboss.weld.environment.se.Weld;
//import org.jboss.weld.environment.se.WeldContainer;
import javax.enterprise.context.ApplicationScoped;
import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;




@ApplicationScoped
public class OffenceRepository  implements IOffenceRepository{

    //@PersistenceContext
    private EntityManagerFactory emf = null;
    private EntityManager em;

    public OffenceRepository() {
        emf = Persistence.createEntityManagerFactory("DerbyCustomerDBPeristenceUnit");
        em = emf.createEntityManager();
    }

    //This is only needed when using JDBC
    //@Resource(mappedName = "java:app/jdbc/ContactDB")
    //private DataSource dataSource;
    //get one offence using Id
    public OffenceEntity getOffence(int offenceId) {
        return em.find(OffenceEntity.class, offenceId);
    }
    //    @Transactional
    public OffenceEntity addOffence(OffenceEntity offence) {

        em.getTransaction().begin();
        em.persist(offence);
        //em.flush();
        em.getTransaction().commit();
        return offence;
    }

    public void updateOffence(OffenceEntity offence) {
        em.getTransaction().begin();
        em.merge(offence);
        em.getTransaction().commit();
    }

    public void deleteOffence(int id) {
        em.getTransaction().begin();
        Query query = em.createQuery("delete from OffenceEntity c WHERE c.offenceId = :id");
        int deletedCount = query.setParameter("id", id).executeUpdate();
        em.getTransaction().commit();
    }
    //get all offences in list
    public List<OffenceEntity> getOffences() {
        return em.createQuery("select o from OffenceEntity o").getResultList();
    }

    //get offences of specific type
    public List getOffenceType(String offenceType) {
        Query query = em.createQuery("select o from OffenceEntity o where o.offenceTypeByOffenseTypeCode = :offenceType");
        query.setParameter("offenceType", offenceType);
        return query.getResultList();
    }

    //get offences count for offence type
    public int getOffencesTypeCount(String offenceType) {
        Query query = em.createQuery("select count(o) from OffenceEntity o where o.offenceTypeByOffenseTypeCode = :offenceType");
        query.setParameter("offenceType", offenceType);
        return ((Long) query.getSingleResult()).intValue();
    }

    public int getOffencesCount() {
        return ((Long) em.createQuery("select count(c) from OffenceEntity as c").getSingleResult()).intValue();
    }

    //when creating offence auto create a reward
    public RewardEntity addReward(RewardEntity reward) {
        em.getTransaction().begin();
        em.persist(reward);
        //em.flush();
        em.getTransaction().commit();
        return reward;
    }
    //get one reward by rewardId
    public RewardEntity getReward(int rewardsId) {
        return em.find(RewardEntity.class, rewardsId);
    }
    //get all rewards
    public List<RewardEntity> getRewards() {
        return em.createQuery("select o from RewardEntity o ").getResultList();
    }

//    public List<OrderSummary> GetOrdersSummary() {
//        Query query = em.createNamedQuery("Customer.GetOrdersSummary");
//        return query.getResultList();
//    }

//    public OrderSummary getOrdersSummary(int customerId) {
//        Query query = em.createNamedQuery("Customer.GetOrdersSummaryByCustomerId");
//        query.setParameter("customerId", customerId);
//        return (OrderSummary) query.getSingleResult();
//    }

    @PostConstruct
    public void insertTestData() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //Offence type
        OffenceTypeEntity type = new OffenceTypeEntity();
        type.setOffenceTypeCode("V");
        type.setOffenceType("Violation");
        //Create Items selected for offence
        ItemEntity item = new ItemEntity();
        item.setDescription("Fruites");
        item.setItemWeight(20);
        item.setPrice(200);
        item.setQuantity(4);
        //Create Declaration for this offence
        DeclarationEntity dec = new DeclarationEntity();
//        dec.setAgentByAgentId(); dec.setCountryByCountryCode(new CountryEntity());
        //Create offence
        OffenceEntity offence1 = new OffenceEntity();
        String off1desc = "offence got regestered1"; //Desc
        offence1.setDescription(off1desc);
        offence1.setOffenceDate(timestamp); //datetime
        offence1.setOffenceTypeByOffenseTypeCode(type);//offence type
        offence1.setItemByItemId(item);
        offence1 = this.addOffence(offence1);
//        offence1.setDeclarationByDeclarationId();

//        OffenceEntity offence2 = new OffenceEntity();
//        String off2desc = "offence got regestered2";
//        offence2.setDescription(off2desc);
//        offence2.setOffenceDate(timestamp);
//        offence2.setItemByItemId(item);
//        offence2 = this.addOffence(offence2);
//        offence2.setOffenceTypeByOffenseTypeCode(type);

        System.out.println(String.format("one offence were created. Their auto-generated Ids are %d & %d\n",
                offence1.getOffenceId()));

        System.out.println("Inserting 1 rewards for offence with Id 1");
        // Create 2 orders
//        RewardEntity reward = new RewardEntity();
//        reward.setAddress("123 University Rd, Doha, Qatar");
//        reward.setQty(10);
//        offence1.addOrder(reward);
//
//        Order order2 = new Order();
//        order2.setAddress("567 Al-Majd Rd, Dukhan, Qatar");
//        order2.setQty(20);
//        offence1.addOrder(order2);
//
//        System.out.println("Inserting 2 rewards for Customer with Id 2");
//        // Create 2 orders
//        Order order3 = new Order();
//        order3.setAddress("123 University Rd, Doha, Qatar");
//        order3.setQty(200);
//        offence2.addOrder(order3);
//
//        Order order4 = new Order();
//        order4.setAddress("567 Al-Majd Rd, Dukhan, Qatar");
//        order4.setQty(100);
//        offence2.addOrder(order4);
//
//        this.updateOffence(offence1);
//        this.updateOffence(offence2);
    }


}