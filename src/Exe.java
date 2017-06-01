/**
 * Created by Johan007 on 2017/6/1.
 */
public class Exe {
    static int[] chopsticks = { 1, 1, 1, 1, 1};
    /**
     * @param args
     */
    public static void main(String[] args) {
// TODO Auto-generated method stub
        HotKey key = new HotKey();
        key.initHotkey(); //初始化按键监听
        for (int i = 0; i < 5; i++) {
                new Thread(new Philosopher(i)).start();
        }
    }

    public static void reset() {
        for (int i = 0; i < 5; i++) {
            chopsticks[i]=1;
        }
    }

    static class Philosopher implements Runnable {

        int tem;
        public Philosopher(int i){
            this.tem=i;
        }
        public void run(){
            while (true) {

                //System.out.println(tem);
                getChopsticks();
                try
                {
                    Thread.currentThread().sleep(1000);//毫秒
                }
                catch(Exception e){}

            }





        }
        public void getChopsticks(){
//        if (tem==0){//如果是第一个哲学家，先用左边的筷子
//            if(getLeft(tem)){
//                if(getRight(tem)){
//                    eating();
//                    freeLeft(tem);
//                    freeRight(tem);
//                }else{
//                    freeLeft(tem);
//                }
//            }else{
//                System.out.println(tem+"无法获得左手边的筷子");
//            }
//        }else{
            if(getRight(tem)){
                if(getLeft(tem)){
                    eating();
                    freeRight(tem);
                    freeLeft(tem);
                }else{
                    //freeRight(tem);
                }
            }else{
                //System.out.println(tem+"无法获得右手边的筷子");
            }
            //}


        }
        public void eating(){
            System.out.println(tem + "开始吃饭");
        }
        public boolean getLeft(int tem){
            if(chopsticks[tem]==1){
                chopsticks[tem]=0;
                System.out.println(tem+"获得左手边的筷子");
                return true;
            }else{
                System.out.println(tem+"不能获得左手边的筷子");
                return false;
            }

        }
        public boolean getRight(int tem){
            int i= (tem+1)%5;
            if(chopsticks[i]==1){
                chopsticks[i]=0;
                System.out.println(tem+"获得右手边的筷子");
                return true;
            }else{
                System.out.println(tem+"不能获得右手边的筷子");
                try {
                    // wait();
                }catch (Exception e){}

                return false;
            }
        }
        public void freeLeft(int tem){
            chopsticks[tem] = 1;
            System.out.println(tem+"左手边筷子已释放！");


        }
        public void freeRight(int tem){
            int i = (tem + 1) % 5;
            chopsticks[i] = 1;
            System.out.println(tem+"右手边筷子已释放！");
        }

    }


}
