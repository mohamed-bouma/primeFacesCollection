package fr.collection.primefacescollection.outils;

public class OutilsInteger {

    public static boolean isNotInteger(String s) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') return false;
            if(s.charAt(i) == '1') return false;
            if(s.charAt(i) == '2') return false;
            if(s.charAt(i) == '3') return false;
            if(s.charAt(i) == '4') return false;
            if(s.charAt(i) == '5') return false;
            if(s.charAt(i) == '6') return false;
            if(s.charAt(i) == '7') return false;
            if(s.charAt(i) == '8') return false;
            if(s.charAt(i) == '9') return false;
        }
        return true;

    }

}
