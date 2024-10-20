public class Recursion_P {
    public static void printBinString(int n, int lastPlace, String str) {
        // Base case
        if (n == 0) {
            System.out.println(str); // as n value decreases to 0, print  string
        } else {
            //kaam
        // if(lastPlace ==0){
        //     //sit 0 on chair n
        //    printBinString(n-1,0,str.append('0'));
        //    printBinString(n-1,1,str.append("0"));  

        //    else{
        //     printBinString(n-1,0,str.append("0"));

            // Kaam
            printBinString(n - 1, 0, str + "0"); // 0 ko to har bar baithna hi hai
            if (lastPlace == 0) { // agar last place zero thi to 1 ko bhi baitha sakte ho
                printBinString(n - 1, 1, str + "1");
            }
        }
    }

    public static void main(String args[]) {
        printBinString(3, 0, "");
    }
}
