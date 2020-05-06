package foo.zongzhe.line.linked_list;

import java.util.ArrayList;

public class LinkedListDemo {

    private static ArrayList<LinkedList> lists = new ArrayList<>();

    public static void main(String[] args) {
        LinkedListDemo demo = new LinkedListDemo();

        initializeLists();

        // 添加三个英雄并显示
        HeroNode hero1 = new HeroNode(1, "Song Jiang", "Timely Rain"); // 及时雨宋江
        HeroNode hero2 = new HeroNode(2, "Lu Junyi", "Jade Qilin"); // 玉麒麟卢俊义
        HeroNode hero3 = new HeroNode(3, "Wu Yong", "Knowledgeable Star"); // 智多星吴用
        ArrayList<HeroNode> someHeros = new ArrayList<>();
        someHeros.add(hero3);
        someHeros.add(hero1);
        someHeros.add(hero2);
        addHeros(someHeros);
        showHeros();


        // 尝试添加一个相同号码的英雄
        hero1.setNickName("Gongming"); // 公明
        ArrayList<HeroNode> moreHeros = new ArrayList<>();
        moreHeros.add(hero1);
        addHeros(moreHeros);
        showHeros();

    }

    private static void initializeLists() {
        lists.add(new SortedLinkedList()); // 添加一个SortedLinkedList
    }

    private static void addHeros(ArrayList<HeroNode> someHeros) {
        for (LinkedList list : lists) {
            for (HeroNode aHero : someHeros) {
                list.add(aHero);
            }
        }
    }

    private static void showHeros() {
        for (LinkedList list : lists) {
            list.showList();
        }
    }
}
