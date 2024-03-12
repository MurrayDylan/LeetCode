import java.util.HashMap;
class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String ret = sol.customSortString("exv", "xwvee");
        System.out.println(ret);
    }
    public String customSortString(String order, String s) {
        HashMap<String, Integer> orderMap = new HashMap();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put((order.charAt(i) + ""), i);
        }

        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            String toAdd = s.charAt(i) + "";
            ret = addSelfToString(ret, toAdd, orderMap);
        }
        return ret;
    }

    private String addSelfToString(String s, String toAdd, HashMap<String, Integer> order) {
        if(s.isEmpty()) return toAdd;
        String ret = "";
        if(order.containsKey(toAdd)) {
            int toAddVal = order.get(toAdd);

            for(int i = s.length()-1; i >= 0; i--) {
                String curr = s.charAt(i) + "";
                String next = "";
                if (i > 0) {
                    next = s.charAt(i-1) + "";
                }
                if(order.containsKey(curr)) {
                    int val = order.get(curr);
                    if(val >= toAddVal && ( next.isEmpty() || order.get(next) < toAddVal)) {
                        int pos = s.indexOf(s.charAt(i));
                        if(s.length() == 1) {
                            ret = toAdd + s;
                        } else {
                            String firstHalf = s.substring(0, pos);
                            String secondHalf = s.substring(pos);
                            ret = firstHalf + toAdd + secondHalf;
                        }
                        return ret;
                    }
                }
            }
        } else {
            ret = s + toAdd;
        }
        return ret;
    }
}