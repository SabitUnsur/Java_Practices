package Collections;

public class CounterRunnable implements Runnable{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public CounterRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "sayaci basladi!");
        for (int i = 0 ; i<100;i++){
            System.out.println(this.getName() + " : " + i);
        }
    }
}
