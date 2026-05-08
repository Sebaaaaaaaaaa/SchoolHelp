package Utils;

public enum AccountRoles {
    STUDENT("Student"),
    TECHNICIAN("Technician"),
    ADMIN("Admin");

    private final String role;

    AccountRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}