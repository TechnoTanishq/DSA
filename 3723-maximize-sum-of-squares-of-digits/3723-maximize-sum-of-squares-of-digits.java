class Solution {

    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }
        int r = sum % 9;

        StringBuilder sb = new StringBuilder();
        int nines = sum / 9;
        for (int i = 0; i < nines; i++) {
            sb.append('9');
        }
        if (r > 0) {
            sb.append((char) ('0' + r));
        }
        int zeros = num - sb.length();
        for (int i = 0; i < zeros; i++) {
            sb.append('0');
        }
        return sb.toString();
    }
}