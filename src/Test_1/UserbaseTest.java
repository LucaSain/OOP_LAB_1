package Test_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserbaseTest {
    private Userbase userbase;
    private ArrayList<User> users;

    @BeforeEach
    void setUp() {
        userbase = new Userbase();
        User u1 = new User("Ion","IonPookie@yahoo.com");
        User u2 = new User("Viviani", "parvan@stud.fils.upb.com");
        User u3 = new User("Viva la vida", "parvan@stud.fils.upb.com");
        users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);

        Challenge c1 = new Challenge("Unbreakable","This is not a fun challenge","Python", 10);
        Challenge c2 = new Challenge("Polihack","This is a fun challenge","Python", 2);
        Challenge c3 = new Challenge("Eestec Olympics","This challenge.","JavaScript", 33);
        ArrayList<Challenge> challenges = new ArrayList<>();
        challenges.add(c1);
        challenges.add(c2);
        challenges.add(c3);

        for(User u : users){
            for(Challenge c: challenges){
                u.addChallenge(c);
            }
            userbase.addUser(u);
        }
    }


    @Test
    void addUser(){
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> userbase.addUser(users.getFirst()) );
    }

    @Test
    void addChallenge(){

        assertThrowsExactly(IndexOutOfBoundsException.class, () -> users.getFirst().addChallenge(
             new Challenge("Unbreakable","This is not a fun challenge","Python", 10)
        ));
    }

    @Test
    void sortChallengesByDifficulty(){
        ArrayList<Challenge> challenges = users.getFirst().getChallenges(Challenge::byInt);
        assertEquals(2,challenges.getFirst().difficulty());
    }

    @Test
    void sortChallengesByName(){
        ArrayList<Challenge> challenges = users.getFirst().getChallenges(Challenge::byString);
        assertEquals("JavaScript",challenges.getFirst().language());
    }

    @Test
    void byProgrammingLang() {
        Map<String, List<User>> hashMap = userbase.byUsers();

        assertEquals(2,hashMap.size());
        assertEquals(6,hashMap.get("Python").size()); //we have two challenges for python per each user (3)
    }

    @Test
    void byUsers() {

        //checked
        Map<User, List<String>> hashMap = userbase.byProgrammingLang();

        assertEquals(hashMap.get(users.getFirst()),users.getFirst().getProgrammingLanguages());

    }
}