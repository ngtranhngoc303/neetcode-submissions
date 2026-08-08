class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()){
            return "";
        }
        int[] need = new int [128];
        for (char c : t.toCharArray()){
            need[c]++;
        }
        int left = 0;
        int right = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        while(right < s.length()){
            char charRight = s.charAt(right);
            if(need[charRight] > 0){
                count--;
            }
            need[charRight]--;
            right++;

            while(count == 0){
                if(right - left < minLen){
                    minLen = right - left;
                    startIndex = left;
                }

                char charLeft = s.charAt(left);
                need[charLeft]++;

                if(need[charLeft] > 0){
                    count++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
