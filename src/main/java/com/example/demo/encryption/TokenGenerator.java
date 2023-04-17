package com.example.demo.encryption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Create 2022/5/24 By Gq
 */
public class TokenGenerator {

    // 本地进制
//    private static final String LOCAL_SCALE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
    private static final String LOCAL_SCALE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
    // 词典映射
//    private static final String DICTIONARY = "nB1lpXCAe2JFHg4ja_3GQMrmKuqZfI0kbR6VEs8SNUow-9WLt7PyiDvc5xhzTOdY";
    private static final String DICTIONARY = "01QRSTUOPX648FW_BKLM9NYZ-AV5JD723CHIGE";
    private static final int FIX_WIDTH = 18;
    private static final int VALUE_COUNT = 3;
    private static final long EXPIRE_TIME = 3600 * 72;

    public static String createToken(int id) {
        return create(id, (int) (Math.random() * 100));
    }

    private static String create(int id, int val) {
        if (id < 1L) {
            return null;
        }
        StringBuilder sessionId = new StringBuilder();
        long createTime = System.currentTimeMillis();
        String ctLocal = transToLocal(createTime);
        sessionId.append(genUnit(ctLocal));
        String ltLocal = transToLocal(val);
        sessionId.append(genUnit(ltLocal));
        String uidLocal = transToLocal(id);
        sessionId.append(genUnit(uidLocal));
        String random = additional(FIX_WIDTH - sessionId.length() - 2);
        sessionId.append(genUnit(random));
        String verifyLocal = transToLocal(getVerifyCode(sessionId.toString()));
        sessionId.append(verifyLocal);

        return encode(switchPos(sessionId.toString()));
    }

    private static String genUnit(String val) {
        char prefix = LOCAL_SCALE.charAt(val.length());
        return prefix + val;
    }

    private static String additional(int length) {
        StringBuilder add = new StringBuilder();

        for(Random random = new Random(); length > 0; --length) {
            int index = random.nextInt(LOCAL_SCALE.length());
            add.append(LOCAL_SCALE.charAt(index));
        }

        return add.toString();
    }

    public static int explain(String tokenStr) {
        if (tokenStr == null) {
            return -1;
        }
        tokenStr = tokenStr.trim();
        int length = tokenStr.length();
        if (length < FIX_WIDTH || !isLocalScale(tokenStr)) {
            return -1;
        }
        tokenStr = switchPos(decode(tokenStr));
        long verifyCode = transToLong(tokenStr.substring(length - 1));
        if (verifyCode != getVerifyCode(tokenStr.substring(0, length - 1))) {
            return -1;
        }
        List<String> vals = split(tokenStr);
        if (vals.isEmpty()) {
            return -1;
        }
        return (int) transToLong(vals.get(0));
    }

    private static List<String> split(String sessionId) {

        List<String> list = new ArrayList<>();
        int startIdx = 0;

        for(int cnt = 0; cnt < VALUE_COUNT; ++cnt) {
            int bitLen = LOCAL_SCALE.indexOf(sessionId.charAt(startIdx));
            if (bitLen == 0) {
                list.add("");
                ++startIdx;
            } else {
                int endIdx = startIdx + bitLen + 1;
                if (endIdx > sessionId.length()) {
                    return Collections.emptyList();
                }

                String value = sessionId.substring(startIdx + 1, endIdx);
                list.add(value);
                startIdx = endIdx;
            }
        }

        return list;
    }

    private static String encode(String val) {
        return getString(val, LOCAL_SCALE, DICTIONARY);
    }

    private static String decode(String val) {
        return getString(val, DICTIONARY, LOCAL_SCALE);
    }

    private static String getString(String val, String form, String to) {
        StringBuilder ret = new StringBuilder();

        for(int j = val.length(), i = 0; i < j; ++i) {
            int index = form.indexOf(val.charAt(i));
            ret.append(to.charAt(index));
        }

        return ret.toString();
    }

    private static String transToLocal(long val) {
        int length = LOCAL_SCALE.length();
        StringBuilder num = new StringBuilder();

        long div;
        do {
            div = val / (long)length;
            int remain = (int)(val % (long)length);
            val = div;
            num.append(LOCAL_SCALE.charAt(remain));
        } while(div != 0L);

        return num.reverse().toString();
    }

    private static long transToLong(String val) {
        long num = 0L;
        int length = LOCAL_SCALE.length();
        int i = 0;

        for(int j = val.length(); i < j; ++i) {
            long base = (long)Math.pow(length, j - i - 1);
            int multiple = LOCAL_SCALE.indexOf(val.charAt(i));
            num += (long)multiple * base;
        }

        return num;
    }

    private static String switchPos(String val) {
        StringBuilder first = new StringBuilder();
        StringBuilder last = new StringBuilder();
        int index = val.length() / 3;
        if (index < 1) {
            index = 1;
        }

        first.append(val, 0, index);
        last.append(val.substring(index));
        return first.reverse().append(last.reverse()).toString();
    }

    private static boolean isLocalScale(String val) {
        if (val == null) {
            return false;
        } else {
            return val.matches("[" + LOCAL_SCALE.replaceAll("-", "\\\\\\-") + "]*");
        }
    }

    private static long getVerifyCode(String val) {
        long code = 0L;
        long scal = LOCAL_SCALE.length();
        int i = 0;

        for(int len = val.length(); i < len; ++i) {
            code += transToLong(val.substring(i, i + 1)) * (long)i * (scal - 1L);
        }

        return code % scal;
    }

    public static void main(String[] args) {
        String token = createToken(5);
        System.out.println(token);
        System.out.println(explain(token));
    }
}
