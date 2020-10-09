/**
 * @author: wangdarui
 * @created: 2020/9/30
 */
public class zhua {
    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            System.out.println("ffmpeg -i  -c copy -bsf:a aac_adtstoasc " + i + ".mp4\n");
        }
    }
}
