# Task Tracker CLI 🚀

A professional-grade, lightweight command-line utility built in Java for efficient task management. Designed to feel like a native system tool, it provides persistent storage, global accessibility, and a clean, structured interface.

---

## 📖 About

**Task Tracker CLI** is a terminal-based productivity tool that helps developers and CLI enthusiasts manage their daily tasks without leaving the command line. Built with a focus on simplicity, portability, and professional standards, it serves as a robust alternative to local text-file tracking.

Whether you're managing a complex project or a simple to-do list, Task Tracker provides the structural integrity of a database-backed application with the speed of a shell command.

---

## ✨ Features

- **Native CLI Feel** → Run `task-tracker` globally from any directory.
- **Persistent Storage** → Tasks are stored in `~/.task-tracker/tasks.json` using a centralized data model.
- **Structured UI** → Beautifully formatted tables with vertical separators for easy reading.
- **Professional Help System** → Detailed, command-specific help (e.g., `task-tracker add --help`).
- **Robust Logic** → Type-safe status management and comprehensive error handling.

---

## 🛠 Implementation Details

### Architecture
The project follows a modular, object-oriented design:
- **`Main.java`**: The entry point. Handles sophisticated command routing, argument parsing, and the multi-layered help system.
- **`TaskTracker.java`**: The core engine. Manages business logic, task lifecycle, and data filtering.
- **`Task.java`**: The data model representing a Task, featuring unique IDs and ISO-formatted timestamps.
- **`TaskStatus.java`**: A type-safe Enum (`TODO`, `IN_PROGRESS`, `DONE`) ensuring data integrity.
- **`ReadWriteToJson.java`**: The persistence layer. Uses **Gson** to manage JSON serialization with automatic directory management in the user's home folder.

### Portability
Unlike basic CLI tools that create files in the current directory, this tool adheres to Unix-like standards by centralizing data in a hidden configuration directory (`~/.task-tracker/`), ensuring your tasks follow you regardless of where you work in the terminal.

---

## ⚡ Setup & Installation

### Prerequisites
- **Java Runtime Environment (JRE)** 17 or higher.
- **Git** (to clone the repo).

### 1-Step Installation
Clone the repository and run the automated installation script:

```bash
git clone <your-repo-url>
cd task-tracker-CLI
./install.sh
```

The script will:
1. Compile the Java source code.
2. Install the binaries to `~/.task-tracker-cli`.
3. Create a global symbolic link in `~/.local/bin`.

### Ensure `~/.local/bin` is in your PATH
If the `task-tracker` command is not recognized, add the following to your `~/.bashrc` or `~/.zshrc`:

```bash
export PATH="$HOME/.local/bin:$PATH"
```

---

## 🚀 Usage

### 📖 Accessing Help
The tool features a comprehensive help system.
```bash
task-tracker --help         # Global overview
task-tracker help add       # Specific help for 'add' command
task-tracker update -h      # Quick flag for specific usage
```

### 📝 Task Management

**Add a new task**
```bash
task-tracker add "Buy groceries"
```

**Update a task description**
```bash
task-tracker update 1 "Buy groceries and cook dinner"
```

**Change task status**
```bash
task-tracker mark-in-progress 1
task-tracker mark-done 1
```

**Delete a task**
```bash
task-tracker delete 1
```

### 📋 Listing Tasks
The `list` command provides a clean, tabular view.
```bash
task-tracker list           # List all tasks
task-tracker list todo      # Filter by todo
task-tracker list done      # Filter by done
```

---

## 📜 License
This project is open-source and available under the **[MIT License](LICENSE)**.
