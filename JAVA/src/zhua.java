/**
 * @author: wangdarui
 * @created: 2020/9/30
 */
public class zhua {

    static int i;

    public zhua add() {
        i++;
        return this;
    }

    private void show() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        zhua z = new zhua();
        z.add().add().show();
    }
}



























