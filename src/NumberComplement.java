public class NumberComplement {
    static int findComplement(int num) {
        String rs = Integer.toBinaryString(num);
        StringBuffer result = new StringBuffer();
        for(int i = 0;i < rs.length();i++){
            if(rs.charAt(i) == '0'){
                result.append('1');
            }
            else{
                result.append('0');
            }
        }
        System.out.println(rs);
        System.out.println(result);
        int r = Integer.valueOf(new String(result),2);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(1));
    }
}
