package download;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: wangdarui
 * @created: 2020/11/20
 */
public class D {
    static int i;

    public static void main(String[] args) throws IOException, NoSuchProviderException, NoSuchAlgorithmException, KeyManagementException {
        String preStr = "https://lzdliving.alicdn.com/live_hp/840184c1-4388-4274-8f1a-363d40f3fb9f/";
        String postStr = ".ts?auth_key=1608433228-0-0-9086b345162058b2a519a34ba920d1e2";
        String dir = "/Users/wdr/Documents/go/";
        SSLContext sslcontext = SSLContext.getInstance("SSL", "SunJSSE");
        sslcontext.init(null, new TrustManager[]{new X509TrustUtiil()}, new java.security.SecureRandom());
        HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
            public boolean verify(String s, SSLSession sslsession) {
                System.out.println("WARNING: Hostname is not matched for cert.");
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
        HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 330; i++) {
            String s = preStr + i + postStr;
            URL url = new URL(s);
            HttpsURLConnection urlCon = (HttpsURLConnection) url.openConnection();

            urlCon.setConnectTimeout(10 * 3000);
            urlCon.setReadTimeout(10 * 3000);

            int code = urlCon.getResponseCode();
            if (code != HttpURLConnection.HTTP_OK) {
                System.out.println("文件读取失败");
            }
            // 读文件流
            DataInputStream in = null;
            try {
                in = new DataInputStream(urlCon.getInputStream());
            } catch (Exception e) {
                continue;
            }
            DataOutputStream out = null;
            try {
                out = new DataOutputStream(new FileOutputStream(dir + "goooo.mp4", true));

                byte[] buffer = new byte[2048];
                int count = 0;
                while ((count = in.read(buffer)) > 0) {
                    out.write(buffer, 0, count);
                }
                out.close();
                in.close();
                System.out.println(i + " done");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
