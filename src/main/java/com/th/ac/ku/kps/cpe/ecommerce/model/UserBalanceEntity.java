package com.th.ac.ku.kps.cpe.ecommerce.model;

import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.TransactionType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_balance", schema = "e-commerce_01")
public class UserBalanceEntity {
    private int idUserBalance;
    private int idUser;
    private double transactionAmount;
    private TransactionType transactionType;
    private Integer idOrderHistory;
    private double balance;

    @Id
    @Column(name = "id_user_balance")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdUserBalance() {
        return idUserBalance;
    }

    public void setIdUserBalance(int idUserBalance) {
        this.idUserBalance = idUserBalance;
    }

    @Basic
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "transaction_amount")
    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Basic
    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Basic
    @Column(name = "id_order_history")
    public Integer getIdOrderHistory() {
        return idOrderHistory;
    }

    public void setIdOrderHistory(Integer idOrderHistory) {
        this.idOrderHistory = idOrderHistory;
    }

    @Basic
    @Column(name = "balance")
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBalanceEntity that = (UserBalanceEntity) o;
        return idUserBalance == that.idUserBalance &&
                idUser == that.idUser &&
                Double.compare(that.transactionAmount, transactionAmount) == 0 &&
                Double.compare(that.balance, balance) == 0 &&
                Objects.equals(transactionType, that.transactionType) &&
                Objects.equals(idOrderHistory, that.idOrderHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUserBalance, idUser, transactionAmount, transactionType, idOrderHistory, balance);
    }
}
