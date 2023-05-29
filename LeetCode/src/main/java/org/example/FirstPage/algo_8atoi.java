package org.example.FirstPage;

import java.util.HashMap;
import java.util.Map;

public class algo_8atoi {

    enum State{
        start,
        signed,
        in_number,
        end
    }

    enum CharType{
        nullChar,
        sign,
        number,
        other
    }
    static final int INT_MIN = (int) (Math.pow(2, 31) * (-1));
    static final int INT_MAX = (int) (Math.pow(2, 31)) - 1;

    public static int isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();

        // 1.
        Map<CharType, State> StartMap = new HashMap<CharType, State>() {{
            put(CharType.nullChar, State.start);
            put(CharType.sign, State.signed);
            put(CharType.number, State.in_number);
        }};
        transfer.put(State.start, StartMap);

        // 2.
        Map<CharType, State> SignMap = new HashMap<CharType, State>() {{
            put(CharType.number, State.in_number);
        }};
        transfer.put(State.signed, SignMap);

        // 3.
        Map<CharType, State> in_numberMap = new HashMap<CharType, State>() {{
            put(CharType.number, State.in_number);
            put(CharType.nullChar, State.end);
            put(CharType.sign, State.end);
            put(CharType.other, State.end);
        }};
        transfer.put(State.in_number, in_numberMap);

        // 4.
        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            put(CharType.nullChar, State.end);
            put(CharType.sign, State.end);
            put(CharType.number, State.end);
            put(CharType.other, State.end);

        }};
        transfer.put(State.end, endMap);


        int length = s.length();
        State state = State.start;
        StringBuilder sb  = new StringBuilder();
        int flag = 0;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return -1;
            } else {
                state = transfer.get(state).get(type);
                if(state == State.in_number ){
                    sb.append(s.charAt(i));
                }
                if(state == State.signed ){
                    flag = s.charAt(i) == '-' ? -1 : 1;
                }
            }
        }

        if(state == State.in_number || state == State.end) {
            int res = 0;

            for (int i = 0; i < sb.length(); i++) {
                int temp = sb.charAt(i) - '0';
                res = res * 10 + temp;
            }

            if (res * flag < INT_MIN) return INT_MIN;
            else if (res * flag > INT_MAX) return INT_MAX;
            else return flag * res;
        }
        return -1;

    }

    public static CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') return CharType.number;
        else if (ch == '+' || ch == '-') return CharType.sign;
        else if (ch == ' ') return CharType.nullChar;
        else return CharType.other;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("42"));
    }
}

