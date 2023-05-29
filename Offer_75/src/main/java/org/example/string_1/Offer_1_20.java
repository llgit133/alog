package org.example.string_1;

import java.util.HashMap;
import java.util.Map;

public class Offer_1_20 {
    // 10种状态
    // 当前处理到字符串的哪个部分、当作状态的表述
    enum State{
        STATE_INITIAL,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WITHOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUMBER,
        STATE_END
    }

    // 5种字符类型+不合法类型
    enum CharType{
        CHAR_NUMBER,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_SPACE,
        CHAR_ILLEGAL
    }

    public static boolean isNumber(String s) {

        // 当前状态、当前状态的下一个状态集合
        // key:State   value:Map
        Map<State, Map<CharType, State>> transfer = new HashMap<>();

        // 1.STATE_INITIAL  起始的空格
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_INITIAL);
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);

        // 2.STATE_INT_SIGN  符号位
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);

        // 3.STATE_INTEGER  整数部分
        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_INTEGER, integerMap);

        // 4.STATE_POINT  左侧有整数的小数点
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_POINT, pointMap);

        // 5.STATE_POINT_WITHOUT_INT 左侧无整数的小数点
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);

        // 6.STATE_FRACTION 小数部分
        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);

        // 7.STATE_EXP  字符e
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);

        // 8.STATE_EXP_SIGN  指数部分的符号位

        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        // 9.STATE_EXP_NUMBER 指数部分的整数部分
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        // 10.STATE_END  末尾的空格
        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_END, endMap);



        // 可以把这个数搞出来
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        // 先设置初状态
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {

            //toCharType(s.charAt(i));    返回5种类型的一种
            //type 字符i的类型
            CharType type = toCharType(s.charAt(i));

            // 看当前状态的下一个状态是否有 type
            // 没有 直接返回false
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                // 迭代state
                state = transfer.get(state).get(type);
            }
        }



        // 处理到尾部了、判断
        // STATE_INTEGER整数部分
        // STATE_POINT 左侧有整数的小数点
        // STATE_FRACTION小数部分
        // STATE_EXP_NUMBER指数部分的整数部分
        // STATE_END末尾的空格
        return  state == State.STATE_INTEGER ||
                state == State.STATE_POINT ||
                state == State.STATE_FRACTION ||
                state == State.STATE_EXP_NUMBER ||
                state == State.STATE_END;
    }


    public static  CharType toCharType(char ch) {
        // 逐个字符分析
        if (ch >= '0' && ch <= '9') return CharType.CHAR_NUMBER;
        else if (ch == 'e' || ch == 'E') return CharType.CHAR_EXP;
        else if (ch == '.') return CharType.CHAR_POINT;
        else if (ch == '+' || ch == '-') return CharType.CHAR_SIGN;
        else if (ch == ' ') return CharType.CHAR_SPACE;
        else return CharType.CHAR_ILLEGAL;
    }


    public static void main(String[] args) {
        System.out.println(isNumber("    .1  "));
    }
}
