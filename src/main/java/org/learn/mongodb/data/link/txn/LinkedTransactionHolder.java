package org.learn.mongodb.data.link.txn;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

public class LinkedTransactionHolder {

    @DBRef
    private List<LinkedTransaction> transactions;
    private Integer count;

    public LinkedTransactionHolder(List<LinkedTransaction> transactions) {
        this.transactions = transactions;
        this.count = transactions.size();
    }

    public List<LinkedTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<LinkedTransaction> transactions) {
        this.transactions = transactions;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
