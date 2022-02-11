package test;

public class LambdaTest {
    @FunctionalInterface
    interface Calc {
        public int min(int x, int y);
    }

    public static void main(String[] args) {
        test();
    }

    private static void test(){
        new Thread(()->{

            System.out.println("람다 표현식을 사용한 일회용 스레드 생성");

        }).start();

        Calc minNum = (x,y) -> x < y ? x: y;
        System.out.println(minNum.min(6,5));

    }

}
