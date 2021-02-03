import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int start = 0;
        int end = start + k;
        Map<String, Integer> map = new HashMap<>();
        String subString = s.substring(start, end);
        int maxRepeatNum = 0;
        for (char c : subString.toCharArray()) {

        }
    }

    public int getMaxRepeatNumOfString(String s){

    }
}
