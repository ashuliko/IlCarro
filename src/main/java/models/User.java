package models;

public class User {
    String email;
    String password;
    String name;
    String lastName;

//     ===== princip metoda fluent====
//    1.create getters and setters
//    2. add return this(vozvraschaem ekzemlyar classa) i na4inaetsya oshibka
//    3. changes void -> name Class ( u nas User)
//    4. changes set -> with

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public User withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}