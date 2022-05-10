class Test {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        
        String currentString = "";
        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);

            if (currentString.contains(Character.toString(currentChar))) {
                if (currentString.length() > max) {
                    max = currentString.length();
                }

                currentString = currentString.substring(currentString.indexOf(currentChar) + 1) + currentChar;
            } else {
                currentString = currentString + currentChar;
            }
        }

        if (currentString.length() > max) {
            max = currentString.length();
        }
        
        return max;
    }
}