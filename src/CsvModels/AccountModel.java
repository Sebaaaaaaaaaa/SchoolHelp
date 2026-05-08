package CsvModels;

import Utils.AccountRoles;

public class AccountModel {

    private final int accountId;
    private final String username;
    private final  String password;
    private final  String name;
    private final String surname;    
    private final AccountRoles role;
    
    public AccountModel(int accountId, String username, String password, String name, String surname, AccountRoles role) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
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
}
