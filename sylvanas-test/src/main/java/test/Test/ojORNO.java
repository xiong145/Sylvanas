package test.Test;

public class ojORNO {
    public static void main(String[] args) {
        Long getFeeSum1=0L;
        Long getFeeSum2 =0L;
        Integer d=0;
        System.out.println(   getFeeSum1.equals(0L)&getFeeSum2.equals(0L)&d.equals(0) );

        System.out.println(  !getFeeSum2.equals(0L) );
        System.out.println( !d.equals(0) );
        System.out.println(   getFeeSum1.equals(0) & (!getFeeSum2.equals(0) | !d.equals(0)));
        System.out.println(true&false);
    }
}
