package test.Test;

public class orand {
    public static void main(String[] args) {
        Long a=0L;
        Integer ZERO=0;
        long ZERO1 = 0L;
        System.out.println(!a.equals( ZERO.longValue()));
        System.out.println(!a.equals(ZERO1));
        System.out.println(!a.equals(0L));
        System.out.println(true & (false|false));
    }
}
