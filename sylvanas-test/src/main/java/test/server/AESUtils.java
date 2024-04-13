//package test.server;
//
//import javax.crypto.Cipher;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//import java.security.NoSuchAlgorithmException;
//
//public class AESUtils {
//    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {
//        private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
//        private static final String SECRET_KEY_ALGORITHM = "AES";
//
//        /**
//         * 加密
//         * @param data 需要加密的数据
//         * @param key 加密密钥
//         * @param iv 加密向量
//         * @return 加密后的数据
//         * @throws Exception
//         */
//        public static byte[] encrypt(byte[] data, byte[] key, byte[] iv) throws Exception {
//            SecretKeySpec secretKeySpec = new SecretKeySpec(key, SECRET_KEY_ALGORITHM);
//            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
//            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
//            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
//            return cipher.doFinal(data);
//        }
//
//        /**
//         * 解密
//         * @param data 需要解密的数据
//         * @param key 解密密钥
//         * @param iv 解密向量
//         * @return 解密后的数据
//         * @throws Exception
//         */
//        public static byte[] decrypt(byte[] data, byte[] key, byte[] iv) throws Exception {
//            SecretKeySpec secretKeySpec = new SecretKeySpec(key, SECRET_KEY_ALGORITHM);
//            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
//            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
//            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
//            return cipher.doFinal(data);
//        }
//    }
//}
