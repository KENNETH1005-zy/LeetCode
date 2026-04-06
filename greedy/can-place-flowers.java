class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //if both front and end space is 0
        //can be planted
        //if not return true
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            return true;
        }
        for (int i = 0; i<flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            //now the num must be 0
            if (i == 0) {
                if (flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }else if (i == flowerbed.length - 1) {
                if (flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }else {
                if (flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}