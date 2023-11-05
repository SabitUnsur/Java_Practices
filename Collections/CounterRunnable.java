package Collections;

public class CounterRunnable implements Runnable{

    private int Id;
    private String name;

    private  boolean isRun = true;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CounterRunnable(String name,int id)
    {
        this.name = name;
        this.Id = id;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "sayaci basladi!");
        int i = 0;
        while(isRun) {

                try {
                    Thread.sleep(1000L * this.Id);
                    System.out.println(this.getName() + " " + i++);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

        }

    }

    public void stop(){
        this.isRun = false;
    }
}
