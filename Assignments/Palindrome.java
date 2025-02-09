public class Palindrome {
    public  void isPalindrome(int num)
{
    int originalNum= num;
    int reverse=0;

    while(num>0){
        int digit = num%10;
        reverse= reverse*10 + digit;
        num=num/10;
    }


    if(originalNum == reverse){
        System.out.println(originalNum+" is Palindrome number");
    }
    else{
        System.out.println(originalNum+" is not Palindrome number");
    }
}}
