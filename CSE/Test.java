import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("zebra");
        list.add("one");
        list.add("plus");
        list.add("won");
        list.add("potato");
        list.add("twelve");

        AnagramSolver a = new AnagramSolver(list);
        a.print("oneplustwelve", 0);
    }
}
