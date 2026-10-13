package exception;

public final class MemberNotFoundException extends LibraryException {
    public MemberNotFoundException(String memberId) {
        super("Library member not found: " + memberId);
    }
}
