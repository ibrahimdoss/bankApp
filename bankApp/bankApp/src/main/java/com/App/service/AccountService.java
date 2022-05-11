package com.App.service;

import com.App.model.Account;
import com.App.model.Customer;

import java.util.List;

public class AccountService {

    private final CustomerService customerService;
    private List<Customer> customerList;

    public AccountService(CustomerService customerService, List<Customer> customerList) {
        this.customerService = customerService;
        this.customerList = customerList;
    }

    public Account createAccount (Account account, List<Account> accountList){
        if (checkCustomerId(account.getCustomerId())){
            accountList.add(account);
        }
        return account;
    }
// createAccount kısmında Customerservice kısmındaki customerListi  ekleme sebebimiz sadece customerListe baksın
    //varsa create işlemi yapsın diye ama aksi durumda parametre olarak verseydik customerList için de işlem yapacaktık
    //        bu da SRP olarak ve methodun amacından sapmış olacaktı. O yüzden bu şekilde CustomerService içindeki customerList
   // kullanıldı.

    public void deleteAccount (String accountId, List<Account> accountList){
        for (int i = 0; i < accountList.size(); i++) {
            if (accountId.equals(accountList.get(i).getAccountId())) {
                accountList.remove(i);
                break;

            }
        }
    }

    public Account getAccount (String accountId, List<Account> accountList){
        Account account = null;
        for (int i = 0 ; i < accountList.size(); i++ ){
            if (accountId.equals(accountList.get(i).getAccountId())){
                account = accountList.get(i);
                break;
            }
        }

        return account;
    }

    public Account withdrawMoney(String accountId, Double amount, List<Account> accountList) {
        Account account = getAccount(accountId, accountList);
        if (account == null) {
            System.err.println("Couldn't find any customer with this id : " + accountId);
            return null;
        } else {
            Double balance = account.getBalance();
            if (balance > amount) {
                account.setBalance(balance - amount);
                updateAccount(account, accountId, accountList);
            } else {
                System.err.println("Insufficient found for this accountId " + accountId + " current balance is : " + balance);

            }
        }
        return  account;
    }

    public Account addMoney(String accountId, Double amount, List<Account> accountList){
        Account account = getAccount(accountId, accountList);
        if (account == null) {
            System.err.println("Couldn't find any customer with this id : " + accountId);
            return null;
        } else {
            Double balance = account.getBalance();
            if (balance > amount) {
                account.setBalance(balance + amount);
                updateAccount(account, accountId, accountList);
            }
        }
        return  account;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    private boolean checkCustomerId(String customerId){
        Customer customer = customerService.getCustomer(customerId, customerList);
        if (customer == null){
            return false;
        }else {
            System.out.println("Couldn't find any customer with this id : " + customerId);
            return true;
        }
    }

    private List<Account> updateAccount(Account account, String accountId, List<Account> accountList){
        Account oldAccount = new Account();
        for (int i = 0; i < accountList.size(); i++){
            if (accountId.equals(accountList.get(i).getAccountId())){
                oldAccount = accountList.get(i);
                accountList.remove(i);
                break;
            }
        }

        oldAccount.setBalance(account.getBalance());
        accountList.add(oldAccount);
        return accountList;

    }
}
