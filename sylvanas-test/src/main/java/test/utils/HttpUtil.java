package test.utils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
public class HttpUtil {
    /**
     * 发送post请求
     * @param url  请求地址
     * @param json  json格式字符串
     * @param contentType  这里用 "application/json"
     * @return
     */
    public static String post(String url, String json, String contentType) {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //HttpClient
        CloseableHttpClient client = httpClientBuilder.build();
        client = (CloseableHttpClient) wrapClient(client);
        HttpPost post = new HttpPost(url);
        try {
            StringEntity s = new StringEntity(json, "utf-8");
            if (StringUtils.isBlank(contentType)) {
                s.setContentType("application/json");
            }
            s.setContentType(contentType);
            post.setEntity(s);
            HttpResponse res = client.execute(post);
            HttpEntity entity = res.getEntity();
            String str = EntityUtils.toString(entity, "utf-8");
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static org.apache.http.client.HttpClient wrapClient(HttpClient base) {
        try {
            SSLContext ctx = SSLContext.getInstance("TLSv1");
            X509TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] xcs,
                                               String string) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] xcs,
                                               String string) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(ctx, new String[]{"TLSv1"}, null,
                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            return httpclient;

        } catch (Exception ex) {
            return null;
        }
    }

    public class CharsetHandler implements ResponseHandler<String> {
        private String charset;

        public CharsetHandler(String charset) {
            this.charset = charset;
        }

        @Override
        public String handleResponse(HttpResponse response)
                throws ClientProtocolException, IOException {
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() >= 300) {
                throw new HttpResponseException(statusLine.getStatusCode(),
                        statusLine.getReasonPhrase());
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                if (!StringUtils.isBlank(charset)) {
                    return EntityUtils.toString(entity, charset);
                } else {
                    return EntityUtils.toString(entity);
                }
            } else {
                return null;
            }
        }
    }
}
