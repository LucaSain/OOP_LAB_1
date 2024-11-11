package Test_1;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public record Challenge(String name, String description, String language, Integer difficulty) implements Comparable<Challenge> {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Challenge challenge = (Challenge) o;
        return Objects.equals(difficulty, challenge.difficulty) && Objects.equals(name, challenge.name) && Objects.equals(language, challenge.language) && Objects.equals(description, challenge.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, language, difficulty);
    }


    public int byInt(@NotNull Challenge o) {
        return difficulty.compareTo(o.difficulty);
    }

    public int byString(@NotNull Challenge o){
        return language.compareTo(o.language);
    }

    @Override
    public int compareTo(@NotNull Challenge o) {
        return byInt(o);
    }

}
