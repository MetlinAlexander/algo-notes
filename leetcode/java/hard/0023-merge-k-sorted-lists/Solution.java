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
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;        
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = (l1 != null) ? l1 : l2;
        return dummyHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        int interval = 1;
        while(interval < lists.length){
            for(int i = 0; i + interval < lists.length; i += interval * 2){
                lists[i] = merge(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
    
}