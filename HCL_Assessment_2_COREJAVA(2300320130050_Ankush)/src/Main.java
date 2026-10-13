import model.Book;
import model.DVD;
import model.LibraryItem;
import model.Magazine;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int DEMO_DAYS_LATE = 3;

    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("Clean Code", 2008, "Robert C. Martin", "978-0132350884"));
        items.add(new Magazine("National Geographic", 2023, 10));
        items.add(new DVD("Inception", 2010, 148));

        System.out.println(buildReport(items));

        try {
            new Book("  ", 2000, "Nobody", "000");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
        try {
            new DVD("Too Old", 1800, 90);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }

    private static String buildReport(List<LibraryItem> items) {
        StringBuilder sb = new StringBuilder("--- Late fee for " + DEMO_DAYS_LATE + " days ---\n");
        for (LibraryItem item : items) {
            sb.append(item).append(" -> fee: ").append(item.lateFee(DEMO_DAYS_LATE)).append('\n');
        }
        return sb.toString();
    }
}
