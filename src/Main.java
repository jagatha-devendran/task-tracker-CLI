public class Main {

    public static void main(String[] args) {
        if (args.length == 0 || (args.length == 1 && hasHelpFlag(args))) {
            printGlobalHelp();
            return;
        }

        String command = args[0];

        try (TaskTracker taskTracker = new TaskTracker()) {
            switch (command) {
                case "add":
                    handleRequiredArgs(args, 1, "add <description>");
                    taskTracker.addTask(args[1]);
                    break;

                case "update":
                    handleRequiredArgs(args, 2, "update <id> <description>");
                    taskTracker.updateTask(parseId(args[1]), args[2]);
                    break;

                case "delete":
                    handleRequiredArgs(args, 1, "delete <id>");
                    taskTracker.deleteTask(parseId(args[1]));
                    break;

                case "mark-in-progress":
                    handleRequiredArgs(args, 1, "mark-in-progress <id>");
                    taskTracker.updateStatus(parseId(args[1]), TaskStatus.IN_PROGRESS);
                    break;

                case "mark-done":
                    handleRequiredArgs(args, 1, "mark-done <id>");
                    taskTracker.updateStatus(parseId(args[1]), TaskStatus.DONE);
                    break;

                case "list":
                    if (args.length == 1) {
                        taskTracker.list(null);
                    } else {
                        TaskStatus status = TaskStatus.fromString(args[1]);
                        if (status != null || args[1].equalsIgnoreCase("all")) {
                            taskTracker.list(status);
                        } else {
                            System.err.println("Error: Invalid status. Use: all, todo, in-progress, done");
                        }
                    }
                    break;

                default:
                    System.err.println("Error: Unknown command '" + command + "'. Type 'task-tracker help' for usage.");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static int parseId(String idStr) {
        try {
            return Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid ID format. Please provide a numeric ID.");
        }
    }

    private static void handleRequiredArgs(String[] args, int requiredCount, String usage) {
        if (args.length <= requiredCount) {
            throw new IllegalArgumentException("Missing arguments. Usage: task-tracker " + usage);
        }
    }

    private static boolean hasHelpFlag(String[] args) {
        for (String arg : args) {
            if (arg.equals("-h") || arg.equals("--help")) return true;
        }
        return false;
    }

    private static void printGlobalHelp() {
        System.out.println("Task Tracker CLI - A professional tool to manage your tasks");
        System.out.println("\nUsage:");
        System.out.println("  task-tracker <command> [arguments]");
        System.out.println("\nCommands:");
        System.out.println("  add                Add a new task");
        System.out.println("  update             Update a task description");
        System.out.println("  delete             Delete a task");
        System.out.println("  mark-in-progress   Mark a task as in-progress");
        System.out.println("  mark-done          Mark a task as done");
        System.out.println("  list               List all or filtered tasks");
        System.out.println("  help [command]     Display help for a command");
        System.out.println("\nFlags:");
        System.out.println("  -h, --help         Show this help menu");
        System.out.println("\nUse 'task-tracker <command> --help' for more information on a specific command.");
    }

    private static void printCommandHelp(String command) {
        switch (command) {
            case "add":
                System.out.println("Usage: task-tracker add <description>");
                System.out.println("\nAdds a new task to your list with a default 'todo' status.");
                break;
            case "update":
                System.out.println("Usage: task-tracker update <id> <description>");
                System.out.println("\nUpdates the description of an existing task by its ID.");
                break;
            case "delete":
                System.out.println("Usage: task-tracker delete <id>");
                System.out.println("\nPermanently removes a task from your list.");
                break;
            case "mark-in-progress":
                System.out.println("Usage: task-tracker mark-in-progress <id>");
                System.out.println("\nSets the status of a task to 'in-progress'.");
                break;
            case "mark-done":
                System.out.println("Usage: task-tracker mark-done <id>");
                System.out.println("\nSets the status of a task to 'done'.");
                break;
            case "list":
                System.out.println("Usage: task-tracker list [status]");
                System.out.println("\nDisplays tasks in a table. Optional status filters: all, todo, in-progress, done.");
                break;
            default:
                System.err.println("Unknown command: " + command);
                printGlobalHelp();
                break;
        }
    }
}
