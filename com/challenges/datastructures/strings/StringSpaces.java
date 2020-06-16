package com.challenges.datastructures.strings;

/*

Question: Pad the string such that spaces between words are equally distributed to match the padLength and if there are extra spaces, start adding the spaces from first word to last word.

Input:
string:"I am fine"
how many chars: 7
how many spaces that you need to fill: 4 (11 - 7)

padLength: 11
Output:”I<Space><Space>am<Space><Space>fine”

Input:
string:"I am fine"
padLength: 10
Output:”I<Space><Space>am<Space>fine”


string:"I            am fine"
padLength: 10
Output:”I<Space><Space>am<Space>fine”

String:A B C D
padlength: 8
output: A<S><S>B<S>C<S>D

 */

class StringSpaces {
    public static void main(String[] args) {

        System.out.println(padString(8, "A B C   D" ));
    }

    public static String padString(int n, String s){

        if( n < s.length()){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int charCount =0;
        int spaceCount=0;

        int  i =0;
        while(i< s.length()){

            if(Character.isLetter(s.charAt(i))){
                charCount++;

                if(i > 0  && Character.isWhitespace(s.charAt(i-1)))
                    spaceCount++;
            }

            i++;

        }


        int spacesNeeded = n - charCount;

        i=0;
        while(i< s.length()){
            if(Character.isLetter(s.charAt(i))){
                if(i > 0 && Character.isWhitespace(s.charAt(i-1))){
                    for(int j = 0; j < spacesNeeded/spaceCount ; j++){
                        sb.append(" ");
                    }

                }
                sb.append(s.charAt(i));
            }
            i++;
        }

        return sb.toString();
    }
}

