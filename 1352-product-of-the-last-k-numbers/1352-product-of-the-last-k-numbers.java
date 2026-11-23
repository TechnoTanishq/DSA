class ProductOfNumbers {
    ArrayList<Integer> prefix;
    ArrayList<Integer> list;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        list = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
        if (num == 0) {
            prefix.clear();
        } else if (prefix.size() == 0) {
            prefix.add(num);
        } else {
            prefix.add(num * prefix.get(prefix.size() - 1));
        }
    }

    public int getProduct(int k) {
        int n = prefix.size();
        if (k > n) {
            return 0;
        }
        int last = prefix.get(n - 1);
        if (k == n) {
            return last;
        }
        return last / prefix.get(n - k - 1);
    }
}