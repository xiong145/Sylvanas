package test.Controller;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class uid {
    public static void main(String[] args) {


 AES aes = new AES(Mode.ECB, Padding.PKCS5Padding, "210FDA7686BF4CC1".getBytes());
        DES des = new DES(Mode.ECB, Padding.PKCS5Padding, "45UG56UK".getBytes());

        System.out.println( aes.encryptBase64("1"));
        System.out.println( des.encryptBase64("1"));
// 加密并进行Base转码
String encrypt = aes.encryptBase64("fs101/M00/85/EE/CgRQiWO6HqyAfE9YAAsd10SQsJY183.jpg");
System.out.println(encrypt);

// 解密为字符串
String decrypt = aes.decryptStr(encrypt);
System.out.println(decrypt);


    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
}
