package ApplicationServices;

import DataModels.AccountModel;
import Utils.AccountRoles;
import java.util.ArrayList;
import java.util.List;

public class AdministrationService {
    private final List<AccountModel> users;
    
    public AdministrationService() {
       users = new ArrayList<>();
        
       users.add(new AccountModel("a", "123", "System", "Admin", AccountRoles.ADMIN));
       users.add(new AccountModel("s", "123", "Student", "Student", AccountRoles.STUDENT));
       users.add(new AccountModel("t", "123", "Technician", "Technician", AccountRoles.TECHNICIAN));
    }

    public List<AccountModel> getUsers() {
        return users;
    }
    
    public String getStudents() {
        int counter = 0;
        for (AccountModel user : users) {
            if (user.getRole() == AccountRoles.STUDENT) {
                counter++;
            }
        }
        return Integer.toString(counter);
    }
    
        public String getTechnicians() {
        int counter = 0;
        for (AccountModel user : users) {
            if (user.getRole() == AccountRoles.TECHNICIAN) {
                counter++;
            }
        }
        return Integer.toString(counter);
    }
        
        public String getAdmins() {
        int counter = 0;
        for (AccountModel user : users) {
            if (user.getRole() == AccountRoles.ADMIN) {
                counter++;
            }
        }
        return Integer.toString(counter);
    }
}
