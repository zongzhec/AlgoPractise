package foo.zongzhe.data_structure.line.linked_list;

/**
 * 使用带head头的单向链表实现——水浒英雄排行榜管理
 * 1>完成对人物的增删改查操作
 * 2>第一种方法在添加英雄时，直接添加到链表的尾部
 * 3>第二种方法在添加英雄时，根据排名将英雄插入到指定位置
 * （如果有这个排名，则添加失败，并给出提示）
 */
public class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
    public HeroNode prev;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    /**
     * 为了显示方便，重写toString
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

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }
}
