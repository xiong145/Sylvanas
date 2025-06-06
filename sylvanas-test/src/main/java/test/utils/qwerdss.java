package test.utils;


public class qwerdss {




        public static void main(String[] args) {
            ImmutableArray a = new ImmutableArray();
            a.insert(0, "a");
            a.insert(0, "b");
            a.insert(2, "c");
            a.insert(2, "d");
            System.out.println(a.getArray());  // 输出: ["b", "a", "d", "c"]

            a.fix();
            // a.insert(1, "e");  // 这行代码会抛出异常: "Array is immutable and cannot be modified."

            System.out.println(a.get(0));  // 输出: "b"
            System.out.println(a.get(1));  // 输出: "a"
        }


}
