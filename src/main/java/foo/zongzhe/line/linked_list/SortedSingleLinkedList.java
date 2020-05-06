package foo.zongzhe.line.linked_list;

public class SortedSingleLinkedList extends LinkedList {

    public SortedSingleLinkedList() {
        listDesc = "SortedSingleLinkedList";
        System.out.println(listDesc + " is created");
    }

    /**
     * 按顺序添加节点，当存在相同序号节点时，给出提示信息，并终止操作
     *
     * @param newHero
     */
    @Override
    public void add(HeroNode newHero) {
        int newHeroNo = newHero.getNo();
        HeroNode currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.getNo() == newHeroNo) {
                System.out.println(listDesc + " already has a node with same No=" + newHeroNo + ", unable to add");
                return;
            }else if (newHeroNo > currentNode.getNo() && (currentNode.next == null || newHeroNo < currentNode.next.getNo())){
                newHero.next = currentNode.next;
                currentNode.next = newHero;
                return;
            }
            currentNode = currentNode.next;
        }
    }
}
