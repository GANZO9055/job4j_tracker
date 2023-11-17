package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int rsl = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                rsl = i;
            }
            if (rsl == -1) {
                throw new UserNotFoundException();
            }
        }
        return users[rsl];
    }

    public static boolean validate(User user) throws UserInvalidException {
        int rsl = -1;
        if (user.isValid() && user.getUsername().length() > 3) {
            rsl = 1;
        }
        if (rsl == -1) {
            throw new UserInvalidException();
        }
        return rsl == 1;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println("Пользователь не валидный");
        } catch (UserNotFoundException ex) {
            System.out.println("Пользователь не найден");
        }
    }
}
