package Backend;
public class Admin extends User {
        public Admin(String name, String email) {
            super(name, email);
        }
    
        @Override
        public void displayMenu() {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Movie");
            System.out.println("2. View Movies");
            System.out.println("3. Logout");
        }
    }
    
