package OKOFFER.other;

import netscape.security.UserTarget;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_并查集 {

}

class Element<V> {

    public V value;

    public Element(V value) {
        this.value = value;
    }
}

class UnionFindSet<V> {

    public Map<V, Element<V>> elementMap;

    public Map<Element<V>, Element<V>> fatherMap;

    public Map<Element<V>, Integer> rankMap;

    public UnionFindSet(List<V> list) {
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        rankMap = new HashMap<>();
        for (V v : list) {
            Element<V> element = new Element<>(v);
            elementMap.put(v, element);
            fatherMap.put(element, element);
            rankMap.put(element, 1);
        }
    }

    public Element<V> findHead(Element<V> element) {
        Stack<Element<V>> path = new Stack<>();
        while (element != fatherMap.get(element)) {
            path.push(element);
            element = fatherMap.get(element);
        }
        while (!path.isEmpty()) {
            fatherMap.put(path.pop(), element);
        }
        return element;
    }

    public boolean isSameSet(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
        }
        return false;
    }

    public void union(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            Element<V> ah = findHead(elementMap.get(a));
            Element<V> bh = findHead(elementMap.get(b));
            if (ah != bh) {
                Element<V> big = rankMap.get(ah) >= rankMap.get(bh) ? ah : bh;
                Element<V> small = big == ah ? bh : ah;
                fatherMap.put(small, big);
                rankMap.put(big, rankMap.get(ah) + rankMap.get(bh));
                rankMap.remove(small);
            }
        }
    }
}

