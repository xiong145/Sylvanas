package test.Test;

import java.util.function.Function;

/**
 * @author an-hou.xiong
 */
public class FunctionalLife {
    static ThreadLocal threadLocal = new ThreadLocal();
    public static void main(String[] args) {

        threadLocal.set(1);
        print(FunctionalLife::get);
    }

    public static void print(Function<Integer, String> f) {
        String a = (String) f.apply((Integer) threadLocal.get());
        System.out.println(a);
    }

    public static String get(Integer a) {
        return a.toString();
    }
}
