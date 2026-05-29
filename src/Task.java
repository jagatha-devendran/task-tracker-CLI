import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    int id;
    String description;
    TaskStatus status;
    String createdAt;
    String updatedAt;
    
    public Task(int id, String description, TaskStatus status, String createdAt, String updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static String formatDateTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return format.format(date);
    }
}
