package org.learn.mongodb.data.link.txn;

import org.bson.types.ObjectId;
import org.learn.mongodb.data.link.document.LinkedBankAccount;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "linked-transactions")
public class LinkedTransaction {

    @Id
    private ObjectId id;

    private String transactionId;

    private BigDecimal amount;

    private Date transactionTime;

    private TransactionMode transactionMode;

    @DBRef
    private LinkedBankAccount bankAccount;


    public LinkedTransaction(String transactionId, BigDecimal amount, Date transactionTime, TransactionMode transactionMode) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionTime = transactionTime;
        this.transactionMode = transactionMode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public TransactionMode getTransactionMode() {
        return transactionMode;
    }

    public void setTransactionMode(TransactionMode transactionMode) {
        this.transactionMode = transactionMode;
    }

    public LinkedBankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(LinkedBankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public enum TransactionMode {
        CHK, ONLINE, ATM;
    }

}
