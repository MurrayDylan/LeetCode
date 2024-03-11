class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        Solution sol = new Solution();
        ListNode ret = sol.addTwoNumbers(l1, l2);

        while(ret != null) {
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        ListNode curr = ret;
        int carry = 0;

        while((l1 != null) || (l2 != null)) {
            int l1Val = (l1 == null ? 0 : l1.val);
            int l2Val = (l2 == null ? 0 : l2.val);

            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry > 0){
            curr.next = new ListNode(carry);
        }

        return ret.next;
    }
}