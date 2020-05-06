package foo.zongzhe.line.linked_list;

/**
 * 定义LinkedList来管理HeroNode
 */
public class LinkedList {

    public HeroNode headNode;
    public HeroNode lastNode;
    public String listDesc;

    public LinkedList() {
        headNode = new HeroNode(0, "dummyHeroName", "dummyNickName");
        headNode.next = null;
        lastNode = headNode;
        listDesc = "LinkedList";
    }

    /**
     * 增加一个英雄
     *
     * @param newHero
     */
    public void add(HeroNode newHero) {
        lastNode.next = newHero;
        lastNode = newHero;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return headNode.next == null;
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
     * 替换，或者修改一个节点
     *
     * @param existingNode
     * @param newNode
     */
    public void replace(HeroNode existingNode, HeroNode newNode) {
        boolean updated = false;
        if (isEmpty()) {
            System.out.println(listDesc + " is empty, unable to update records");
        } else {
            HeroNode currentNode = headNode.next;
            while (currentNode != null) {
                if (currentNode.getNo() == existingNode.getNo()) {
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


}
