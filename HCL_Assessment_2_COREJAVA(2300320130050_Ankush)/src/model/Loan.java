package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class Loan {
    private final long id;
    private final String itemId;
    private final String memberId;
    private final LocalDate checkoutDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;

    public Loan(long id, String itemId, String memberId, LocalDate checkoutDate, LocalDate dueDate) {
        this.id = id;
        this.itemId = itemId;
        this.memberId = memberId;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }

    public long getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public String getMemberId() {
        return memberId;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    public void close(LocalDate date) {
        if (isReturned()) {
            throw new IllegalStateException("Loan has already been returned");
        }
        if (date.isBefore(checkoutDate)) {
            throw new IllegalArgumentException("Return date cannot be before checkout date");
        }
        returnDate = date;
    }

    public BigDecimal calculateLateFee(LocalDate asOf, BigDecimal dailyRate) {
        LocalDate effectiveDate = returnDate == null ? asOf : returnDate;
        long daysLate = Math.max(0, ChronoUnit.DAYS.between(dueDate, effectiveDate));
        return dailyRate.multiply(BigDecimal.valueOf(daysLate));
    }
}
