package Heap;
/*
23. 合并K个升序链表 hard 55 93 时间复杂度较高
给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。



示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：

输入：lists = []
输出：[]
示例 3：

输入：lists = [[]]
输出：[]


提示：

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4
 */
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class Solution_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode x:lists){
            if(x==null)
                continue;
            ListNode curr = x;
            heap.add(x);
            while(curr.next!=null) {
                heap.add(curr.next);
                curr=curr.next;
            }
        }
        ListNode result=new ListNode(0);
        ListNode curr = result;
        while(!heap.isEmpty()){
            curr.next = new ListNode(heap.poll().val);
            curr = curr.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next=new ListNode(4);
        a.next.next=new ListNode(5);
        ListNode b = new ListNode(1);
        b.next=new ListNode(3);
        b.next.next=new ListNode(4);
        ListNode c = new ListNode(2);
        c.next=new ListNode(6);
        ListNode[] arr = {a,b,c};
        Solution_23 test = new Solution_23();
        test.mergeKLists(arr);
    }
}
