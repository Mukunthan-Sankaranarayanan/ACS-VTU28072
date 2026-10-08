class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] count = new int[26];

            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }

            StringBuilder key = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                key.append('#');
                key.append(count[i]);
            }

            map
                .computeIfAbsent(
                    key.toString(),
                    k -> new ArrayList<>()
                )
                .add(str);
        }

        return new ArrayList<>(map.values());
    }
}
