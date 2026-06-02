package Utils;

import DataModels.AccountModel;
import java.util.List;

public class AuthenticationUtil {

    public static AccountModel authlogin(String username, String password, List<AccountModel> accounts) {
        for (AccountModel account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }
}
