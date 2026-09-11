class Solution {

    public void find(int num, int[] counter, List<Integer> cur,
                     int[] digits, boolean[] used, Set<Integer> set) {

        if(cur.size() == 3) {
            set.add(num);
            return;
        }

        for(int i = 0; i < digits.length; i++) {

            //already used
            if(used[i]) continue;

            //first digit cannot be 0
            if(cur.size() == 0 && digits[i] == 0)
                continue;

            //last digit must be even
            if(cur.size() == 2 && digits[i] % 2 != 0)
                continue;

            //pick
            used[i] = true;
            cur.add(digits[i]);
            num = num * 10 + digits[i];

            //explore
            find(num, counter, cur, digits, used, set);

            //unpick
            num = num / 10;
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }

    public int totalNumbers(int[] digits) {

        int[] counter = new int[1];

        ArrayList<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[digits.length];

        Set<Integer> set = new HashSet<>();

        find(0, counter, cur, digits, used, set);

        return set.size();
    }
}