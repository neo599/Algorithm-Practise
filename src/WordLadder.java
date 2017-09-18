/*******************************************
 * 经典的BFS题目。
 * 想象一下，这个变换过程是一个树，
 * 每一层是当前所有的变换结果 ，
 * 下一层又是上一层的字符串的所有的变换结果。
 * 例子：HIT
 * AIT, BIT, CIT, DIT.....
 * HAT, HBT, HCT, HDT.....
 * HIA, HIB, HIC, HID....
 * HIT 可以有这么多种变换方式，
 * 而AIT, BIT本身也可以以相同的方式展开，
 * 这就形成了一个相当大的树。
 *
 * 最直观的思路就是DFS，每次变成字典中的某个新单词，
 * 同时从字典中删除这个单词然后不断递归。
 * 但是大数据时候超时。因为要求的是最短的变换次数，
 * 所以可以使用BFS，和DFS不一样不一次走到最深。
 * 逐层遍历变换了一次、二次、三次、n次的所有单词。
 *
 * 思考一下DFS和BFS的区别，举个最简单的例子，111 -> 311。
 * DFS的话，111->112，之后需要DFS 112的所有变形。
 * 同理111->113之后还要遍历113的所有变形。
 * 而BFS的话，                      111
 112  113 121 131  211  311
 *只需要6次就能找到最终结果。
 * ***************************************/

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String [] wordList = new String[] {"hot","dot","dog","lot","log"};

        System.out.println(ladderLength(beginWord, endWord, Arrays.asList(wordList)));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        if (beginWord == null || endWord == null
                || beginWord.length() == 0 || endWord.length() == 0
                || beginWord.length() != endWord.length()
                || !words.contains(endWord)) {
            return 0 ;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();
            level++;

            for (int i = 0; i < qSize; i++) {
                String current = q.poll();
                for (int j = 0; j < current.length(); j++) {
                    char[] stringChar = current.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        stringChar[j] = c;

                        String temp = new String(stringChar);

                        if (endWord.equals(temp)) {
                            return level + 1;
                        }

                        if (words.contains(temp) && !visited.contains(temp)) {
                            visited.add(temp);
                            q.offer(temp);
                        }
                    }
                }
            }
        }
        return 0;

    }
}
