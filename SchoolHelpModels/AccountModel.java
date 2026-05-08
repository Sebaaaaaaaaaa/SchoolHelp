package SchoolHelpModels;

import utils.AccountRoles;

public class AccountModel {

    private final int id;
    private final String username;
    private final  String password;
    private final  String name;
    private final String surname;    
    private final AccountRoles role;
    
    public AccountModel(int id, String username, String password, String name, String surname, AccountRoles role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }
}
