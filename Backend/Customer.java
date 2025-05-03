package Backend;

import java.util.ArrayList;

public class Customer extends User {
    private ArrayList<Ticket> tickets;

    public Customer(String name, String email) {
        super(name, email);
        this.tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
}
    
