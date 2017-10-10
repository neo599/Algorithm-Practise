import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String [] wordList = new String[] {"hot","dot","dog","lot","log", "cog"};

        System.out.println(Arrays.asList(findLadders(beginWord, endWord, Arrays.asList(wordList))));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        if (beginWord == null || endWord == null
                || beginWord.length() == 0 || endWord.length() == 0
                || beginWord.length() != endWord.length()
                || !words.contains(endWord)) {
            return Collections.emptyList();
        }

        Map<String, List<List<String>>> routesMap = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        List<List<String>> startList = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        startList.add(path);
        routesMap.put(beginWord, startList);

        while (!q.isEmpty()) {
            int qSize = q.size();

            Map<String, List<List<String>>> levelMap = new HashMap<>();

            for (int i = 0; i < qSize; i++) {
                String current = q.poll();
                for (int j = 0; j < current.length(); j++) {
                    char[] strCharArry = current.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        strCharArry[j] = c;

                        String temp = new String(strCharArry);

                        if (words.contains(temp) && !routesMap.containsKey(temp)) {

                            List<List<String>> existingRoutes = levelMap.get(temp);
                            if (existingRoutes == null) {
                                existingRoutes = new ArrayList<>();
                                q.offer(temp);
                                levelMap.put(temp, existingRoutes);
                            }

                            List<List<String>> preRoutes = routesMap.get(current);
                            for (List<String> route : preRoutes) {
                                List<String> tempRoute = new ArrayList<>(route);
                                tempRoute.add(temp);
                                existingRoutes.add(tempRoute);
                            }
                        }
                    }
                }
            }
            routesMap.putAll(levelMap);
            if (routesMap.containsKey(endWord)) {
                return routesMap.get(endWord);
            }
        }
        return Collections.emptyList();
    }
}
