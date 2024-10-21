public class OOPS_B {
       public static void main(String args[]) {
       BankAccount myAcc = new BankAccount();
       myAcc.username = "shradhaKhapra";
       myAcc.setPassword("abcdefghi");
                                                   // myAcc.password = "abcdefg"     //this will show error as password is private access modifier
    }

}

class BankAccount {
    public String username;
    private String password;
    public void setPassword(String pwd) {
        password = pwd;
    }
}