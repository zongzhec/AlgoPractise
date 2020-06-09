package foo.zongzhe.data_structure.line.linked_list;

import foo.zongzhe.data_structure.common.HeroNode;

public class CircleLinkedList extends LinkedList {

    public CircleLinkedList() {
        super();
        listDesc = "CircleLinkedList";
    }

    @Override
    public void add(HeroNode newHero) {
        super.add(newHero);
        lastNode.next = headNode.next; // 去掉头节点
    }

    @Override
    public void showList() {
        if (isEmpty()) {
            System.out.println(listDesc + " is empty, unable to show records");
        } else {
            System.out.println("Iterating " + listDesc);
            HeroNode currentNode = headNode.next;
            do {
                System.out.println(currentNode);
                currentNode = currentNode.next;
            }while (currentNode != headNode.next);

        }
    }

    @Override
    public LinkedList reverse() {
        LinkedList reversedList = new CircleLinkedList();
        HeroNode currentNode = headNode.next;
        HeroNode nextNode = null;
        while (currentNode != headNode) {
            // 记录下一个节点备用
            nextNode = currentNode.next;
            // 重新绑定关联
            currentNode.next = reversedList.headNode.next;
            // 附加在新链表上
            reversedList.headNode.next = currentNode;
            currentNode = nextNode;
        }
        reversedList.lastNode.next = reversedList.headNode.next;
        return reversedList;
    }
}
