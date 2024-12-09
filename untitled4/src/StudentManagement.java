public class StudentManagement {
    private Node head; // Head of the linked list

    // Constructor
    public StudentManagement() {
        this.head = null;
    }

    // Node class for linked list
    private static class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    // 1. Add student at the beginning of the list
    public void addFirst(Student student) {
        Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;
        System.out.println("Added student at the beginning of the list.");
    }

    // 2. Add student at the end of the list
    public void addLast(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Added student at the end of the list.");
    }

    // 3. Delete the first student
    public void deleteFirst() {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }
        head = head.next;
        System.out.println("Deleted the first student.");
    }

    // 4. Delete the last student
    public void deleteLast() {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        System.out.println("Deleted the last student.");
    }

    // 5. Traverse and print student list
    public void traverse() {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }
        Node current = head;
        System.out.println("\nStudent List:");
        System.out.println(String.format("%-10s %-20s %-5s %-10s", "ID", "Name", "Score", "Rank"));
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // 6. Search for student by ID
    public Student searchById(String id) {
        Node current = head;
        while (current != null) {
            if (current.data.getId().equalsIgnoreCase(id)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // 7. Update student's score by ID
    public void updateStudent(String id, double newScore) {
        Node current = head;
        while (current != null) {
            if (current.data.getId().equalsIgnoreCase(id)) {
                current.data.setScore(newScore); // Update score directly
                System.out.println("Updated score for student " + id);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // 8. Delete student by ID
    public void deleteById(String id) {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }
        if (head.data.getId().equalsIgnoreCase(id)) {
            head = head.next;
            System.out.println("Deleted student " + id);
            return;
        }
        Node current = head;
        while (current.next != null && !current.next.data.getId().equalsIgnoreCase(id)) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student with ID " + id + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Deleted student " + id);
        }
    }

    // 9. Sort by score (Bubble Sort)
    public void bubbleSortByScore() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data.getScore() > current.next.data.getScore()) {
                    // Swap data between nodes
                    Student temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("Sorted the list by score (ascending).");
    }

    // 10. Sort by name (Insertion Sort)
    public void insertionSortByName() {
        if (head == null || head.next == null) return;
        Node sorted = null;

        Node current = head;
        while (current != null) {
            Node next = current.next;
            if (sorted == null || sorted.data.getName().compareToIgnoreCase(current.data.getName()) >= 0) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;
                while (temp.next != null && temp.next.data.getName().compareToIgnoreCase(current.data.getName()) < 0) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }
            current = next;
        }
        head = sorted;
        System.out.println("Sorted the list by name (A-Z).");
    }
}
