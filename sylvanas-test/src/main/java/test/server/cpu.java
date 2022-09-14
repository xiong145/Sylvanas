package test.server;

import com.alibaba.fastjson.JSONObject;

public class cpu {
    public static void main(String[] args) throws InterruptedException {
        Integer j = 0;
        while (true) {
            Thread highCpuThread = new Thread();

            Thread finalHighCpuThread = highCpuThread;
            highCpuThread = new Thread(() -> {

                int i = 0;

                while (true) {

                    i++;
                    if (i % 102 == 101) {

                        System.out.println(finalHighCpuThread.getName() + "值" + i);

                    }

                }

            });
            j++;

            highCpuThread.setPriority(j*10);
            highCpuThread.setName(j.toString());
            finalHighCpuThread.setName(j.toString());
            highCpuThread.start();
            System.out.println(highCpuThread.getName() + ":" + JSONObject.toJSONString(highCpuThread));
            if (j > 10) {
                Thread.sleep(1000000);
            }
        }


    }
}
