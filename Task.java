import java.util.*;
import java.text.SimpleDateFormat;

class Task {
    int id;
    String description, status, createdAt, updatedAt;
    Task(int id, String description, String status, String createdAt, String updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        
    }

    @Override
    public String toString() {
        // System.out.println("1  apply interview    inprogress  Jan 7, 2026, 10:20:27 AM Jan 1, 1970, 5:30:00 AM");
        return this.id + "  " + this.description + "    " + this.status + "        " + this.createdAt + " " + this.updatedAt;
    }

    public String dateTimeToString(Date now) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formatted = format.format(now);
        return formatted;
    }
}
