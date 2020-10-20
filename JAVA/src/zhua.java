import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangdarui
 * @created: 2020/9/30
 */
public class zhua {

    public static void main(String[] args) throws IOException {

        String fileUrl = "https://vod.pipi.cn/27df3294vodbj1251246104/63ac9f2d5285890807937634112/f0.mp4";
        URL url = new URL(fileUrl);
        URLConnection urlConnection = url.openConnection();
        long size = urlConnection.getContentLengthLong();


        BufferedInputStream bufferedInputStream = null;
        // Integer writeSize = StarPlatformConstant.KUAISHOU_UPLOAD_PIECEMEAL_PART_SIZE;
        Integer writeSize = 3 * 1024 * 1024;
        Integer singleReadSize = 1024 * 16;
        int fragmentCount = (int) Math.ceil(Double.parseDouble(String.valueOf(size)) / singleReadSize);
        List<byte[]> ans = new ArrayList<>();
        byte[] writeBuf = new byte[writeSize];
        int tmpLen = 0;
        try {
            bufferedInputStream = new BufferedInputStream(url.openStream(), singleReadSize);
            int readLen;
            while ((readLen = bufferedInputStream.read(writeBuf, tmpLen, singleReadSize)) != -1) {
                tmpLen += readLen;
                if (tmpLen >= writeSize - singleReadSize) {
                    ans.add(Arrays.copyOf(writeBuf, tmpLen));
                    tmpLen = 0;
                }
            }
            if (tmpLen>0) ans.add(Arrays.copyOf(writeBuf, tmpLen));
            int cout = 0;
            for (byte[] an : ans) {
                cout += an.length;
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

}



























