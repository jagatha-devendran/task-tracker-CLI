import java.util.ArrayList;

class TaskTracker implements AutoCloseable {

  ArrayList<Task> tasks = new ArrayList<>();
  Converter converter = new Converter();

  TaskTracker() {
    tasks = converter.readJsonToList();
  }

  @Override
  public void close() {
    converter.writeListToJson(tasks);
  }

  public void addTask(String description) {
    int id = tasks.size() + 1;
    String status = "todo";
    Task task = new Task(id, description, status);
    tasks.add(task);
  }

  public void updateTask(int id, String description) {
    for (Task task : tasks) {
      if (task.id == id) {
        task.description = description;
      }
    }
  }

  public void deleteTask(int id) {
    for (Task task : tasks) {
      if (task.id == id) {
        tasks.remove(task);
      }
    }
  }

  public void list(String status) {
    tasks.stream()
        .filter(task -> status.equals("all") || task.status.equals(status))
        .forEach(System.out::println);
  }

  public void markInProgress(int id) {
    for (Task task : tasks) {
      if (task.id == id) {
        task.status = "in-progress";
      }
    }
  }

  public void markDone(int id) {
    for (Task task : tasks) {
      if (task.id == id) {
        task.status = "done";
      }
    }
  }

}