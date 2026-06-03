package ApplicationServices;

import DataModels.AccountModel;
import Utils.AccountRoles;
import java.util.ArrayList;
import java.util.List;

public class AdministrationService {
    private final List<AccountModel> users;
    
    public AdministrationService() {
       users = new ArrayList<>();
       
       addUser("a", "123", "System", "Admin", AccountRoles.ADMIN);
       addUser("s", "123", "Student", "Student", AccountRoles.STUDENT);
       addUser("t", "123", "Technician", "Technician", AccountRoles.TECHNICIAN);
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
    
    public final void addUser(String username, String password, String name, String surname, AccountRoles role) {
        users.add(new AccountModel(username, password, name, surname, role));
    }
}
