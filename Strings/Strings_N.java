public class Strings_N {
    public static String compress(String str) {
    String newStr = "";

    for(int i=0; i<str.length(); i++) {
        Integer count =1;                        //we need to convert integer to  string so we used integer class here
        while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {  //(i<n-1 here kyoki next we have compared i to i+1; agar i=n-1 ho jata to comparison mein n-1 aur n ka comparison hota and this somehow give comppilation error)
        //we are comparing current letter and next letter
        //if same letter keep coming
        count++;
        i++;
        } //if not same letter
          newStr += str.charAt(i);   //letter ko add kra
        if(count>1) {
            newStr += count.toString();

        }
    }

    return newStr;

    }
    public static void main(String args[]) {
        String str = "aaabbcccdd";
        System.out.println(compress(str));

    }
}
