package com.challenges.datastructures.strings;

import java.util.Stack;

public class ValidParan {

    private class StackNode{
        char c;
        int idx;
        StackNode(char c, int idx){
            this.c = c;
            this.idx = idx;
        }
    }

    public String removeParan(String s){

        char[] st = s.toCharArray();
        Stack<StackNode> stack = new Stack<>();
        for (int i =0 ; i < st.length ; i ++) {
            if (st[i] == '(') {
                stack.push(new StackNode('(', i));
            } else if (st[i] == ')') {
                if (stack.isEmpty()) {
                    st[i]=' ';
                } else {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
                st[stack.pop().idx] = ' ';
        }

        String s1 = new String(st);
        return s1.replaceAll(" ","");
    }

    public static void main(String[] args) {
        ValidParan vp = new ValidParan();

        System.out.println(vp.removeParan("ab(a(c)fg)9)"));
        System.out.println(vp.removeParan(")a(b)c()("));
        System.out.println(vp.removeParan(")("));
    }
}
