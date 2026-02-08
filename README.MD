

## 📝 Task CLI – Java Command Line Task Manager

A simple and efficient **command-line task manager** built using Java and Gson. This tool helps you add, update, delete, and track tasks directly from the terminal with persistent storage using JSON.

---

## 🚀 Features

* ➕ Add new tasks
* ✏️ Update existing tasks
* 🗑️ Delete tasks
* ⏳ Mark tasks as **in-progress**
* ✅ Mark tasks as **done**
* 📋 List all tasks
* 🔍 Filter tasks by status (`todo`, `in-progress`, `done`)
* 💾 Data stored using **Gson (JSON format)**

---

## 🛠️ Technologies Used

* Java
* Gson (for JSON serialization/deserialization)
* Command Line Interface (CLI)

---

## 📦 Commands

### ➕ Add a new task

```bash
task-cli add "Buy groceries"
```

### ✏️ Update a task

```bash
task-cli update 1 "Buy groceries and cook dinner"
```

### 🗑️ Delete a task

```bash
task-cli delete 1
```

### ⏳ Mark task as in progress

```bash
task-cli mark-in-progress 1
```

### ✅ Mark task as done

```bash
task-cli mark-done 1
```

### 📋 List all tasks

```bash
task-cli list
```

### 🔍 List tasks by status

```bash
task-cli list todo
task-cli list in-progress
task-cli list done
```

---

## 📂 Project Structure (example)

```
task-cli/
│
├── src/
│   ├── Task.java
│   ├── TaskManager.java
│   ├── Main.java
│
├── tasks.json
├── README.md
```

---

## 🧠 How It Works

* Tasks are stored in a `tasks.json` file using **Gson**.
* Each task has:

  * `id`
  * `description`
  * `status` (`todo`, `in-progress`, `done`)
* The CLI parses commands and performs operations on the task list.

---

## 💡 Example Output

```
Task added successfully (ID: 1)
Task updated successfully
Task marked as done
```

---

## 📌 Future Improvements (Optional Ideas)

* Add due dates and priorities
* Add search by keyword
* Export tasks to CSV
* Add undo feature

---

If you want, I can:

* Customize this with your **GitHub username/repo name**, or
* Make it shorter/crisper for resumes or Zoho submissions 😊
Nice project, Jagatha! 🎉 That’s a clean CLI tool — perfect for a GitHub showcase.

Here’s a **ready-to-use `README.md`** for your Java Task CLI project using Gson:

---

## 📝 Task CLI – Java Command Line Task Manager

A simple and efficient **command-line task manager** built using Java and Gson. This tool helps you add, update, delete, and track tasks directly from the terminal with persistent storage using JSON.

---

## 🚀 Features

* ➕ Add new tasks
* ✏️ Update existing tasks
* 🗑️ Delete tasks
* ⏳ Mark tasks as **in-progress**
* ✅ Mark tasks as **done**
* 📋 List all tasks
* 🔍 Filter tasks by status (`todo`, `in-progress`, `done`)
* 💾 Data stored using **Gson (JSON format)**

---

## 🛠️ Technologies Used

* Java
* Gson (for JSON serialization/deserialization)
* Command Line Interface (CLI)

---

## 📦 Commands

### ➕ Add a new task

```bash
task-cli add "Buy groceries"
```

### ✏️ Update a task

```bash
task-cli update 1 "Buy groceries and cook dinner"
```

### 🗑️ Delete a task

```bash
task-cli delete 1
```

### ⏳ Mark task as in progress

```bash
task-cli mark-in-progress 1
```

### ✅ Mark task as done

```bash
task-cli mark-done 1
```

### 📋 List all tasks

```bash
task-cli list
```

### 🔍 List tasks by status

```bash
task-cli list todo
task-cli list in-progress
task-cli list done
```

---

## 📂 Project Structure (example)

```
task-cli/
│
├── src/
│   ├── Task.java
│   ├── TaskManager.java
│   ├── Main.java
│
├── tasks.json
├── README.md
```

---

## 🧠 How It Works

* Tasks are stored in a `tasks.json` file using **Gson**.
* Each task has:

  * `id`
  * `description`
  * `status` (`todo`, `in-progress`, `done`)
* The CLI parses commands and performs operations on the task list.

---

## 💡 Example Output

```
Task added successfully (ID: 1)
Task updated successfully
Task marked as done
```

---

## 📌 Future Improvements (Optional Ideas)

* Add due dates and priorities
* Add search by keyword
* Export tasks to CSV
* Add undo feature

- - - 
