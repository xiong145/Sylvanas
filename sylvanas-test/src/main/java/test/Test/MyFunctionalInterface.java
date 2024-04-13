package test.Test;

@FunctionalInterface
public
interface MyFunctionalInterface {
    // 抽象方法
    int operation(int a, int b);

    // 默认方法
    default void display() {
        System.out.println("This is a default method.");
    }
}
