package other;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，里边可能包含“()”、"{}"、“[]”三种括号，请编写程序检查该字符串的括号是否成对出现
 * 输出：
 * true：代表括号成对出现并且嵌套正确，或字符串无括号字符
 * false：未正确使用括号字符
 * 示例：
 * 输入："()"
 * 输出：true
 * 输入："()[]{}"
 * 输出: true
 * 输入："([)]"
 * 输出：true
 * 输入："())"
 * 输出：false
 */
public class ByteDance2 {

    public static void main(String[] args) {
        String test = "()";
        System.out.println(solution(test));
    }

    public static boolean solution(String targetStr) {
        if (targetStr == null || targetStr.isEmpty()) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        Integer num1 = new Integer(0);
        map.put('(', num1);
        map.put(')', num1);
        Integer num2 = new Integer(0);
        map.put('[', num2);
        map.put(']', num2);
        Integer num3 = new Integer(0);
        map.put('{', num3);
        map.put('}', num3);
        for (char c : targetStr.toCharArray()) {
            if (!map.containsKey(c)) {
                continue;
            }
            Integer num = map.get(c);
            if (c == '(' || c == '{' || c == '[') {
                num = num + 1;
            } else {
                num = num - 1;
                if (num < 0) {
                    return false;
                }
            }
        }
        return num1 == 0 && num2 == 0 && num3 == 0;
    }

}
