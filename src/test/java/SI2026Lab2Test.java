import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SI2026Lab2Test {

    @Test
    public void searchBookEveryStatementTest() {

        Library library = new Library();

        library.addBook(new Book("Clean Code", "Robert Martin", "Programming"));

        // TEST 1 -> exception
        assertThrows(IllegalArgumentException.class, () -> {
            library.searchBookByTitle("");
        });

        // TEST 2 -> successful search
        List<Book> result = library.searchBookByTitle("Clean Code");

        assertNotNull(result);
        assertEquals(1, result.size());

        // TEST 3 -> no results
        List<Book> noBook = library.searchBookByTitle("Unknown");

        assertNull(noBook);
    }
    @Test
    public void borrowBookEveryBranchTest() {

        Library library = new Library();

        Book book1 = new Book("Clean Code", "Robert Martin", "Programming");

        library.addBook(book1);

        // TEST 1 -> invalid input
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "");
        });

        // TEST 2 -> successful borrow
        assertDoesNotThrow(() -> {
            library.borrowBook("Clean Code", "Robert Martin");
        });

        // TEST 3 -> already borrowed
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Clean Code", "Robert Martin");
        });

        // TEST 4 -> book not found
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Unknown", "Unknown");
        });
    }
    @Test
    public void borrowBookMultipleConditionTest() {

        Library library = new Library();

        library.addBook(new Book("Clean Code", "Robert Martin", "Programming"));

        // T || T
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "");
        });

        // T || F
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "Robert Martin");
        });

        // F || T
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("Clean Code", "");
        });

        // F || F
        assertDoesNotThrow(() -> {
            library.borrowBook("Clean Code", "Robert Martin");
        });
    }
    @Test
    public void searchBookMultipleConditionTest() {

        Library library = new Library();

        Book book1 = new Book("Clean Code", "Robert Martin", "Programming");

        library.addBook(book1);

        // T && T
        List<Book> result1 = library.searchBookByTitle("Clean Code");

        assertNotNull(result1);

        // T && F
        book1.setBorrowed(true);

        List<Book> result2 = library.searchBookByTitle("Clean Code");

        assertNull(result2);

        // F && T
        book1.setBorrowed(false);

        List<Book> result3 = library.searchBookByTitle("Unknown");

        assertNull(result3);

        // F && F
        book1.setBorrowed(true);

        List<Book> result4 = library.searchBookByTitle("Unknown");

        assertNull(result4);
    }
}

