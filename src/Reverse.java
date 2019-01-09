public class Reverse {
    public int reverse(int x) {
        boolean flag = false;
        long result;
        StringBuilder temp = new StringBuilder(String.valueOf(x));
        if(x < 0) {
            temp.deleteCharAt(0);
            flag = true;
        }
        temp.reverse();
        if(flag){
            result = Long.valueOf(temp.toString()) * -1;
        }
        else{
            result = Long.valueOf(temp.toString());
        }
        if(result >= Math.pow(2,31) * -1 && result <= Math.pow(2,31) - 1){
            return (int)result;
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args) {
        Reverse a = new Reverse();
        System.out.println(a.reverse(-2147483648));
    }
}
