import com.google.gson.annotations.SerializedName;

public enum TaskStatus {
    @SerializedName("todo")
    TODO("todo"),
    
    @SerializedName("in-progress")
    IN_PROGRESS("in-progress"),
    
    @SerializedName("done")
    DONE("done");

    private final String value;

    TaskStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static TaskStatus fromString(String text) {
        for (TaskStatus b : TaskStatus.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
