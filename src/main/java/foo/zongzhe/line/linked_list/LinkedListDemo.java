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
        HeroNode hero4 = new HeroNode(4, "Gongsun Sheng", "Dragon in the Clouds"); // 入云龙公孙胜
        ArrayList<HeroNode> someHeros = new ArrayList<>();
        someHeros.add(hero3);
        someHeros.add(hero1);
        someHeros.add(hero4);
        addHeros(someHeros);
        getLength();
        showHeros();


        // 尝试添加一个相同号码的英雄
        hero1.setNickName("Gongming"); // 公明
        ArrayList<HeroNode> moreHeros = new ArrayList<>();
        moreHeros.add(hero1);
        moreHeros.add(hero2);
        addHeros(moreHeros);
        getLength();
        showHeros();

        // 反转链表
        reverseLists();

    }

    private static void reverseLists() {
        System.out.println("reversing lists");
        for (LinkedList list : lists) {
            LinkedList reversedList = list.reverse();
            reversedList.showList();
        }
    }

    private static void getLength() {
        for (LinkedList list : lists) {
            System.out.println(list.listDesc + " length is: " + list.getLength());
        }
    }

    private static void initializeLists() {
//        lists.add(new SortedSingleLinkedList()); // 添加一个SortedLinkedList
        lists.add(new SortedDoubleLinkedList()); // 添加一个SortedDoubleLinkedList
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
