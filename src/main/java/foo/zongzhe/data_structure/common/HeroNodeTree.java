package foo.zongzhe.data_structure.common;

public class HeroNodeTree {
    public int no;
    public String name;
    public String nickName;
    public HeroNodeTree left;
    public HeroNodeTree right;

    public HeroNodeTree(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    /**
     * 为了显示方便，重写toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    /**
     * 前序遍历: 中左右
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历: 左中右
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历: 左右中
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     *
     * @param no
     * @return
     */
    public HeroNodeTree preOrderSearch(int no) {
        HeroNodeTree res = null;
        // 先比较当前节点
        if (this.no == no) {
            return this;
        }
        if (this.left != null) {
            res = this.left.preOrderSearch(no);
            if (res != null) {
                return res;
            }
        }
        if (this.right != null) {
            res = this.right.preOrderSearch(no);
            if (res != null) {
                return res;
            }
        }
        return res;
    }

    /**
     * 删除节点A
     * 规则：
     * 1. 如果只有一个子节点，则用其子节点代替当前需要被删除的节点
     * 2. 如果有左子节点B和右子节点C，则让左子节点代替A
     *
     * @param no
     */
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            if (this.left.left != null) {
                this.left = this.left.left;
            } else if (this.left.right != null) {
                this.left = this.left.right;
            } else {
                this.left = null;
            }
            return;
        }
        if (this.right != null && this.right.no == no) {
            if (this.right.left != null) {
                this.right = this.right.left;
            } else if (this.right.right != null) {
                this.right = this.right.right;
            } else {
                this.right = null;
            }
            return;
        }
        this.left.delNode(no);
        this.right.delNode(no);
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNodeTree getLeft() {
        return left;
    }

    public void setLeft(HeroNodeTree left) {
        this.left = left;
    }

    public HeroNodeTree getRight() {
        return right;
    }

    public void setRight(HeroNodeTree right) {
        this.right = right;
    }
}
