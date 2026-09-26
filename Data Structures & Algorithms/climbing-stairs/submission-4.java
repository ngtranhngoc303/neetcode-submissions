class Solution {
    public int climbStairs(int n) {
        if(n<=1)
            return n;
        int curr = 1;
        int pre = 1;
        int next;
        for(int i = 1; i < n; i++){
            next = curr + pre;
            pre = curr;
            curr = next;
        }
        return curr;
    }
}
