package exception;

public final class ItemNotFoundException extends LibraryException {
    public ItemNotFoundException(String itemId) {
        super("Library item not found: " + itemId);
    }
}
