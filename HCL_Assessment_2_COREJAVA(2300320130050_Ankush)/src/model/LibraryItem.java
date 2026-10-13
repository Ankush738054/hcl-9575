package model;

import java.time.Year;

/** Base class for every item the library lends. */
public abstract class LibraryItem implements Borrowable, Comparable<LibraryItem> {

    private static final int MIN_YEAR = 1900;
    private static int idCounter = 1;

    private final int id;
    private String title;
    private int year;
    private boolean available;

    protected LibraryItem(String title, int year) {
        validateTitle(title);
        validateYear(year);
        this.id = idCounter++;
        this.title = title.trim();
        this.year = year;
        this.available = true;
    }

    private static void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be blank.");
        }
    }

    private static void validateYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < MIN_YEAR || year > currentYear) {
            throw new IllegalArgumentException(
                    "Year must be between " + MIN_YEAR + " and " + currentYear + ".");
        }
    }

    /** Late fee for this item type. */
    public abstract double lateFee(int daysLate);

    public int getId() { return id; }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        validateTitle(title);
        this.title = title.trim();
    }

    public int getYear() { return year; }

    public void setYear(int year) {
        validateYear(year);
        this.year = year;
    }

    @Override
    public boolean isAvailable() { return available; }

    @Override
    public void borrow() { this.available = false; }

    @Override
    public void giveBack() { this.available = true; }

    /** Natural ordering: by id. */
    @Override
    public int compareTo(LibraryItem other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryItem)) return false;
        return id == ((LibraryItem) o).id;
    }

    @Override
    public int hashCode() { return Integer.hashCode(id); }

    @Override
    public String toString() {
        return "id=" + id + ", title='" + title + "', year=" + year
                + ", available=" + available;
    }
}
