public class Strings_M {
    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        //now we take words and dekhenge ki capital karna hai ya nhi
      char ch = Character.toUpperCase(str.charAt(0)); //string ke first letter ko capital kara
      sb.append(ch);

      for(int i=1; i<str.length(); i++) {      //0 wale ko dekh liya hai
          //now we will check if we have reached empty space
         if(str.charAt(i) == ' '&& i<str.length()-1 ) {
            sb.append(str.charAt(i));
            i++;
            sb.append(Character.toUpperCase(str.charAt(i)));  //append(upper case mein convert{ith place wala characte nikal liya})
           //this if has: empty space ko exactly copy and then uske bad wale letter ko capital karke copy 
        } else{
            sb.append(str.charAt(i));
         }  // jo bhi hai baki vo exactly copy kardo
      }

return sb.toString();    
}
    public static void main(String args[]) {
        String str = "hi, i am kshitij ";   //here we have left empty space after j at end, so && condition is added
        System.out.println(toUpperCase(str));
    }
    //"hi,i am kshitij " on using this there is a problem
}
