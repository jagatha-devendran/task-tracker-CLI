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

  public String filePath = System.getProperty("user.home") + "/Documents/tasks.json";

  void writeListToJson(ArrayList<Task> tasks) {
    Gson gson = new Gson();
    String jsonString = gson.toJson(tasks);
    try (FileWriter writer = new FileWriter(filePath)) {
      writer.write(jsonString);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  ArrayList<Task> readJsonToList() {
    ArrayList<Task> tasks = new ArrayList<>();
    Path path = Paths.get(filePath);
    try{
      String line = Files.readString(path);
      Type listType = new TypeToken<ArrayList<Task>>() {
      }.getType();
      tasks = new Gson().fromJson(line, listType);
    }catch(NoSuchFileException noSuchFileException){
      new File(filePath);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return tasks;
  }
}
