package model;

/** Contract for anything that can be lent out. */
public interface Borrowable {
    boolean isAvailable();

    void borrow();

    void giveBack();
}
