package com.App.model;



public class Account {

    private String accountId;
    private String customerId;
    private Integer createdYear;
    private Currency currency;
    private Double balance;

    public Account() {
    }

    public Account(String accountId, String customerId, Integer createdYear, Currency currency, Double balance) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.createdYear = createdYear;
        this.currency = currency;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(Integer createdYear) {
        this.createdYear = createdYear;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", createdYear=" + createdYear +
                ", currency=" + currency +
                ", balance=" + balance +
                '}';
    }
}
