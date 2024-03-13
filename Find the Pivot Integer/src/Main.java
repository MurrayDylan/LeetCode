class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ret = sol.pivotInteger(8);
        System.out.println(ret);

    }
    public int pivotInteger(int n) {
        if(n <= 0) return -1;
        int midPoint = getMidPoint(n);

        for(int i = midPoint; i <= n; i++) {
            if(checkPivot(i, n)) {
                return i;
            }
        }
        return -1;
    }

    private static int getMidPoint(int n) {
        return n / 2; //don't need to check if n is positive
    }

    private static boolean checkPivot(int pivot, int n) {
        int firstHalf = 0;
        for(int i = 0; i <= pivot; i++) firstHalf += i;

        int secondHalf = 0;
        for(int i = pivot; i <= n; i++) secondHalf += i;

        if(firstHalf == secondHalf) {
            return true;
        } else return false;
    }
}