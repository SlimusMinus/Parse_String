import Krylov.ComLineParser;

public class Main {
    public static void main(String[] args) {

        String[] arks = {"?","r","w"};
        ComLineParser com = new ComLineParser(arks);
        com.Parse(args);
    }
}