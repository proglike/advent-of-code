package day2;

import java.util.Objects;

public class Grabs {

    private final int red;
    private final int green;
    private final int blue;

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public Grabs(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public boolean satisfies(int red, int green, int blue) {
        return this.red <= red &&
                this.green <= green &&
                this.blue <= blue;
    }

    public int getPower() {
        return red*green*blue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grabs grabs = (Grabs) o;
        return red == grabs.red && green == grabs.green && blue == grabs.blue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }
}
