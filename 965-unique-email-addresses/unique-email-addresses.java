class Solution {
    public int numUniqueEmails(String[] emails) {
        if (emails.length == 1) {
            return 1;
        }

        HashSet<String> emailSet = new HashSet<>();
        int result = 0;

        for (String email : emails) {
            int com = email.indexOf("@");
            int plus = email.indexOf("+");
            String res = email;
            
            if (plus > 0) {
                res = email.substring(0, plus) + email.substring(com);
            }
            com = res.indexOf("@");
            while (res.indexOf(".") < com) {
                com = res.indexOf("@");
                res = res.substring(0, res.indexOf(".")) + res.substring(res.indexOf(".") + 1);
            }

            if (emailSet.contains(res)) {
                continue;
            }

            emailSet.add(res);
            result++;
        }

        return result;
    }
}