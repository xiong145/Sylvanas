package test.server;

import cn.hutool.core.lang.Assert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class file {
    public static void main(String[] args) {
        try {
            //BufferedReader是可以按行读取文件
            FileInputStream inputStream = new FileInputStream("C:\\Users\\xiong\\Documents\\3.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                if (str.contains("实际重量由")) {
                    int ss = str.indexOf("实际重量由 \"") + 7;
                    String strd = str.substring(str.indexOf("实际重量由 \"") + 7, str.length());
                    int ssd = strd.indexOf("\" 改为");
                    String aa = strd.substring(0, ssd);
                    Assert.notNull(aa);
                    Double aa1 = Double.parseDouble(aa);
                    System.out.print(aa1);

                    String Str3 = str.substring(ss + ssd, str.length());
                    int asa = Str3.indexOf("\";");
                    String bb = Str3.substring(6,asa);
                    Assert.notNull(bb);
                    Double bb1 = Double.parseDouble(bb);
                    System.out.print("->"+bb1);
                    Boolean b = aa1 > bb1 ? true : false;
                    System.out.println(b);
                    str = null;












                }


            }

            //close
            inputStream.close();
            bufferedReader.close();

        } catch (Exception e) {
            e.getMessage();
        }

    }
}
