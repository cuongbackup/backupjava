package model;

public enum Enum {
    Experience(0),
    Fresher(1),
    Intern(2);

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private Enum(int value) {
        this.value = value;
    }
}
