class Solution {
    public boolean canTransform(String start, String result) {
        //tow pointers
        //once meet R or L
        //if both R or L continue
        //if find R in result, and same index in start is X, if left in start is R, continue
        //if not return false
        //if find L in result, and same index in start is X, if right in start is L, continue
        //if not return false
        if (start.length() <= 1 || result.length() <= 1) return false;
        int sP = 0;
        int rP = 0;

        while (sP <start.length() && rP <result.length()) {

            if (result.charAt(rP) == 'X' || result.charAt(rP) == start.charAt(sP)) {
                sP++;
                rP++;
                continue;
            }
          
            if (result.charAt(rP) == 'R') {
                if (sP <= 0) return false;
                if (start.charAt(sP - 1) == 'R') {
                    sP++;
                    rP++;
                    continue;
                }else {
                    return false;
                }
            }else if (result.charAt(rP) == 'L'){
                if (sP >= start.length() - 1) return false;
                if (start.charAt(sP + 1) == 'L') {
                    sP++;
                    rP++;
                    continue;
                }else {
                    return false;
                }
            }

        }
        return true;
    }
}