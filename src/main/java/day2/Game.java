package day2;

import java.util.Collection;
import java.util.Objects;

public class Game {
    private final int id;
    private final Collection<Grabs> grabs;

    public Game(int id, Collection<Grabs> grabs) {
        this.id = id;
        this.grabs = grabs;
    }

    public boolean satisfies(int red, int green, int blue) {
        return grabs.stream().allMatch(g -> g.satisfies(red, green, blue));
    }

    public int getId() {
        return id;
    }

    public Grabs getMinimalSet() {
        return new Grabs(grabs.stream().mapToInt(Grabs::getRed).max().orElse(0),
                grabs.stream().mapToInt(Grabs::getGreen).max().orElse(0),
                grabs.stream().mapToInt(Grabs::getBlue).max().orElse(0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && Objects.equals(grabs, game.grabs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, grabs);
    }
}
