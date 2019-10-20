package main.jpa.repository;

import java.text.DateFormat;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.enterprise.context.ApplicationScoped;

import javax.enterprise.context.Dependent;

import javax.enterprise.context.RequestScoped;

//import javax.ejb.Stateless;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import javax.persistence.PersistenceContext;

import javax.persistence.Query;

import javax.sql.DataSource;

import javax.transaction.Transactional;

import main.jpa.entity.*;


@ApplicationScoped

public class DeclarationRepository implements IDeclarationRepository {
    @Override
    public List<DeclarationEntity> getDeclarations() {
        return null;
    }

    @Override
    public DeclarationEntity getDeclaration(int decId) {
        return null;
    }

    @Override
    public DeclarationEntity addDeclaration(DeclarationEntity declaration) {
        return null;
    }

    @Override
    public void updateDeclaration(DeclarationEntity declaration) {

    }

    @Override
    public DeclarationEntity searchDeclarations(DeclarationTypeEntity decType, int decId, DeclarationStatusEntity decStatus, Timestamp decSubmittedOn, PortEntity decPortType, AgentEntity decAgentId) {
        return null;
    }

    @Override
    public void insertTestData() {

    }
//
//
//    private EntityManagerFactory emf = null;
//
//    private EntityManager em;
//
//
//    public DeclarationRepository() {
//
//        emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
//
//        em = emf.createEntityManager();
//
//    }
//
//    public List<DeclarationEntity> getDeclarations()
//    {
//        return em.createQuery("select o from DeclarationEntity o").getResultList();
//    }
//
//    @Override
//    public DeclarationEntity searchDeclarations(DeclarationTypeEntity decType, int decId, DeclarationStatusEntity decStatus, Timestamp decSubmittedOn, PortEntity decPortType, AgentEntity decAgentId) {
//        return null;
//    }
//
//
//    public List<DeclarationEntity> searchDeclarations(DeclarationTypeEntity decType,
//
//                                                      DeclarationTypeEntity decId,
//
//                                                      DeclarationStatusEntity decStatus,
//
//                                                      Timestamp decSubmittedOn,
//
//                                                      PortEntity decPortType,
//
//                                                      AgentEntity decAgentId) {
//
//        Query query = em.createQuery("SELECT D FROM Declaration as D "
//
//                + "WHERE D.declarationTypeByDecTypeCode = :decType OR :decType IS NULL)"
//
//                + "AND (D.declarationId = :decId OR :decId IS NULL)"
//
//                + "AND (D.declarationStatusByDecStatusCode = :decStatus OR :decStatus IS NULL)"
//
//                + "AND (D.submittedOn = :decSubmittedOn OR :decSubmittedOn IS NULL)"
//
//                + "AND (D.portByPortTypeCode = :decPortType OR :decPortType IS NULL)"
//
//                + "AND (D.agentByAgentId = :decAgentId OR :decAgentId IS NULL)"
//
//                + "ORDER BY D.declarationId)");
//
//        query.setParameter("decType", decType);
//
//        query.setParameter("decId", decId);
//
//        query.setParameter("decStatus", decStatus);
//
//        query.setParameter("decSubmittedOn", decSubmittedOn);
//
//        query.setParameter("decPortType", decPortType);
//
//        query.setParameter("decAgentId", decAgentId);
//
//        return query.getResultList();
//
//    }
//
//
//    public DeclarationEntity getDeclaration(int decId) {
//
//        return em.find(DeclarationEntity.class, decId);
//
//    }
//
//
//    //@Transactional
//
//    public DeclarationEntity addDeclaration(DeclarationEntity declaration) {
//
//
//        em.getTransaction().begin();
//
//        em.persist(declaration);
//
//        //em.flush();
//
//        em.getTransaction().commit();
//
//        return declaration;
//
//    }
//
//
//    public void updateDeclaration(DeclarationEntity declaration) {
//
//        em.getTransaction().begin();
//
//        em.merge(declaration);
//
//        em.getTransaction().commit();
//
//    }
//
//
//    //SA comment: I modified deleteDeclaration() in case needed. Check L7@1:15:27
//
////    public void deleteDeclaration(int id) {
//
////        em.getTransaction().begin();
//
////        Query query = em.createQuery("delete from DeclarationEntity d WHERE d.id = :id");
//
////        int deletedCount = query.setParameter("id", id).executeUpdate();
//
////        em.getTransaction().commit();
//
////    }
//
//
//
//    @PostConstruct
//
//    public void insertTestData() {
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 00:00:00");
//        Date date1 = dateFormat.parse("27/07/2017 07:07:07"); Date date2 = dateFormat.parse("29/09/2019 09:09:09");
//        long time1 = date1.getTime(); long time2 = date2.getTime();
//        Timestamp submittedOn1 = new Timestamp(time1); Timestamp submittedOn2 = new Timestamp(time2);
//        int totalWeight1 = 10; int totalWeight2 = 20;
//        int dutyAmount1 = 100; int dutyAmount2 = 200;
////        byte[] attachment1 = {1,2,3,4,5}; byte[] attachment2 = {6,7,8,9,10};
//        DeclarationTypeEntity declarationTypeByDecTypeCode1 = new DeclarationTypeEntity();
//
//        CustomerEntity customerByCustomerTypeCode1 = new CustomerEntity();
//
//        PortEntity portByPortTypeCode1 = new PortEntity();
//
//        CountryEntity countryByCountryCode1 = new CountryEntity();
//
//        AgentEntity agentByAgentId1 = new AgentEntity();
//
//        EmployeeEntity employeeByEmpId1 = new EmployeeEntity();
//
//        DeclarationStatusEntity declarationStatusByDecStatusCode1 = new DeclarationStatusEntity();
//
//        Collection<ItemEntity> itemsByDeclarationId1 = new Collection<ItemEntity>();
//
//        Collection<OffenceEntity> offencesByDeclarationId1 = new Collection<OffenceEntity>();
//
//        Collection<PaymentEntity> paymentsByDeclarationId1 = new Collection<PaymentEntity>();
//
//
//
//        DeclarationTypeEntity declarationTypeByDecTypeCode2 = new DeclarationTypeEntity();
//
//        CustomerEntity customerByCustomerTypeCode2 = new CustomerEntity();
//
//        PortEntity portByPortTypeCode2 = new PortEntity();
//
//        CountryEntity countryByCountryCode2 = new CountryEntity();
//
//        AgentEntity agentByAgentId2 = new AgentEntity();
//
//        EmployeeEntity employeeByEmpId2 = new EmployeeEntity();
//
//        DeclarationStatusEntity declarationStatusByDecStatusCode2 = new DeclarationStatusEntity();
//
//        Collection<ItemEntity> itemsByDeclarationId2 = new Collection<ItemEntity>();
//
//        Collection<OffenceEntity> offencesByDeclarationId2 = new Collection<OffenceEntity>();
//
//        Collection<PaymentEntity> paymentsByDeclarationId2 = new Collection<PaymentEntity>();
//
//
//
////        DeclarationEntity dec1 = new DeclarationEntity(Timestamp submittedOn1, int totalWeight1, int dutyAmount1, byte[] attachment1,
////
////        DeclarationTypeEntity declarationTypeByDecTypeCode1,
////
////        CustomerEntity customerByCustomerTypeCode1,
////
////        PortEntity portByPortTypeCode1,
////
////        CountryEntity countryByCountryCode1,
////
////        AgentEntity agentByAgentId1,
////
////        EmployeeEntity employeeByEmpId1,
////
////        DeclarationStatusEntity declarationStatusByDecStatusCode1,
////
////        Collection<ItemEntity> itemsByDeclarationId1,
////
////        Collection<OffenceEntity> offencesByDeclarationId1,
////
////        Collection<PaymentEntity> paymentsByDeclarationId1);
//
//        DeclarationEntity dec2 = new DeclarationEntity() ;
////        submittedOn2,  totalWeight2,  dutyAmount2,  attachment2,
////
////         declarationTypeByDecTypeCode2,
////
////         customerByCustomerTypeCode2,
////
////         portByPortTypeCode2,
////
////         countryByCountryCode2,
////
////         agentByAgentId2,
////
////         employeeByEmpId2,
////
////         declarationStatusByDecStatusCode2,
////
////         itemsByDeclarationId2,
////
////        offencesByDeclarationId2,
////
////         paymentsByDeclarationId2);
//        //add data to dec object
//        dec2.setSubmittedOn(submittedOn2); dec2.setTotalWeight(totalWeight2); dec2.setDutyAmount(dutyAmount2); dec2.setDeclarationTypeByDecTypeCode(declarationTypeByDecTypeCode2);
//        dec2.setCustomerByCustomerID(customerByCustomerTypeCode2); dec2.setPortByPortID(****); dec2.setCountryByCountryCode(countryByCountryCode2); dec2.setAgentByAgentId(agentByAgentId2);
//        dec2.setEmployeeByEmpId(employeeByEmpId2); dec2.setDeclarationStatusByDecStatusCode(declarationStatusByDecStatusCode2); dec2.setItemsByDeclarationId(itemsByDeclarationId2);
////        dec1 = this.addDeclaration(dec1);
//
//        dec2 = this.addDeclaration(dec2);
//
//
//
//        System.out.println(String.format("Two declarations were created. Their auto-generated Ids are %d & %d\n",
//
//                dec1.getDeclarationId(), dec2.getDeclarationId()));
//
//
//
////        this.updateDeclaration(dec1);
//
//        this.updateDeclaration(dec2);
//
//    }

}