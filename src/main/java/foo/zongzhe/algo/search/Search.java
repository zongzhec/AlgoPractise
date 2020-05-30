package foo.zongzhe.algo.search;

public abstract class Search {
    public int[] array;
    public String searchDesc = "Search";
    public int searchValue;
    public int searchIndex;
    public long startTime;
    public long endTime;
    public int searchRound;

    public Search(int[] array) {
        this.array = array;
        searchDesc = "Search";
        searchIndex = -1;
        searchRound = 0;
    }

    public int getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(int searchValue) {
        this.searchValue = searchValue;
    }

    public int getSearchIndex() {
        return searchIndex;
    }

    public void setSearchIndex(int searchIndex) {
        this.searchIndex = searchIndex;
    }

    public abstract int search(int target);


}
