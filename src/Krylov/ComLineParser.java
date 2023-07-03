package Krylov;

public class ComLineParser {

    String[] keys;
    String[] delimiters;

    public ComLineParser(String[] keys, String[] delimiters) {
        this.keys = keys;
        this.delimiters = delimiters;
    }

    public ComLineParser(String[] keys) {
        this(keys, new String[]{"/", "-"});
    }

    void PrintHelp(String error){
        if(error!=null)
            System.out.println("Command-line error in: " +error);

        System.out.println("формат ком. строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
        System.out.println("   -?  показать Help файл");
        System.out.println("   -r  задать имя входного файла");
        System.out.println("   -w  выполнить вывод в указанный файл");
    }

    void findParametr(String txt){
        System.out.println("find " + txt.substring(2));
    }

    public void Parse(String[] args){
        for (String item: args){
            // проверка наличия правильного разделителя
            boolean isDelimiters = false;
            for (int n = 0; isDelimiters && (n < delimiters.length); n++) {
                isDelimiters = item.regionMatches(0, delimiters[0],0, 1);
            }
            if (!isDelimiters){
                PrintHelp(item);
                return;
            }
            // проверка наличия требования показать Help файл
            if(item.substring(1,2).equals("?")) {
                PrintHelp (null); return;
            }
            // проверка наличия правильного ключа
            boolean isKey = false;
            for (int i = 0; !isKey && (i < keys.length); i++) {
                isKey = item.regionMatches(true, 1, keys[i], 0, keys[i].length());
            }
            if (!isKey){
                PrintHelp(item);
                return;
            }
            findParametr(item);
        }
    }
}
