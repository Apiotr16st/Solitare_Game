package org.example.card;

public enum Color {
    PIK(1),
    KIER(2),
    TREFL(3),
    KARO(4);

    private final int i;
    Color(int i)  {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
