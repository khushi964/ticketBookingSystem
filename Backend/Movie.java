package Backend;
import java.util.HashSet;
import java.util.Set;

public class Movie {
    private String title;
    private String showTime;
    private int totalSeats;
    private int availableSeats;
    private Set<Integer> bookedSeats; 

    public Movie(String title, String showTime, int totalSeats) {
        this.title = title;
        this.showTime = showTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.bookedSeats = new HashSet<>();
    }

    public String getTitle() {
        return title;
    }

    public String getShowTime() {
        return showTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean isSeatBooked(int seatNumber) {
        return bookedSeats.contains(seatNumber);
    }

    public void bookSpecificSeat(int seatNumber) {
        if (seatNumber > 0 && seatNumber <= totalSeats && !bookedSeats.contains(seatNumber)) {
            bookedSeats.add(seatNumber);
            availableSeats--;
        }
    }

    public void cancelSeat(int seatNumber) {
        if (bookedSeats.contains(seatNumber)) {
            bookedSeats.remove(seatNumber);
            availableSeats++;
        }
    }

    public Integer bookSeat() {
        for (int i = 1; i <= totalSeats; i++) {
            if (!bookedSeats.contains(i)) {
                bookedSeats.add(i);
                availableSeats--;
                return i;
            }
        }
        return null; 
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public void updateDetails(String title, String showTime) {
        this.title = title;
        this.showTime = showTime;
    }
}