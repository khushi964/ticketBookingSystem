package Backend;
import java.util.*;

public class BookingSystem {
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

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
        Admin admin = new Admin(name, email);
        adminMenu(admin);
    }

    private void loginCustomer() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        Customer customer = new Customer(name, email);
        customerMenu(customer);
    }

    private void adminMenu(Admin admin) {
        while (true) {
            admin.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) addMovie();
            else if (choice == 2) viewMovies();
            else break;
        }
    }

    private void customerMenu(Customer customer) {
        while (true) {
            customer.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) viewMovies();
            else if (choice == 2) bookTicket(customer);
            else if (choice == 3) viewTickets(customer);
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
            System.out.print((i + 1) + ". ");
            movies.get(i).display();
        }
    }

    private void bookTicket(Customer customer) {
        viewMovies();
        System.out.print("Choose movie number to book: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < movies.size()) {
            Movie movie = movies.get(index);
            if (movie.bookSeat()) {
                Ticket ticket = new Ticket(movie, customer);
                tickets.add(ticket);
                System.out.println("Ticket booked successfully!");
                ticket.printTicket();
            } else {
                System.out.println("Sorry, no seats available.");
            }
        } else {
            System.out.println("Invalid selection.");
        }
    }

        private void viewTickets(Customer customer) {
                System.out.println("\nYour Tickets:");
                for (Ticket ticket : tickets) {
                if (ticket.getCustomer().equals(customer)) {
                        ticket.printTicket();
                }
                }
        }
}

