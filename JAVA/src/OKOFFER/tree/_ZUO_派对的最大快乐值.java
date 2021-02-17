package OKOFFER.tree;

import java.util.List;

/**
 * @author: wangdarui
 * @created: 2021/2/13
 */
public class _ZUO_派对的最大快乐值 {
    static class Employee {
        public int happy;

        public List<Employee> subordinates;
    }

    static class ReturnData {
        public int yesMax;

        public int noMax;

        public ReturnData(int yesMax, int noMax) {
            this.yesMax = yesMax;
            this.noMax = noMax;
        }
    }

    public static int getMaxHappy(Employee employee) {
        ReturnData returnData = process(employee);
        return Math.max(returnData.yesMax, returnData.noMax);
    }

    public static ReturnData process(Employee e) {
        int yes = e.happy;
        int no = 0;
        if (e.subordinates.isEmpty()) {
            return new ReturnData(yes, no);
        }
        for (Employee next : e.subordinates) {
            ReturnData subTreeInfo = process(next);
            yes += subTreeInfo.noMax;
            no += Math.max(subTreeInfo.yesMax, subTreeInfo.noMax);
        }
        return new ReturnData(yes, no);
    }
}
