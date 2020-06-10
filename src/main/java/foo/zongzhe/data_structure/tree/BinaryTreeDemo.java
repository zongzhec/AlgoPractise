package foo.zongzhe.data_structure.tree;

import foo.zongzhe.data_structure.common.HeroNode;
import foo.zongzhe.data_structure.common.HeroNodeTree;

public class BinaryTreeDemo {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        // 创建需要的节点
        HeroNodeTree hero1 = new HeroNodeTree(1, "Song Jiang", "Timely Rain"); // 及时雨宋江
        HeroNodeTree hero2 = new HeroNodeTree(2, "Lu Junyi", "Jade Qilin"); // 玉麒麟卢俊义
        HeroNodeTree hero3 = new HeroNodeTree(3, "Wu Yong", "Knowledgeable Star"); // 智多星吴用
        HeroNodeTree hero4 = new HeroNodeTree(4, "Gongsun Sheng", "Dragon in the Clouds"); // 入云龙公孙胜
        HeroNodeTree hero5 = new HeroNodeTree(5, "Guan Sheng", "Great Blade"); // 大刀关胜

        // 手动创建二叉树
        binaryTree.setRoot(hero2);
        hero2.setLeft(hero1);
        hero2.setRight(hero4);
        hero4.setLeft(hero3);
        hero4.setRight(hero5);

        // 测试遍历
        binaryTree.preOrder();
        binaryTree.infixOrder();
        binaryTree.postOrder();

        // 测试查找
        System.out.println(binaryTree.preOrderSearch(4));
        System.out.println(binaryTree.preOrderSearch(8));
    }
}
