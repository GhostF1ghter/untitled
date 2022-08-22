import new_game.ListNode;

public  class  Solution {
    //        public Solution(){};
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int inMind = 0;
        ListNode previous = null;
        ListNode current = null;
        ListNode result = null;
        while (true) {
            /*
      +      Выделяем место в уме на одну цифру, она может быть 0 или 1. Сначала она 0.
      +      Выделяю место для предыдущего числа, чтобы потом связать их с текущим.
     +       Выделяю место для текущего числа.
      +      Беру два числа.
     +       Создаю число суммы.
      +      Прибавляю цифру из ума к сумме.
     +       Обнуляю цифру из ума.
      +      К сумме добавляю числа.
     +       Если сумма больше 9, то цифра из ума равна 1.
      +      Сумма равна остаток от деления суммы на 10.
      +      Записываю сумму в текущее число.

       +     Если предыдущее число не пустое , тогда у предыдущего числа поставить следующее текущим.
       +     Предыдущее число = текущее число.
       +     Если цифра из ума равна 0 и следующее число l1, l2 оба равны null, тогда заканчиваю.
            Иначе повторяю.
             */

            int first = l1 != null ? l1.val : 0;
            int second = l2 != null ? l2.val : 0;
            int sum = first + second + inMind;
            inMind = sum/10 > 0 ? 1 : 0;

            current = new ListNode(sum%10);

            if (previous != null) {
                previous.next = current;
            }

            previous = current;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            if (result == null) {
                result = current;
            }

            if (inMind == 0 && l1 == null && l2 == null ){
                break;
            }



        }
            return result;
    }
    public  String listNodeToString(ListNode listNode, String result) {

        result = result + listNode.val;
        if (listNode.next != null) {
            return listNodeToString(listNode.next, result);
        } else {
            return result;
        }
    }

    public  boolean listNodeEquals(ListNode listNode,ListNode listNode1){
        String result1 = "";
        String result2 = "";


        return listNodeToString(listNode,result1).equalsIgnoreCase(listNodeToString(listNode1,result2));
    }
}
