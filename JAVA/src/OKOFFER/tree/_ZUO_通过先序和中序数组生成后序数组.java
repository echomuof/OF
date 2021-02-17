package OKOFFER.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_通过先序和中序数组生成后序数组 {

    public static int[] getPosArray(int[] pre, int[] in) {
        if (pre == null || in == null) return null;
        int len = pre.length;
        int[] pos = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        setPos(pre, 0, len - 1, in, 0, len - 1, pos, len - 1, map);
        return pos;
    }

    public static int setPos(int[] pre, int preL, int preR, int[] in, int inL, int inR, int[] pos, int posI, Map<Integer, Integer> map) {
        if (preL > preR) return posI;
        pos[posI--] = pre[preL];
        int i = map.get(pre[preL]);
        posI = setPos(pre, preR - inR + i + 1, preR, in, i + 1, inR, pos, posI, map);
        return setPos(pre, preL + 1, preL + i - inL, in, inL, i - 1, pos, posI, map);
    }

}

