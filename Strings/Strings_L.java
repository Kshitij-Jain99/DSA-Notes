public class Strings_L {
    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder(""); //we can initialize it with empty string or keep it null
        for(char ch='a'; ch<='z'; ch++){
            sb.append(ch);
        }  //abcdefgh______
        //TC= O(26) in this case
        //TC= O(N*26)=O(N*N), if we take string and then use += instead of append, here n^2 is iterations  
        System.out.println(sb);
        System.out.println(sb.length());
    }
}
