import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode teap = new ListNode();
        ListNode[] tail = {teap};

        Stream.generate(new DigitSupplier(l1, l2))
                .takeWhile(Objects::nonNull)
                .forEach(node -> {
                    tail[0].next = node;
                    tail[0] = node;
                });

        return teap.next;
    }

    private static class DigitSupplier implements Supplier<ListNode> {
        private ListNode l1;
        private ListNode l2;
        private int carry;

        DigitSupplier(ListNode l1, ListNode l2) {
            this.l1 = l1;
            this.l2 = l2;
        }

        @Override
        public ListNode get() {
            if (l1 == null && l2 == null && carry == 0) {
                return null;
            }

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            return new ListNode(sum % 10);
        }
    }
}
