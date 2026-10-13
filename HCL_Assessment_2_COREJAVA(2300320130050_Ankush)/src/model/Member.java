package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {

    private static final String DEFAULT_EMAIL = "unknown@library.local";
    private static int idCounter = 1;

    private final int id;
    private String name;
    private String email;
    private final List<LibraryItem> borrowedItems;

    public Member(String name, String email) {
        validateName(name);
        validateEmail(email);
        this.id = idCounter++;
        this.name = name.trim();
        this.email = email.trim();
        this.borrowedItems = new ArrayList<>();
    }

    /** Overloaded constructor: registers a member with a placeholder email. */
    public Member(String name) {
        this(name, DEFAULT_EMAIL);
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank.");
        }
    }

    private static void validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email must contain '@'.");
        }
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) {
        validateName(name);
        this.name = name.trim();
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email.trim();
    }

    public List<LibraryItem> getBorrowedItems() {
        return Collections.unmodifiableList(borrowedItems);
    }

    public int getBorrowedCount() { return borrowedItems.size(); }

    public void addBorrowedItem(LibraryItem item) { borrowedItems.add(item); }

    public boolean removeBorrowedItem(LibraryItem item) { return borrowedItems.remove(item); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        return id == ((Member) o).id;
    }

    @Override
    public int hashCode() { return Integer.hashCode(id); }

    @Override
    public String toString() {
        return "Member[id=" + id + ", name='" + name + "', email='" + email
                + "', borrowed=" + borrowedItems.size() + "]";
    }
}
