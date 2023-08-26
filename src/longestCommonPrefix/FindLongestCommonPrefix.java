package longestCommonPrefix;
/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
 */
public class FindLongestCommonPrefix {
    public static void main(String[] args) {
        FindLongestCommonPrefix findLongestCommonPrefix = new FindLongestCommonPrefix();
        String[] arr = new String[] {"flexu", "flexi", "flexu", "flexu"};
        System.out.println(findLongestCommonPrefix.findLongestPrefix(arr));
        String[] arr2 = new String[] {"abc","bac","cab"};
        System.out.println(findLongestCommonPrefix.findLongestPrefix(arr2));
        String[] arr3 = new String[] {"flower","flow","flight"};
        System.out.println(findLongestCommonPrefix.findLongestPrefix(arr3));
        String[] arr4 = new String[] {""};
        System.out.println(findLongestCommonPrefix.findLongestPrefix(arr4));
        String[] arr5 = new String[] {"flower", "flower", "flowe"};
        System.out.println(findLongestCommonPrefix.findLongestPrefix(arr5));
    }

    public StringBuilder findLongestPrefix(String[] array) {
        StringBuilder answer = new StringBuilder("");
        int letterCounter = 0;
        int index = 0;
        boolean isEqual = true;
        int minLength = array[0].length();
        for (String s : array) {
            minLength = Math.min(minLength, s.length());
        }
        while (letterCounter < minLength){
            //System.out.println("letter " + letterCounter + ", index=" + index + " " + answer);
            for (int i = 1; i <  array.length; i++) {
                if (array[i-1].charAt(letterCounter) != array[i].charAt(letterCounter)){
                    isEqual = false;
                    break;
                }
            }
            if (!isEqual){break;}
            answer.append(array[index].charAt(letterCounter));
            letterCounter++;
        }
        return answer;
    }
}
