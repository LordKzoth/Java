class Test {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
    
    public static String convert(String s, int numRows) {
        int sLen = s.length();
        StringBuilder result = new StringBuilder(sLen);
        
        int currentRow      = 0;
        int currentIndex    = currentRow;
        int maxStep         = numRows * 2 - 2;
        int step            = 0;
        
        maxStep = (maxStep == 0) ? 1 : maxStep; // 1 Row Exception
        
        for (int i = 0; i < sLen; i++) {
            if (step == 0) step = maxStep;      // Edge Rows
            result.append(s.charAt(currentIndex));
            
            if (currentIndex + step < sLen) {
                currentIndex += step;
                step = maxStep - step;
            }
            else {
                currentRow++;
                currentIndex = currentRow;
                step = maxStep - currentRow * 2;
            }
        }
        
        return result.toString();
    }
}