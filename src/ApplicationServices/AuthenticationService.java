package ApplicationServices;

import DataModels.AccountModel;
import Utils.AccountRoles;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationService {
    private List<AccountModel> dummyAccounts;

    public AuthenticationService() {
        dummyAccounts = new ArrayList<>();
        
        dummyAccounts.add(new AccountModel(1, "admin", "admin123", "System", "Admin", AccountRoles.ADMIN));
        dummyAccounts.add(new AccountModel(2, "student", "password", "Test", "Student", AccountRoles.STUDENT));
        dummyAccounts.add(new AccountModel(3, "tech", "tech123", "Test", "Technician", AccountRoles.TECHNICIAN));
    }

    public AccountModel login(String username, String password) {
        for (AccountModel account : dummyAccounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }
}
