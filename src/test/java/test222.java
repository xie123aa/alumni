public class test222 {
    public static void main(String[] args) {
        String a="\\alumni-0.0.1-SNAPSHOT\\upload";
        System.out.println(a);
      String b=a.replaceAll("alumni-0.0.1-SNAPSHOT\\\\", "");

        System.out.println(b);

    }
}
