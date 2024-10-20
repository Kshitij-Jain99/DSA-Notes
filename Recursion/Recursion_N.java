public class Recursion_N {
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
    if(idx== str.length()) {
        System.out.println(newStr);
        return;
    } 

    //kaam 
    char currChar = str.charAt(idx);  
    if(map[currChar-'a'] == true) {
        //duplicate
    removeDuplicates(str,idx+1,newStr,map); //then call for next index by not adding this char in string
    }else{
        map[currChar-'a'] = true;
        removeDuplicates(str, idx+1, newStr.append(currChar), map);
    }
 }

 

 public static void main(String args[]){
    String str = "appnnacollege";
    removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
 }
}

