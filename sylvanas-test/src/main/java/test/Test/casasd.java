package test.Test;

public class casasd {

    public static void main(String[] args) {
        System.out.println(0L==(Long)0L);
        System.out.println(rebuildNum(30));
    }
    public static int rebuildNum(int num) {
        if (num <= 0) {
            //如果num<=0，直接返回2的0次幂
            return 1;
        } else if ((num & (num - 1)) == 0) {
            //如果num是2的乘方，则直接返回num
            return num;
        } else {
            //找到大于以2为底num的对数最近的整数
            //例：num=7,以2为底7的对数为：2.807...，强转int再加1结果为：3
            int tmp = (int) (Math.log(num) / Math.log(2)) + 1;
            //求2的tmp次幂
            return (int) Math.pow(2, tmp);
        }
    }

}
