import java.net.URLDecoder;
import java.net.URLEncoder;

class Test{
    public static void main(String args[]) throws Exception{
        String a = URLDecoder.decode("%EF%A7%9E%EF%BF%BD%EF%BF%BD%EB%BF%AD%E6%8F%B4%D1%89%ED%85%87", "UTF-8");
        System.out.print(a);
    }
}
