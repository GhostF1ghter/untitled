package TasksFromLeetCode;

import TasksFromLeetCode.ListNode;

public class Digits {
    /*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
    order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.*/


    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode2 = new ListNode(4, listNode);
        ListNode listNode3 = new ListNode(2, listNode2);

        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(6, listNode4);
        ListNode listNode6 = new ListNode(5, listNode5);

        ListNode listNode7 = new ListNode(8);
        ListNode listNode8 = new ListNode(0, listNode7);
        ListNode listNode9 = new ListNode(7, listNode8);


        Solution solution = new Solution();
        ListNode listNode10 = solution.addTwoNumbers(listNode3, listNode6);
//        System.out.println(listNode10);


        String result = "";
        System.out.println(solution.listNodeToString(listNode10, result));

        System.out.println(solution.listNodeEquals(listNode10, listNode9));




    }




}


