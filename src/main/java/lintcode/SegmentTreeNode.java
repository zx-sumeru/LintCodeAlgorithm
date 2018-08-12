package lintcode;

/**
 * @author Zhang Xu
 * @date 2018/8/12 下午3:33
 */
public class SegmentTreeNode{
    public int start;
    public int end;
    public int max;
    public SegmentTreeNode left;
    public SegmentTreeNode right;

    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = this.right = null;
    }
}
