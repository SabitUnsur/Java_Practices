package Collections;

public class OrderMatic implements Runnable{

    private int orderNo = 0 ;

    private final Object lock = new Object(); //C++ mutex mantigi.

    public OrderMatic() {
        this.orderNo = 1;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //SYNCHRONIZED 1.YOL

        /*synchronized (lock){
            //Threadin biri geldiğinde kitler ve korumaya alır, diğer threadin erişimine izin vermez.
            this.orderNo ++ ;
            System.out.println("Thread : " + Thread.currentThread().getName() + "Order No : " +  this.orderNo);
        }*/

        //2.YOL
        increaseOrder();
    }

    public synchronized void increaseOrder(){
        this.orderNo ++ ;
        System.out.println("Thread : " + Thread.currentThread().getName() + "Order No : " +  this.orderNo);
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }
}
