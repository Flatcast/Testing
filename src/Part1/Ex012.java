package Part1;

import java.util.HashMap;
public class Ex012 {
    public static void main(String[] args) {
       HashMap<String,String> statesCapital = new HashMap<>();
       statesCapital.put("Canada","Toronto");
       statesCapital.put("Iraq","Baghdad");
       statesCapital.put("Austria","Wien");
       System.out.println(statesCapital);
       statesCapital.put("Canada","Ottawa");
       System.out.println(statesCapital);
    }
}


