package Backend;
import java.util.*;


public class BookingSystem {
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public BookingSystem() {
        
        admins.add(new Admin("admin", "admin@example.com"));
    }

    public void start() {
        System.out.println("Welcome to Ticket Booking System");

        while (true) {
            System.out.print("\nLogin as (1. Admin, 2. Customer, 3. Exit): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) loginAdmin();
            else if (choice == 2) loginCustomer();
            else break;
        }
    }

    private void loginAdmin() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        for (Admin admin : admins) {
            if (admin.getName().equalsIgnoreCase(name) && admin.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Admin login successful.");
                adminMenu(admin);
                return;
            }
        }
        System.out.println("Admin not found or invalid credentials.");
    }

    private void loginCustomer() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name) && customer.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Customer login successful.");
                customerMenu(customer);
                return;
            }
        }
        System.out.print("Customer not found. Do you want to sign up? (yes/no): ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            Customer newCustomer = new Customer(name, email);
            customers.add(newCustomer);
            System.out.println("Signup successful. You are now logged in.");
            customerMenu(newCustomer);
        } else {
            System.out.println("Login cancelled.");
        }
    }

    private void adminMenu(Admin admin) {
        while (true) {
            admin.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) addMovie();
            else if (choice == 2) viewMovies();
            else if (choice == 3) updateMovie();
            else if (choice == 4) removeMovie();
            else if (choice == 5) viewAllBookings();
            else if (choice == 6) cancelBookingAdmin();
            else break;
        }
    }

    private void customerMenu(Customer customer) {
        while (true) {
            System.out.println("Customer Menu:");
            System.out.println("1. View Movies");
            System.out.println("2. Book Ticket");
            System.out.println("3. View Tickets");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) viewMovies();
            else if (choice == 2) bookTicket(customer);
            else if (choice == 3) viewTickets(customer);
            else if (choice == 4) cancelTicket(customer);
            else break;
        }
    }

    private void addMovie() {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.print("Enter show time: ");
        String time = scanner.nextLine();
        System.out.print("Enter total seats: ");
        int seats = scanner.nextInt();
        scanner.nextLine();
        movies.add(new Movie(title, time, seats));
        System.out.println("Movie added successfully!");
    }

    private void viewMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }
        System.out.println("\nAvailable Movies:");
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            System.out.println((i + 1) + ". " + movie.getTitle());
            System.out.println("   Show Time: " + movie.getShowTime());
            System.out.println("   Available Seats: " + movie.getAvailableSeats());
        }
    }

    private void bookTicket(Customer customer) {
        viewMovies();
        System.out.print("Select movie number: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= movies.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Movie selectedMovie = movies.get(index);
        if (selectedMovie.getAvailableSeats() <= 0) {
            System.out.println("No seats available.");
            return;
        }

        System.out.print("Enter number of tickets: ");
        int ticketCount = scanner.nextInt();
        scanner.nextLine();

        if (ticketCount > selectedMovie.getAvailableSeats()) {
            System.out.println("Not enough seats available.");
            return;
        }

        for (int i = 0; i < ticketCount; i++) {
            Integer seatNumber = selectedMovie.bookSeat();
            if (seatNumber == null) {
                System.out.println("Failed to book seat.");
                return;
            }
            Ticket ticket = new Ticket(selectedMovie, customer, seatNumber);
            tickets.add(ticket);
            customer.addTicket(ticket);
            System.out.println("Ticket booked successfully. Ticket ID: " + ticket.getTicketId());
        }
    }

    private void cancelTicket(Customer customer) {
        ArrayList<Ticket> userTickets = customer.getTickets();
        if (userTickets.isEmpty()) {
            System.out.println("No tickets to cancel.");
            return;
        }

        for (int i = 0; i < userTickets.size(); i++) {
            Ticket ticket = userTickets.get(i);
            System.out.println((i + 1) + ". Ticket ID: " + ticket.getTicketId() + ", Movie: " + ticket.getMovie().getTitle() + ", Seat: " + ticket.getSeatNumber());
        }

        System.out.print("Select ticket number to cancel: ");
        int cancelIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (cancelIndex < 0 || cancelIndex >= userTickets.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Ticket toCancel = userTickets.remove(cancelIndex);
        tickets.remove(toCancel);
        toCancel.getMovie().cancelSeat(toCancel.getSeatNumber());
        System.out.println("Ticket cancelled successfully.");
    }

    private void viewTickets(Customer customer) {
        ArrayList<Ticket> userTickets = customer.getTickets();
        if (userTickets.isEmpty()) {
            System.out.println("No tickets booked.");
            return;
        }

        for (Ticket ticket : userTickets) {
            ticket.printTicket();
            System.out.println("------------------------");
        }
    }

    private void updateMovie() {
        viewMovies();
        System.out.print("Select movie number to update: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= movies.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Movie movie = movies.get(index);
        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new show time: ");
        String newTime = scanner.nextLine();
        movie.updateDetails(newTitle, newTime);
        System.out.println("Movie updated successfully.");
    }

    private void removeMovie() {
        viewMovies();
        System.out.print("Select movie number to remove: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= movies.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        movies.remove(index);
        System.out.println("Movie removed successfully.");
    }

    private void viewAllBookings() {
        if (tickets.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        for (Ticket ticket : tickets) {
            ticket.printTicket();
            System.out.println("------------------------");
        }
    }

    private void cancelBookingAdmin() {
        viewAllBookings();
        System.out.print("Enter Ticket ID to cancel: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine();

        Ticket toCancel = null;
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                toCancel = ticket;
                break;
            }
        }

        if (toCancel != null) {
            tickets.remove(toCancel);
            toCancel.getCustomer().getTickets().remove(toCancel);
            toCancel.getMovie().cancelSeat(toCancel.getSeatNumber());
            System.out.println("Ticket cancelled successfully.");
        } else {
            System.out.println("Ticket ID not found.");
        }
    }
}
