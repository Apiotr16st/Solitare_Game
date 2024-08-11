package org.example.card;

public enum Number {
    KING(13),
    QUEEN(12),
    WALET(11),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    AS(1);

    private final int i;
    Number(int i)  {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
