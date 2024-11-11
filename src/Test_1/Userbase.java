package Test_1;

import java.util.*;

public class Userbase {
    private ArrayList<User> users;

    public Userbase() {

        users = new ArrayList<>();
    }

    public void addUser(User u) throws IndexOutOfBoundsException{
        //check if user exists
        if(users.contains(u)){
            throw new IndexOutOfBoundsException("User exists");
        }
        users.add(u);
    }


    //may Aperon be with me
    //code written by a moldavian
    public Map<User, List<String>> byProgrammingLang(){
        HashMap<User,List<String>> hashMap = new HashMap<>();
        for(User u : users){
            hashMap.put(u,u.getProgrammingLanguages());
        }
        return hashMap;
    }

    public Map<String, List<User>> byUsers(){
        Map<String,List<User>> hashMap = new HashMap<>();
        for(User u : users){
            for(String pl : u.getProgrammingLanguages()){
                // check if there is already that programming language in the hash map:
                if(hashMap.containsKey(pl)){
                    hashMap.get(pl).add(u);
                }
                else{
                    hashMap.put(pl,new ArrayList<>());
                    hashMap.get(pl).add(u);
                }
            }
        }
        return hashMap;
    }

}
