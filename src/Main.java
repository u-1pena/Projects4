import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        //中間操作について
        List<String> list = Arrays.asList("apple", "orange", "strawberry");

//        //すべてに[]をつける（ステートレス）
//        list.stream().map(s -> "["+ s + "]")
//        //文字数を返す
//        list.stream().map(s -> s.length())
//        //文字数が６文字以上のものを返す！
//        list.stream().filter(s -> s.length() >= 6 )
//        //文字の長い順に並び替えて表示する！(ステートフル）
//        list.stream().sorted((a, b) -> b.length() - a.length()) //文字の長い順に並び替えて表示する！
        list.stream()
                .filter(s -> s.length() >= 6)
                .map(s -> "[" + s + "]")
                .sorted((a, b) -> b.length() - a.length())
                .forEach(System.out::println);

        //終端操作
        //collectメソッド

        //to listを使った場合

        List<String> resultList1 = list.stream().collect(toList());
        System.out.println("resultList1 =" + resultList1);

        //joiningをつかった例

        String resultList2 = list.stream().collect(joining("-", "<", ">"));
        System.out.println("resultList2 = " + resultList2);
        //countメソッド

        long count = list.stream().count();
        System.out.println("count = " + count);//ストリームの要素を返す

        //anyMatchメソッド
        boolean isMatch =
                list.stream().anyMatch(s -> s.startsWith("o"));
        System.out.println(isMatch ? "Matched!" : "Unmatched!");

        //forEachメソッド
        list.stream()
                .forEach(s -> System.out.println("要素の内容 = " + s));

    }
}