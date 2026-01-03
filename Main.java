class Main {

    public static void main(String args[]) {

        String operation = args[0];
        int id;

        try (TaskTracker taskTracker = new TaskTracker()) {
            switch (operation) {
                case "add":
                    taskTracker.addTask(toDescription(1, args));
                    break;
                case "update":
                    id = Integer.parseInt(args[1]);
                    taskTracker.updateTask(id, toDescription(2, args));
                    break;
                case "delete":
                    id = Integer.parseInt(args[1]);
                    taskTracker.deleteTask(id);
                    break;
                case "mark-in-progress":
                    id = Integer.parseInt(args[2]);
                    taskTracker.markInProgress(id);
                    break;
                case "mark-done":
                    id = Integer.parseInt(args[2]);
                    taskTracker.markDone(id);
                    break;
                case "list":
                    if (args.length == 1) {
                        taskTracker.list("all");
                    } else {
                        String status = args[1];
                        taskTracker.list(status);
                    }
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static String toDescription(int start, String[] args) {
        String description = "";
        for (int i = start; i < args.length; i++) {
            description += args[i];
        }
        return description;
    }
}

// enum Status {
// DONE, IN_PROGRESS, TODO;

// public String toString() {
// return name().replace('_', '-').toLowerCase();
// }
// }