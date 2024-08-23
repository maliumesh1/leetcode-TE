class Solution {
    public String fractionAddition(String expression) {
        int v = 1;
        v = v * 8 * 9 * 7 * 5;
        int flag = 1;
        int str = 0;
        int index = 0;
        if (expression.charAt(0) == '-') {
            flag = -1;
            index++;
        }
        List<Integer> nList = new ArrayList<>();
        List<Integer> dList = new ArrayList<>();
        for (; index < expression.length(); index++) {
            char ch = expression.charAt(index);
            if (ch == '-' || ch == '+' || ch == '/') {
                if (ch == '/') {
                    // System.out.println("numerator: " + str * flag);
                    nList.add(str * flag);
                    str = 0;
                    flag = 1;

                } else if (ch == '+') {
                    // System.out.println("denominator: " + str);
                    dList.add(str);
                    str = 0;
                    flag = 1;
                } else if (ch == '-') {
                    // System.out.println("denominator: " + str);
                    dList.add(str);
                    str = 0;
                    flag = -1;
                }
            } else {
                str = str * 10 + (ch - '0');
            }

        }
        // System.out.println("denominator: " + str);
        dList.add(str);
        int sum = 0;
        for (int i = 0; i < dList.size(); i++) {
            // System.out.println(dList.get(i));
            int de = dList.get(i);
            int n = nList.get(i);
            sum += (n * v / de);
        }
        if (sum == 0) {
            return "0/1";
        }
        while ((v % 2 == 0) && (sum % 2 == 0)) {
            v /= 2;
            sum /= 2;
        }
        while ((v % 3 == 0) && (sum % 3 == 0)) {
            v /= 3;
            sum /= 3;
        }
        while ((v % 5 == 0) && (sum % 5 == 0)) {
            v /= 5;
            sum /= 5;
        }
        while ((v % 7 == 0) && (sum % 7 == 0)) {
            v /= 7;
            sum /= 7;
        }
        StringBuilder sb = new StringBuilder("");
        if (sum < 0) {
            sb.append("-");
            sum *= -1;
        }
        sb.append(sum);
        sb.append("/");
        sb.append(v);
        return sb.toString();
    }
}
