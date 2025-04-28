package Backend;
public class Ticket {
    private String movieName;
    private String customerName; 
    private static int ticketCounter = 1;
    private int ticketId;

    public Ticket(Movie movie, Customer customer) {
        this.movieName = movie.getTitle();   
        this.ticketId = ticketCounter++;
    }

    public Customer getCustomer() {
        return new Customer(customerName, "");  
    }

    public void printTicket() {
        System.out.println("\n======================");
        System.out.println("      Your Ticket      ");
        System.out.println("======================");
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Movie: " + movieName);
        System.out.println("======================\n");
    }
}


    