package DataModels;

import Utils.AccountRoles;

public class AccountModel {
    
    private static int NEXT_ID = 0;

    private final int accountId;
    private String username;
    private String password;
    private final  String name;
    private final String surname;    
    private AccountRoles role;
    private final boolean isActive;
    
    public AccountModel(String username, String password, String name, String surname, AccountRoles role) {
        this.accountId = NEXT_ID;
        NEXT_ID++;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.isActive = true;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public AccountRoles getRole() {
        return role;
    }
    
    public String getFullName() {
        return (name + " " + surname);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(AccountRoles role) {
        this.role = role;
    }
}
