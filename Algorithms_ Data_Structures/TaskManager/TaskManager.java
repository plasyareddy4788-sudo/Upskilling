class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() { return taskId; }
    public String getTaskName() { return taskName; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Task ID: " + taskId + " | Name: " + taskName + " | Status: " + status;
    }
}

public class TaskManager {
    
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskManager() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equalsIgnoreCase(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public boolean deleteTask(String taskId) {
        if (head == null) {
            return false;
        }

        if (head.task.getTaskId().equalsIgnoreCase(taskId)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId().equalsIgnoreCase(taskId)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        TaskManager tm = new TaskManager();

        tm.addTask(new Task("T001", "Database Backup", "Pending"));
        tm.addTask(new Task("T002", "Code Review", "In Progress"));
        tm.addTask(new Task("T003", "Deploy to Production", "Completed"));

        System.out.println("--- All Tasks ---");
        tm.traverseTasks();

        System.out.println("\n--- Searching for T002 ---");
        Task found = tm.searchTask("T002");
        System.out.println(found != null ? found : "Task not found.");

        System.out.println("\n--- Deleting T002 ---");
        if (tm.deleteTask("T002")) {
            System.out.println("Successfully deleted T002.");
        }

        System.out.println("\n--- Updated Tasks ---");
        tm.traverseTasks();
    }
}