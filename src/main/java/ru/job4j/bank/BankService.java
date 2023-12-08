package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализация модели банковской системы.
 * В системе производятся следующие действия:
 * 1. Регистрация пользователя.
 * 2. Удалениие пользователя из системы.
 * 3. Добавление пользователю банковского счета (У пользователя может быть несколько счетов).
 * 4. Перевод денег с одного банковского счета на другой.
 */
public class BankService {
    /**
     * Данное поле содержит всех пользователей с привязанными к ним счетам.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему.
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет удалить пользователя из системы.
     * @param passport паспорт пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет новый счет к пользователю.
     * Метод findByPassport нужен, для нахождения пользователя по паспорту.
     * @param passport паспорт пользователя
     * @param account счет полььзователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);

        if (user != null) {
            List<Account> one = users.get(user);
            if (!one.contains(account)) {
                one.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту,
     * если ничего не найдено - метод возвращает null.
     * @param passport паспорт пользователя
     * @return возвращает пользователя или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквезитам.
     * Метод findByPassport нужен, для нахождения пользователя по паспорту.
     * @param passport паспортные пользователя
     * @param requisite реквезиты пользователя
     * @return возвращает счет или null, если счет не найден
     */
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

    /**
     * Метод предназначен для перечисления денег с одного счета на другой счет.
     * @param srcPassport паспорт отправителя
     * @param srcRequisite реквезиты отправителя
     * @param destPassport паспорт получателя
     * @param destRequisite реквезиты получателя
     * @param amount уведомление о статусе операции
     * @return возвращает true, если перевод прошел, или false,
     * если один из пользователей не найден и счет отправителя меньше суммы отправления
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account user = findByRequisite(srcPassport, srcRequisite);
        Account userOne = findByRequisite(destPassport, destRequisite);
        if (user != null && userOne != null) {
            if (user.getBalance() >= amount) {
                user.setBalance(user.getBalance() - amount);
                userOne.setBalance(userOne.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}