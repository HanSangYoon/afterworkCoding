import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class suitableBracket {
    public static void main(String [] args) throws IOException {
        //String str = toStringFunction(new BufferedReader(new InputStreamReader(System.in)));
        recursiveCheckFunction("()))((()()))((()()))((()()))((()()))((()");
    }
    private static String toStringFunction(BufferedReader br) throws IOException {
        StringBuffer sb = new StringBuffer();
        String str_origin;
        while((str_origin = br.readLine()) != null){
            sb.append(str_origin);
        }
        return sb.toString();
    }

    // 올바른 괄호 문자열이냐 아니냐를 점
    private static Boolean isRight(String isStr){
        boolean defaultResult = false;
        int cnt = 0;

        for(int i =0; i < isStr.length(); i++){
            if(isStr.charAt(i) =='(' ){
                cnt ++;
            } else {
                cnt --;
            }

            if(cnt >= 0){
                defaultResult = true;
            }
        }
        return defaultResult;
    }

    //최초의 균형잡힌 문자열의 인덱스를 반환
    public static int firstBalance(String str){
        int cnt = 0;
        for(int o = 0; o < str.length(); o ++){
            if(str.charAt(o) == '('){
                cnt ++;

            } else {
                cnt --;
            }
            if(cnt == 0){
                return o;
            }

        }
        return -1;
    }


    //재귀로 문자열 괄호 검사 수행
    private static String recursiveCheckFunction(String str) {

        String u = "";
        String v = "";

        String resultStr = "";

        if(isRight(str)){
            return str;
        } else {
            // u와 v를 분리시킴
            if(str.length() >=2){
                u += str.substring(0, firstBalance(str) + 1);
                v += str.substring(firstBalance(str) + 1, str.length());
            }

            //u 가 올바른 문자열일 경우
            if(isRight(u)){
                return u + recursiveCheckFunction(v);
            } else {
                resultStr += "(" + recursiveCheckFunction(v) + ")";

                //맨 앞과 맨 뒤를 자름.
                u = u.substring(1, u.length()-1);

                StringBuilder newU = new StringBuilder(u);
                for(int a = 0; a < u.length(); a++){
                    if(u.charAt(a) == '('){
                        newU.setCharAt(a,')');
                    } else {
                        newU.setCharAt(a, '(');
                    }
                }
                resultStr += newU.toString();
                return resultStr;
            }
        }
    }
}