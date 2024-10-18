public class E {
    public static void findPermutation(String str, String ans) {
      //base case
      if(str.length() == 0) {
        System.out.println(ans);
        return;
      }
      //Recursion
      for(int i=0; i<str.length(); i++) {
        char curr = str.charAt(i);
        //"abcde" => "ab" + "de" = "abde"; deleting "c"
         String Newstr = str.substring(0,i) + str.substring(i+1); //to delete a part of string, here i character
        findPermutation(Newstr, ans+curr);
      }
    }
    public static void main(String args[]){
        String str = "abc";
        findPermutation(str,"");
    }
}
