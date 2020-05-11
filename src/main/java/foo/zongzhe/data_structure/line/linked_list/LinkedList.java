package foo.zongzhe.data_structure.line.linked_list;

/**
 * 定义LinkedList来管理HeroNode
 */
public class LinkedList {

    public HeroNode headNode;
    public HeroNode lastNode;
    public String listDesc;
    public int size; // 以后加上

    public LinkedList() {
        headNode = new HeroNode(0, "dummyHeroName", "dummyNickName");
        headNode.next = null;
        lastNode = headNode;
        listDesc = "LinkedList";
        size = 0;
    }

    /**
     * 增加一个英雄
     *
     * @param newHero
     */
    public void add(HeroNode newHero) {
        lastNode.next = newHero;
        lastNode = newHero;
        size++;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * @param childNode
     * @return
     */
    public HeroNode getParentNode(HeroNode childNode) {
        HeroNode res = null;
        if (isEmpty()) {
            System.out.println(listDesc + " is empty, unable to get parent");
        } else {
            HeroNode currentNode = headNode.next;
            while (currentNode != null) {
                if (currentNode.next.getNo() == childNode.getNo()) {
                    res = currentNode;
                    break;
                }
                currentNode = currentNode.next;
            }
        }
        return res;
    }

    /**
     * 删除一个节点
     *
     * @param heroNo
     */
    public void remove(int heroNo) {
        if (isEmpty()) {
            System.out.println(listDesc + " is empty, unable to remove records");
        } else {
            HeroNode currentNode = headNode.next;
            while (currentNode != null) {
                if (currentNode.getNo() == heroNo) {
                    // 这里有个getParentNode的操作，涉及到再一次遍历，所以效率稍低
                    getParentNode(currentNode).next = currentNode.next;
                    size--;
                    break;
                } else {
                    currentNode = currentNode.next;
                }
            }
        }

    }

    /**
     * 遍历List
     */
    public void showList() {
        if (isEmpty()) {
            System.out.println(listDesc + " is empty, unable to show records");
        } else {
            System.out.println("Iterating " + listDesc);
            HeroNode currentNode = headNode.next;
            while (currentNode != null) {
                System.out.println(currentNode);
                currentNode = currentNode.next;
            }
        }
    }

    /**
     * 替换，或者修改一个节点，直接替换新节点对应位置上的节点
     *
     * @param newNode
     */
    public void replace(HeroNode newNode) {
        boolean updated = false;
        if (isEmpty()) {
            System.out.println(listDesc + " is empty, unable to update records");
        } else {
            HeroNode currentNode = headNode.next;
            while (currentNode != null) {
                if (currentNode.getNo() == newNode.getNo()) {
                    getParentNode(currentNode).next = newNode;
                    newNode.next = currentNode.next;
                    updated = true;
                    break;
                }
            }
        }

        if (!updated) {
            System.out.println(listDesc + " is unable to find the node to replace");
        }
    }

    /**
     * 返回链表长度
     *
     * @return
     */
    public int getLength() {
        return size;
    }

    public LinkedList reverse() {
        LinkedList reversedList = new LinkedList();
        reversedList.size = this.size;
        HeroNode currentNode = headNode.next;
        HeroNode nextNode = null;
        while (currentNode != null) {
            // 记录下一个节点备用
            nextNode = currentNode.next;
            // 重新绑定关联
            currentNode.next = reversedList.headNode.next;
            // 附加在新链表上
            reversedList.headNode.next = currentNode;
            currentNode = nextNode;
        }
        return reversedList;
    }


}
