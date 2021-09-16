package part1.langbasics;

public class Main {
    public static void main(String[] args) {
        sumOfLetters(54321);
    }

    public static void sumOfLetters(int num) {
        int s = 0;
        while(num > 0){
            s += num % 10;
            num /= 10;
        }
        System.out.println(s);
    }
}