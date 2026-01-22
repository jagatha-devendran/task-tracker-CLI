import java.util.ArrayList;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.NoSuchElementException;

class TaskTracker implements AutoCloseable {

  ArrayList<Task> tasks = new ArrayList<>();
  ReadWriteToJson converter = new ReadWriteToJson();
  Task taskObjTask = new Task(0, null, null, null, null);

  TaskTracker() {
    tasks = converter.readJsonToList();
  }

  @Override
  public void close() {
    converter.writeListToJson(tasks);
  }

  public void addTask(String description) {
    String status = "todo";    
    try {
      Task findMaxId = tasks.stream().max(Comparator.comparing(SingleTask -> SingleTask.id)).get();
      int id = findMaxId.id + 1;
      Task task = new Task(id, description, status, taskObjTask.dateTimeToString(new Date()), "-");
      tasks.add(task);
      System.out.println("Task has been to added successfully (ID: " + id + ")");
    } catch (NoSuchElementException nse) {
      Task task = new Task(1, description, status, taskObjTask.dateTimeToString(new Date()), "-");
      tasks.add(task);
      System.out.println("Task has been to added successfully (ID: " + 1 + ")");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void updateTask(int id, String description) {
    for (Task task : tasks) {
      if (task.id == id) {
        task.description = description;
        task.updatedAt = taskObjTask.dateTimeToString(new Date());
      }
    }
  }

  public void deleteTask(int id) {
    if (tasks.size() < 1) {
      System.out.println("No task available to delete, Please add a task..");
    } else {
      try {
        for (Task task : tasks) {
          if (task.id == id) {
            tasks.remove(task);
          }

        }
      } catch (ConcurrentModificationException concurrentModificationException) {
        if (tasks.size() < 1) {
          System.out.println("Task has been to deleted successfully (ID: " + id + ")");
          return;
        }
      } catch (Exception e) {
        // e.printStackTrace();
      }
      System.out.println("Task has been to deleted successfully (ID: " + id + ")");
    }
  }

  public void list(String status) {
    System.out.println("\u001B[1mID Task               Status      CreatedAt                UpdatedAt\u001B[0m");
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