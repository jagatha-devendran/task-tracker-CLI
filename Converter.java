import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Converter {

  void writeListToJson(ArrayList<Task> tasks) {
    Gson gson = new Gson();
    String jsonString = gson.toJson(tasks);
    System.out.println(jsonString);

    try (FileWriter writer = new FileWriter("tasks.json")) {
      writer.write(jsonString);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  ArrayList<Task> readJsonToList() {
    String line;
    ArrayList<Task> tasks = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("tasks.json"))) {
      while ((line = reader.readLine()) != null) {
        Type listType = new TypeToken<ArrayList<Task>>() {}.getType();
        tasks = new Gson().fromJson(line, listType);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return tasks;
  }

}
