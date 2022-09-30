import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        // 回答パターン生成
        Scanner scan = new Scanner(System.in);
        for(;;){
        int Q1 = new Random().nextInt(10);
            int Q2 = 0;
            for(;;){
                int x = new Random().nextInt(10);
                if(x == Q1){
                    continue;
                } else {
                    Q2 = x;
                    break;
                }
            }
            int Q3 = 0;
            for(;;){
                int y = new Random().nextInt(10);
                if(y == Q1||y == Q2){
                    continue;
                } else {
                    Q3 = y;
                    break;
                }
            }
            // 回答公開用文字列
            String SQ1 = String.valueOf(Q1);
            String SQ2 = String.valueOf(Q2);
            String SQ3 = String.valueOf(Q3);
            String Answer = SQ1+SQ2+SQ3;
            System.out.println("[ヌメロン]");
            for (int i = 0; i < 10; i++) {
                int eat = 0;
                int bite = 0;
                int x = 0;
                int y = 0;
                int z = 0;
                // 入力確認            
                System.out.println("残り回答権"+(10-i)+"回");
                for(;;) {
                System.out.print("0から9までの整数を入力してください(重複禁止) ->");
                    int num1 = scan.nextInt();
                    if (num1 < 0 || num1 >= 10) {
                        System.out.println("指示と異なる数値が入力されました。もう一度入力しなおしてください。");
                    } else {
                        System.out.println("1桁目:" + num1);
                        x = num1;
                        if(num1 == Q1){
                            eat++;
                        } else if(num1 == Q2 || num1 == Q3){
                            bite++;
                        }
                        break;
                    }
                }
                for(;;) {
                System.out.print("2桁目を入力してください ->");
                    int num2 = scan.nextInt();
                    if (num2 < 0 || num2 >= 10) {
                        System.out.println("指示と異なる数値が入力されました。もう一度入力しなおしてください。");
                    } else if(num2 == x){
                        System.out.println("重複しています。もう一度入力しなおしてください。");
                    } else {
                        System.out.println("2桁目:" + num2);
                        y = num2;
                        if(num2 == Q2){
                            eat++;
                        } else if(num2 == Q1 || num2 == Q3){
                            bite++;
                        }
                        break;
                    }
                }
                for(;;) {
                System.out.print("3桁目を入力してください ->");
                    int num3 = scan.nextInt();
                    if (num3 < 0 || num3 >= 10) {
                        System.out.println("指示と異なる数値が入力されました。もう一度入力しなおしてください。");
                    } else if(num3 == x || num3 == y){
                        System.out.println("重複しています。もう一度入力しなおしてください。");
                    } else {
                        System.out.println("2桁目:" + num3);
                        z = num3;
                        if(num3 == Q3){
                            eat++;
                        } else if(num3 == Q1 || num3 == Q2){
                            bite++;
                        }
                        break;
                    }
                }
                String A1 = String.valueOf(x);
                String A2 = String.valueOf(y);
                String A3 = String.valueOf(z);
                String Alist = A1+A2+A3;
                System.out.println("あなたの回答は->" + Alist);
                // 正誤判定 3eatならクリア
                if(eat==3){
                    System.out.println("ゲームクリア！");
                    System.out.println("------------------------------------");
                    break;
                } else {
                    System.out.println(eat + "イート、" + bite + "バイトです");
                    System.out.println("------------------------------------");
                    eat = 0;
                    bite = 0;
                    x = 0;
                    y = 0;
                    z = 0;
                }
            }
            System.out.println("正解は「" + Answer + "」でした");
            System.out.println("ゲームを終了しますか？");
            System.out.println("yes -> 1 : no -> 0");
            int ToF = scan.nextInt();
            System.out.println("------------------------------------");
            if(ToF == 1){
                System.out.println("お疲れ様でした、ゲームを終了します");
                scan.close();
                break;
            }
        }
    }
}
