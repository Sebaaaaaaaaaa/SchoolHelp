import ApplicationServices.AdministrationService;
import ApplicationServices.TicketService;
import javax.swing.SwingUtilities;
import GUI.LoginFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame(new TicketService(), new AdministrationService()).setVisible(true));
    }
}
