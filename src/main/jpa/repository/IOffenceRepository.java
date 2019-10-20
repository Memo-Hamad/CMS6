package main.jpa.repository;

import main.jpa.entity.OffenceEntity;
import main.jpa.entity.RewardEntity;

import java.util.List;

public interface IOffenceRepository {

    public abstract List<OffenceEntity> getOffences();
    public abstract OffenceEntity       getOffence(int offenceId);
    public abstract void deleteOffence(int offenceId);
    public abstract OffenceEntity       addOffence(OffenceEntity offence);
    public abstract void updateOffence(OffenceEntity offence);
    public abstract List                getOffenceType(String offenceType);
    public abstract int                 getOffencesTypeCount(String offenceType);
    public abstract int                 getOffencesCount();
    public abstract List<RewardEntity>  getRewards();
    public abstract RewardEntity        getReward(int rewardId);
    public abstract RewardEntity        addReward(RewardEntity reward);


//    public abstract Customer addCustomer(Customer customer);

//    public abstract void updateCustomer(Customer customer);
//
//    public abstract void deleteCustomer(int id);
//
//    public abstract List<Customer> getCustomers();
//
//    public abstract Customer getCustomer(String customerName);
//
//    public abstract int getCustomersCount();
//
//    public abstract List<OrderSummary> GetOrdersSummary();
//
//    public abstract OrderSummary getOrdersSummary(int customerId);

    public void insertTestData();
}
