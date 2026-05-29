import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

class TaskTracker implements AutoCloseable {

  private ArrayList<Task> tasks;
  private final ReadWriteToJson converter = new ReadWriteToJson();

  public TaskTracker() {
    tasks = converter.readJsonToList();
    if (tasks == null) {
      tasks = new ArrayList<>();
    }
  }

  @Override
  public void close() {
    converter.writeListToJson(tasks);
  }

  public void addTask(String description) {
    int id = 1;
    if (!tasks.isEmpty()) {
      id = tasks.stream().max(Comparator.comparing(t -> t.id)).get().id + 1;
    }
    
    Task task = new Task(id, description, TaskStatus.TODO, Task.formatDateTime(new Date()), "-");
    tasks.add(task);
    System.out.println("Task added successfully (ID: " + id + ")");
  }

  public void updateTask(int id, String description) {
    Task task = findById(id);
    if (task != null) {
      task.description = description;
      task.updatedAt = Task.formatDateTime(new Date());
      System.out.println("Task updated successfully (ID: " + id + ")");
    } else {
      System.err.println("Error: Task with ID " + id + " not found.");
    }
  }

  public void deleteTask(int id) {
    if (tasks.removeIf(task -> task.id == id)) {
      System.out.println("Task deleted successfully (ID: " + id + ")");
    } else {
      System.err.println("Error: Task with ID " + id + " not found.");
    }
  }

  public void updateStatus(int id, TaskStatus status) {
    Task task = findById(id);
    if (task != null) {
      task.status = status;
      task.updatedAt = Task.formatDateTime(new Date());
      System.out.println("Task marked as " + status + " (ID: " + id + ")");
    } else {
      System.err.println("Error: Task with ID " + id + " not found.");
    }
  }

  public void list(TaskStatus filterStatus) {
    if (tasks.isEmpty()) {
      System.out.println("No tasks found.");
      return;
    }

    var filteredTasks = tasks.stream()
        .filter(task -> filterStatus == null || task.status == filterStatus)
        .toList();

    if (filteredTasks.isEmpty()) {
      System.out.println("No tasks found" + (filterStatus != null ? " with status: " + filterStatus : "") + ".");
      return;
    }

    String border = "+" + "-".repeat(6) + "+" + "-".repeat(40) + "+" + "-".repeat(14) + "+" + "-".repeat(21) + "+" + "-".repeat(21) + "+";
    System.out.println(border);
    System.out.println(String.format("| %-4s | %-38s | %-12s | %-19s | %-19s |", "ID", "Description", "Status", "Created At", "Updated At"));
    System.out.println(border);

    filteredTasks.forEach(this::printTask);
    System.out.println(border);
  }

  private Task findById(int id) {
    return tasks.stream().filter(t -> t.id == id).findFirst().orElse(null);
  }

  private void printTask(Task task) {
    System.out.println(String.format("| %-4d | %-38s | %-12s | %-19s | %-19s |", 
        task.id, 
        truncate(task.description, 38), 
        task.status, 
        task.createdAt, 
        task.updatedAt));
  }

  private String truncate(String str, int length) {
    if (str.length() <= length) return str;
    return str.substring(0, length - 3) + "...";
  }
}
