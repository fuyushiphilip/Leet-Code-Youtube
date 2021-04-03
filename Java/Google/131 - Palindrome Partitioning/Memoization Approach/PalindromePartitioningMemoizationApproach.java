public class PalindromePartitioningMemoizationApproach {
    public List<List<String>> partition(String s) {
        if (s.isEmpty()) return new ArrayList<>();

        return partition(0, s, new List[s.length() + 1]);
    }

    private List<List<String>> partition(int i, String s, List<List<String>>[] memo) {
        if (memo[i] != null) return memo[i];

        List<List<String>> result = new ArrayList<>();

        if (i >= s.length()) {
            result.add(new ArrayList<>());
            return result;
        }

        StringBuilder str = new StringBuilder();

        for (int j = i; j < s.length(); j++) {
            str.append(s.charAt(j));

            if (isPalindrome(s, i, j)) {
                List<List<String>> partitions = partition(j + 1, s, memo);

                for (List<String> par: partitions) {
                    List<String> partition = new ArrayList<>();
                    partition.add(str.toString());
                    partition.addAll(par);
                    result.add(partition);
                }
            }
        }

        return memo[i] = result;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }

        return true;
    }
}