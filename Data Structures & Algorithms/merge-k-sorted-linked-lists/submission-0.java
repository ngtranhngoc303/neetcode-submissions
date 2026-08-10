/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        int interval = 1;

        while(interval < lists.length){
            for(int i = 0; i + interval < lists.length; i += interval * 2){
                lists[i] = mergeTwoList(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
    private ListNode mergeTwoList(ListNode list1, ListNode list2){
            if(list1 == null){
                return list2;
            }
            if(list2 == null){
                return list1;
            }
            if(list1.val <= list2.val){
                list1.next = mergeTwoList(list1.next, list2);
                return list1;
            }
            else{
                list2.next = mergeTwoList(list1, list2.next);
                return list2;
            }
        }
}
