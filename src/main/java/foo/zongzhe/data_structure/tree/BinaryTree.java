package foo.zongzhe.data_structure.tree;

import foo.zongzhe.data_structure.common.HeroNodeTree;

public class BinaryTree {
    private HeroNodeTree root;

    public void setRoot(HeroNodeTree root) {
        this.root = root;
    }

    /**
     * 发起前序遍历
     */
    public void preOrder() {
        System.out.println("Printing as preOrder");
        if (this.root != null) {
            this.root.preOrder();
        }else{
            System.out.println("Binary tree is empty, unable to iterate");
        }
    }

    public void infixOrder() {
        System.out.println("Printing as infixOrder");
        if (this.root != null) {
            this.root.infixOrder();
        }else{
            System.out.println("Binary tree is empty, unable to iterate");
        }
    }

    public void postOrder() {
        System.out.println("Printing as postOrder");
        if (this.root != null) {
            this.root.postOrder();
        }else{
            System.out.println("Binary tree is empty, unable to iterate");
        }
    }
}
