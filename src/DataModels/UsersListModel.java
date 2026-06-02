package DataModels;

import javax.swing.DefaultListModel;
import java.util.List;

public class UsersListModel extends DefaultListModel<String> {

    private final List<AccountModel> users;

    public UsersListModel(List<AccountModel> users) {
        this.users = users;

        for (AccountModel user : users) {
            addElement(user.getUsername() + ", " + user.getRole().getRole());
        }
    }

    public AccountModel getTicketAt(int index) {
        return users.get(index);
    }
}
