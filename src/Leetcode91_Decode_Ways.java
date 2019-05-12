/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

采用动态规划，dp[i] = dp[i-1] + dp[i-2] // 单字符有效，双字符有效，比如单字符3，和上一个字符组合 23
                    = dp[i-1]  // 如果单字符有效，双字符无效，比如单字符3，和上一个字符组合33
                    = dp[i-2]  // 如果单字符无效，双字符有效，比如单字符0，和上一个字符组合10

有效： 1 <= xxx <= 26，并且十位数不能为0

* */
public class Leetcode91_Decode_Ways {

    public static void main(String[] args) {
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("012"));
        System.out.println(numDecodings("10086"));
        System.out.println(numDecodings("301"));
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
    }

    public static int numDecodings(String s) {
        int status[] = new int[s.length()];

        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        // 初始化
        int firstTwoNum = Integer.parseInt(s.substring(0, 2));
        status[0] = 1;
        if (1 <= firstTwoNum && firstTwoNum <= 26) {
            status[1] = firstTwoNum % 10 == 0 ? 1 : 2;  // 10 只有一种，但是11,12,13这些都有2种
        } else {
            status[1] = firstTwoNum % 10 == 0 ? 0 : 1;// 27   89 这些就只有一种, 30，40 这些就是0种
        }

        for (int i = 2; i < s.length(); i++) {
            // s[i] = s[i-1]（单个字符有效的情况） + s[i-2]（2个字符有效的情况），

            // 单个字符有效
            if (s.charAt(i) - '0' >= 1 && s.charAt(i) - '0' <= 9) {
                status[i] += status[i - 1];
            }

            // 两个字符有效
            int tmpNum = Integer.parseInt(s.substring(i - 1, i + 1));
            if (1 <= tmpNum && tmpNum <= 26 && s.charAt(i - 1) - '0' != 0) {
                status[i] += status[i - 2];
            }
        }
        return status[s.length() - 1];
    }
}
