package Backend;
public class Admin {
    private String name;
    private String email;

    public Admin(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void displayMenu() {
        System.out.println("\nAdmin Menu:");
        System.out.println("1. Add Movie");
        System.out.println("2. View Movies");
        System.out.println("3. Update Movie");
        System.out.println("4. Remove Movie");
        System.out.println("5. View All Bookings");
        System.out.println("6. Cancel Booking");
        System.out.println("7. Logout");
    }
}
