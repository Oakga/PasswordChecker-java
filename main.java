import java.util.Scanner;

/**
 * Created by olwin on 2/14/17.
 */
public class Main {
    String password, secondPassword;
    int[] charCount;
    int passwordLength;

    public Main() {
        password = secondPassword = "";
        charCount = new int[5];
        passwordLength = 0;
    }

    void displyrules() {
        System.out.println(" The set of password rules is given below.\n" +
                "\n" +
                "\t1) The password length: 8-16 characters\n" +
                "\t2) At least one numerical, i.e., 0, 1, 2,..\n" +
                "\t3) At least one upper case letter, i.e., A, B, C, ...\n" +
                "\t4) At least one lower case letter, i.e., a, b, c, ...\n" +
                "\t5) At least one of the special characters, but it must be \n" +
                "\t   within the set:{ $ ^ & #  ( ) } at total of six (6).\n" +
                "\t   no other special characters is allowed.\n");
    }

    void displySucess() {
        System.out.println("\"your password will be updated in 2 minuties\" on the screen");
    }

    int checker() {
        int valid = 1;
        if (charCount[0] > 0) valid = 0;
        for (int i = 1; i < 5; i++) {
            if (charCount[i] == 0) valid = 0;
        }
        return valid;
    }

    int checkChar(char ch) {
        int index = 0;
        int Dec = (int) ch;
        if (Dec > 47 && Dec < 58) index = 1;//numeric case
        if (Dec > 96 && Dec < 123) index = 2; //lower case
        if (Dec > 64 && Dec < 91) index = 3;//upper case
        //special characters
        if (Dec == 40 || Dec == 41 || Dec == 35 || Dec == 36 || Dec == 38 || Dec == 94) index = 4;
        return index;
    }


    int matching(String s1, String s2) {
        if (s1.equals(s2)) return 1;
        else return 0;
    }


    public static void main(String args[]) {
        Main password_checker = new Main();
        Scanner user_input = new Scanner(System.in);
        String input = null;
        int validYesNo = 0, passwdLeng = 0,matchYesNo=0;
        while(matchYesNo==0) {
            while (validYesNo == 0) {
                while (passwdLeng < 7 || passwdLeng > 17) {
                    password_checker.displyrules();
                    System.out.println("Password:");
                    input = user_input.next();
                    passwdLeng = input.length();
                }

                password_checker.password = input;
                password_checker.passwordLength = input.length();

                int index = 0;
                for (int i = 0; i < password_checker.passwordLength; i++) {
                    index = password_checker.checkChar(password_checker.password.charAt(i));
                    password_checker.charCount[index]++;
                }

                validYesNo = password_checker.checker();
                if (validYesNo == 0) {
                    passwdLeng = 0;
                    for (int i = 0; i < 5; i++) {
                        password_checker.charCount[i] = 0;
                    }
                }//reset variables
            }

            System.out.println("Confirm Password:");
            input = user_input.next();
            password_checker.secondPassword = input;

            matchYesNo = password_checker.matching(password_checker.password, password_checker.secondPassword);
            if (matchYesNo == 0) {
                validYesNo = 0;
                passwdLeng = 0;
                for (int i = 0; i < 5; i++) {
                    password_checker.charCount[i] = 0;
                }
            }//reset variables
        }
        password_checker.displySucess();
    }
}




