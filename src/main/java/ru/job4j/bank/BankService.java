package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);

        if (user != null) {
            List<Account> one = users.get(user);
            if (!one.contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        User user = findByPassport(srcPassport);
        User userOne = findByPassport(destPassport);
        List<Account> one = users.get(user);
        List<Account> oneUser = users.get(userOne);
        for (Account account : one) {
            for (Account accountOne : oneUser) {
                if (account.getRequisite().equals(srcRequisite) && accountOne.getRequisite().equals(destRequisite)) {
                    if (account.getBalance() >= amount) {
                        account.setBalance(account.getBalance() - amount);
                        accountOne.setBalance(accountOne.getBalance() + amount);
                        rsl = true;
                    }
                }
            }

        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}