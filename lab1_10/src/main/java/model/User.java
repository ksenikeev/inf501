package model;

public class User {
    private String userName;
    private String password;
    private String role;

    // Определяем конструктор

    // стандартный геттер  get имя атрибута с заглавной буквы
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public User[] getAll() {
        // Заполнить и вернуть всех пользователей (3-4)
        return null;
    }
}
