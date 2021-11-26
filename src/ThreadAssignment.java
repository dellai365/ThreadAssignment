public class ThreadAssignment {

    static class Counter {
        void count() {
            //todo implement me
            for (int i=350; i>0; i--){
                System.out.println(i);
            }
            System.out.println("FINISH !");
        }

    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            synchronized (counter){
                counter.count();
            };
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        MyThread t0 = new MyThread(counter);
        MyThread t1 = new MyThread(counter);
        t0.start();
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("DONE !");

    }
}
