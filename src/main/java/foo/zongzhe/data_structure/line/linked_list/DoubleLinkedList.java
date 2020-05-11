package foo.zongzhe.data_structure.line.linked_list;

/**
 * 双向链表
 */
public class DoubleLinkedList extends LinkedList {

    public DoubleLinkedList() {
        super();
        lastNode = new HeroNode(0, "dummyHeroName", "dummyNickName");
        headNode.next = lastNode;
        lastNode.prev = headNode;
        listDesc = "DoubleLinkedList";
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 默认添加在尾部
     *
     * @param newHero
     */
    @Override
    public void add(HeroNode newHero) {
        HeroNode prevNode = lastNode.prev;
        newHero.next = lastNode;
        newHero.prev = prevNode;
        prevNode.next = newHero;
        lastNode.prev = newHero;
        size++;
    }

    @Override
    public HeroNode getParentNode(HeroNode childNode) {
        HeroNode res = null;
        if (isEmpty()) {
            System.out.println(listDesc + " is empty, unable to get parent");
        } else {
            res = childNode.prev;
        }
        return res;
    }

    @Override
    public void remove(int heroNo) {
        if (isEmpty()) {
            System.out.println(listDesc + " is empty, unable to remove records");
        } else {
            HeroNode currentNode = headNode.next;
            while (currentNode != null) {
                if (currentNode.getNo() == heroNo) {
                    currentNode.next.prev = currentNode.prev;
                    currentNode.prev.next = currentNode.next;
                    break;
                } else {
                    currentNode = currentNode.next;
                }
            }
        }
        size--;
    }

    @Override
    public void showList() {
        if (isEmpty()) {
            System.out.println(listDesc + " is empty, unable to show records");
        } else {
            System.out.println("Iterating " + listDesc);
            HeroNode currentNode = headNode.next;
            while (currentNode != lastNode) {
                System.out.println(currentNode);
                currentNode = currentNode.next;
            }
        }
    }

    @Override
    public void replace(HeroNode newNode) {
        boolean updated = false;
        if (isEmpty()) {
            System.out.println(listDesc + " is empty, unable to update records");
        } else {
            HeroNode currentNode = headNode.next;
            while (currentNode != lastNode) {
                if (currentNode.getNo() == newNode.getNo()) {
                    currentNode.prev.next = newNode;
                    currentNode.next.prev = newNode;
                    newNode.next = currentNode.next;
                    newNode.prev = currentNode.prev;
                    updated = true;
                    break;
                }
            }
        }

        if (!updated) {
            System.out.println(listDesc + " is unable to find the node to replace");
        }
    }

    @Override
    public int getLength() {
        return size;
    }

    @Override
    public LinkedList reverse() {
        LinkedList reversedList = new DoubleLinkedList();
        reversedList.size = this.size;
        HeroNode currentNode = headNode.next;
        HeroNode nextNode = null;
        while (currentNode != lastNode) {
            // 记录下一个节点备用
            nextNode = currentNode.next;
            // 重新绑定关联
            currentNode.next = reversedList.headNode.next;
            currentNode.prev = reversedList.headNode;
            reversedList.headNode.next.prev = currentNode;
            reversedList.headNode.next = currentNode;
            // 附加在新链表上
            currentNode = nextNode;
        }
        return reversedList;
    }


}
