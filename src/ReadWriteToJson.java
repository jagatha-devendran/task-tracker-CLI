import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ReadWriteToJson {

  private static final String DATA_DIR = System.getProperty("user.home") + File.separator + ".task-tracker";
  private static final String FILE_PATH = DATA_DIR + File.separator + "tasks.json";

  private void ensureDirectoryExists() {
    File dir = new File(DATA_DIR);
    if (!dir.exists()) {
      dir.mkdirs();
    }
  }

  void writeListToJson(ArrayList<Task> tasks) {
    ensureDirectoryExists();
    Gson gson = new Gson();
    String jsonString = gson.toJson(tasks);
    try (FileWriter writer = new FileWriter(FILE_PATH)) {
      writer.write(jsonString);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  ArrayList<Task> readJsonToList() {
    ensureDirectoryExists();
    ArrayList<Task> tasks = new ArrayList<>();
    Path path = Paths.get(FILE_PATH);
    try {
      if (Files.exists(path)) {
        String line = Files.readString(path);
        Type listType = new TypeToken<ArrayList<Task>>() {}.getType();
        tasks = new Gson().fromJson(line, listType);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return tasks == null ? new ArrayList<>() : tasks;
  }
}
