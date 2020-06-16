package com.challenges.datastructures.strings;

import java.util.HashMap;

public class StringPermutation {

    private boolean isPermutation(String first, String second){

        HashMap<Character, Integer> characterMap = new HashMap<>();
        int charCount;



        if((null == first && null == second)
                || ((null != first && first.isEmpty())
                && (null != second && second.isEmpty()))){
            return true;
        }

        if( null == first || first.isEmpty()
                || null == second || second.isEmpty()
                || (first.length() != second.length())) {
            return false;
        }

        //trim leading/trailing spaces??

        for(char c: first.toCharArray()){
            charCount = characterMap.containsKey(c) ? characterMap.get(c)+1 : 1;
            characterMap.put(c,charCount);
        }

        for(char c: second.toCharArray()){
            if(!characterMap.containsKey(c) ||  (characterMap.get(c) -1) < 0 ){
                return false;
            }
            characterMap.put(c, characterMap.get(c) -1);
        }

        return true;
    }

}
