package test.Test;

/**
 * 函数式接口
 */
public class sss {
    public static void main(String[] args) {

        // 使用Lambda表达式实现函数式接口
        MyFunctionalInterface addFunction = (a, b) -> a + b;
        System.out.println(addFunction.operation(3, 4)); // 输出 7

        // 使用匿名类实现函数式接口
        MyFunctionalInterface subtractFunction = new MyFunctionalInterface() {
            @Override
            public int operation(int a, int b) {
                return a - b;
            }
        };
        System.out.println(subtractFunction.operation(5, 2)); // 输出 3
    }
}
