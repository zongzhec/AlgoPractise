package foo.zongzhe.data_structure.line.linked_list;

public class SortedDoubleLinkedList extends DoubleLinkedList {

    public SortedDoubleLinkedList() {
        super();
        listDesc = "SortedDoubleLinkedList";
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
        while (currentNode != lastNode) {
            if (currentNode.getNo() == newHeroNo) {
                System.out.println(listDesc + " already has a node with same No=" + newHeroNo + ", unable to add");
                return;
            }else if (newHeroNo > currentNode.getNo() && (currentNode.next == lastNode || newHeroNo < currentNode.next.getNo())){
                newHero.next = currentNode.next;
                newHero.prev = currentNode;
                currentNode.next.prev = newHero;
                currentNode.next = newHero;
                size++;
                return;
            }
            currentNode = currentNode.next;
        }
    }
}
