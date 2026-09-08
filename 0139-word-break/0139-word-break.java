class Solution {
     Map<String, Integer> dp = new HashMap<>();

    int fun(int i, String s, Map<String, Integer> m1, String tmp) {

        if (i >= s.length()) {
            System.out.println(tmp);

            if (tmp.length() == 0)
                return 1;

            return 0;
        }

        String key = i + "+" + tmp;

        if (dp.containsKey(key))
            return dp.get(key);

        int m = 0;

        tmp += s.charAt(i);

        if (m1.containsKey(tmp)) {
            int a = fun(i + 1, s, m1, "");
            m = m | a;
        }

        int a = fun(i + 1, s, m1, tmp);
        m = m | a;

        dp.put(key, m);

        return m;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Map<String, Integer> m1 = new HashMap<>();

        for (String word : wordDict) {
            m1.put(word, m1.getOrDefault(word, 0) + 1);
        }

        dp.clear();

        return fun(0, s, m1, "") == 1;
    }
}