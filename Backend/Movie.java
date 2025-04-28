package Backend;
public class Movie {
    private String title;
    private String time;
    private int availableSeats;

    public  Movie(String title, String time, int seats) {
        this.title = title;
        this.time = time;
        this.availableSeats = seats;
    }

    public String getTitle() { return title; }
    public String getTime() { return time; }
    public int getAvailableSeats() { return availableSeats; }

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public void display() {
        System.out.println(title + " at " + time + " | Seats Left: " + availableSeats);
    }
}
