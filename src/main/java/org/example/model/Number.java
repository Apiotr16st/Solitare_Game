package org.example.model;

public enum Number {
    NONE(14),
    KING(13),
    QUEEN(12),
    JACK(11),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    ACE(1);

    private final int i;
    Number(int i)  {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
