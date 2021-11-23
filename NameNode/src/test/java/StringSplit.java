public class StringSplit {
    public static void main(String[] args) {
        String path = "/user/warehouse/hive";
        String[] paths = path.split("/");

        System.out.println(paths.length);



        for (String splitPath : paths) {
            System.out.println("TRIM:" + splitPath.trim());
            System.out.println(splitPath);
        }
    }
}
