package lab01.shared;

public class Utils {
    public static Node getHeadOf(Node node) {
        if(isNull(node.prev))
            return node;
        else
            return getHeadOf(node.prev);
    }

    public static Node getTailOf(Node node) {
        if(isNull(node.next))
            return node;
        else
            return getTailOf(node.next);
    }

    public static boolean isNull(Node node) {
        return node == null;
    }
}
