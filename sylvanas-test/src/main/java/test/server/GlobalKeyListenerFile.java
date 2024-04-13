package test.server;

import java.io.*;

public class GlobalKeyListenerFile {
    //存放位置     Windows下为D:/test.txt
    File f = new File("C:\\Users\\xiong\\Desktop\\zto\\Sylvanas\\sylvanas-test\\txt\\new.txt");
    //将数据写入.json文件--start
    BufferedWriter writer = null;


    public void fileInput(String jsonString) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true), "UTF-8"));
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
