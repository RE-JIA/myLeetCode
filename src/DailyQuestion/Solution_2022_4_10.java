package DailyQuestion;

import java.util.HashSet;
import java.util.Set;

public class Solution_2022_4_10 {
    String[] wordsTable = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
            ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words){
        Set<String> set = new HashSet<>();
        StringBuffer tmp;
        for(String word : words){
            tmp = new StringBuffer();
            for (int i = 0; i < word.length(); i++) {
                tmp.append(wordsTable[word.charAt(i) - 'a']);
            }
            set.add(tmp.toString());
        }
        return set.size();
    }
}
