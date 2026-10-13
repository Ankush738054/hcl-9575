package exception;

public final class BorrowLimitExceededException extends LibraryException {
    public BorrowLimitExceededException(String memberId) {
        super("Member " + memberId + " has reached their borrowing limit");
    }
}
