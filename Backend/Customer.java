package Backend;
public class Customer extends User {
        public Customer(String name, String email) {
            super(name, email);
        }
    
        @Override
        public void displayMenu() {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View Movies");
            System.out.println("2. Book Ticket");
            System.out.println("3. View My Tickets");
            System.out.println("4. Logout");
        }
    }
    
