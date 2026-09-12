class Solution {
    public boolean check(char ch, char last) {
        if (last == 'a') return ch == 'a' || ch == 'e';
        if (last == 'e') return ch == 'e' || ch == 'i';
        if (last == 'i') return ch == 'i' || ch == 'o';
        if (last == 'o') return ch == 'o' || ch == 'u';
        if (last == 'u') return ch == 'u';
        return false;
    }

    public int longestBeautifulSubstring(String word) {
        int n = word.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == 'a') {
                int start = i;
                int end = i + 1;
                char last = 'a';

                while (end < n) {
                    char curr = word.charAt(end);
                    if (check(curr, last)) {
                        last = curr;
                        end++;
                    } else {
                        break;
                    }
                }

          
                if (last == 'u') {
                    maxLen = Math.max(maxLen, end - start);
                }

               
                i = end - 1;
            }
        }

        return maxLen;
    }
}