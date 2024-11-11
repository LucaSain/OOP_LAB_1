package Test_1;

import java.util.*;

public class User {
    private final String name;
    private final String email;
    private final ArrayList<Challenge> challenges;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
        challenges = new ArrayList<Challenge>();
    }

    public void addChallenge(Challenge challenge) throws IndexOutOfBoundsException{
        if(challenges.contains(challenge)){
            throw new IndexOutOfBoundsException("Duplicate challenge for this user");
        }
        challenges.add(challenge);
    }

    public ArrayList<Challenge> getChallenges(Comparator< ? super Challenge> comparator) {
        challenges.sort(comparator);
        return challenges;
    }

    public List<String> getProgrammingLanguages(){
        return challenges.stream().map(Challenge::language).toList();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
