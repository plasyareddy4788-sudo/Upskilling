import java.util.Arrays;

class Book implements Comparable<Book> {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return "ID: " + bookId + " | Title: \"" + title + "\" | Author: " + author;
    }
}

public class LibraryManager {

    public static int linearSearchByTitle(Book[] books, String targetTitle) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equalsIgnoreCase(targetTitle)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearchByTitle(Book[] books, String targetTitle) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Book[] library = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B002", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B003", "1984", "George Orwell"),
            new Book("B004", "Moby Dick", "Herman Melville"),
            new Book("B005", "Brave New World", "Aldous Huxley")
        };

        System.out.println("--- Linear Search ---");
        String searchTitle1 = "1984";
        int linearIndex = linearSearchByTitle(library, searchTitle1);
        if (linearIndex != -1) {
            System.out.println("Found at index " + linearIndex + ": " + library[linearIndex]);
        } else {
            System.out.println("\"" + searchTitle1 + "\" not found.");
        }

        Arrays.sort(library);

        System.out.println("\n--- Binary Search (Sorted Library) ---");
        String searchTitle2 = "Moby Dick";
        int binaryIndex = binarySearchByTitle(library, searchTitle2);
        if (binaryIndex != -1) {
            System.out.println("Found at index " + binaryIndex + ": " + library[binaryIndex]);
        } else {
            System.out.println("\"" + searchTitle2 + "\" not found.");
        }
    }
}