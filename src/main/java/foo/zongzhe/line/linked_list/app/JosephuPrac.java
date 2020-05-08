package foo.zongzhe.line.linked_list.app;

import foo.zongzhe.line.linked_list.CircleLinkedList;
import foo.zongzhe.line.linked_list.HeroNode;

import java.util.LinkedList;

/**
 * 使用链表解决约瑟夫环问题
 * 问题描述：N个人围成一圈，第一个人从1开始报数，报M的将被杀掉，下一个人接着从1开始报。如此反复，最后剩下一个，求最后的胜利者。
 */
public class JosephuPrac {
    public static void main(String[] args) {
        int playerAmount = 20;
        int numForRemoval = 7;
        int survier = resolveJosephuProblem(playerAmount, numForRemoval);
        System.out.println("Survier is No.=" + survier);
    }

    private static int resolveJosephuProblem(int playerAmount, int numForRemoval) {
        if (playerAmount <= 0) {
            System.out.println("No enough players!");
            return 0;
        }
        CircleLinkedList players = new CircleLinkedList();

        // 初始化Player链表
        for (int i = 1; i <= playerAmount; i++) {
            HeroNode dummyHero = new HeroNode(i, "dummy", "dummy");
            players.add(dummyHero);
        }
        players.showList();
        System.out.println("next of last is: " + players.lastNode.next.getNo());
//        System.exit(0);

        // 开始游戏
        HeroNode currentPlayer = players.headNode.next;
        int survivalPlayerAmount = playerAmount;
        while (survivalPlayerAmount > 1) {
            int j = 1;
            while (j < numForRemoval) {
                j++;
                currentPlayer = currentPlayer.next;
            }
            // 找到了这个人
            int playerNum = currentPlayer.getNo();
            System.out.println("Removing player No.=" + playerNum);
            players.remove(playerNum);
            survivalPlayerAmount--;
            currentPlayer = currentPlayer.next;
//            players.showList();
        }

        return players.headNode.next.getNo();
    }
}
