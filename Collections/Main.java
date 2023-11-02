package Collections;

import Serialization.Car;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //SETler aynı veriyi 1 kere tutar.

        //HASHSET
        //HashSet, bir nesneyi en başta ekler. equals() metodu, nesnenin tablo konumunu belirledikten sonra çağrılır.
        //equals() metodu, iki nesnenin birbirine eşit olup olmadığını belirler. Eğer iki nesne eşitse, HashSet, nesneyi eklemez.
       HashSet<Integer> hSet = new HashSet<>();
        hSet.add(10);
        hSet.add(10); //ilk eklenen 10 verisinin üstüne yazdı ve mükrerrer kaydı engelledi.
        hSet.add(null);

        //System.out.println(hSet.contains(20));
        // hSet.clear(); //tamamini siler.
        //HashSet<Integer> newH = (HashSet) hSet.clone();
        // System.out.println(newH.contains(10));
        //yazdirirken foreach ya da iterator kullanilir.
       /* for (Integer sayi : newH){
            System.out.println(sayi);
        }*/

        //Iterator ile kullanim
       /* Iterator<Integer> itr = hSet.iterator();
        while(itr.hasNext()){
           // System.out.println(itr.next());
        }*/


        //LinkedHashSet -> giren degerler sirayla cikar
        //default olarak 16 boyutundadır. 17.eleman eklendiğinde boyut 32 ye cıkar.
        LinkedHashSet<Integer> lSet = new LinkedHashSet<>();
        lSet.add(10);
        lSet.add(20);
        lSet.add(30);

        Iterator<Integer> iterator = lSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //TreeSet
        //giris cikis sirasini ozel olarak kendimiz bunun sirasini belirlemek istersek
        //treeSet kullanilir.

        OrderByNoteComparable order = new OrderByNoteComparable();
        TreeSet<Student> students = new TreeSet<>(order.reversed()); //sırayi ters cevirir.
        students.add(new Student("Sabit",47));
        students.add(new Student("Ahmet",72));
        students.add(new Student("Damla",79));
        students.add(new Student("Muhammet",71));

        for (Student std : students){
            System.out.println(std.getName());
        }

        //ArrayList
        //List interfacesi Java 5 ile generic olmustur. 5'ten önce Object tipinde tutuyordu.
        // Veriler gelis sirasina gore(ordered) tutulur.
        //List-Dizi donusumu yapılabilir.
        //Default boyutu 10 dur. Overflow oldukca 2 kat kapasite acar.
        //Esnek ancak cost yüksektir.
        //Araya ekleme veya silme işlemleri yapılması durumunda kaydırma işlemleri yapılması gerekir. Bu durum performansı düşürür.
        //List Interface'inden kalıtım alan sınıflarda, tekrarlı (duplicate) veya null değerli elemanlar tutulabilir.
        //ArrayList sınıfı thread-safe değildir. Bir ArrayList’e aynı anda birden fazla thread erişebilir. Bu durum veri bütünlüğünü bozar.
        // toArray fonksiyonu parametresiz çağırırsanız Object tipinde bir dizi döner.
        // toArray fonksiyonuna hangi tipte bir dizi oluşturmak istiyorsak,
        // o tipten bir nesne üretip parametre olarak göndeririz.
        // String tipinden bir dizi almak istediğimiz için "new String[0]" şeklinde bir nesne üretip, "toArray" fonksiyonuna gönderdik.
        // Kapasitesini manuel olarak arttırmak icin ensureCapacity() kullanılır.


        //LinkedList
        // Her eleman önceki ve sonraki elemanını işaret edecek şekilde iki yönlü bir ilişki kurulmuştur.
        // LinkedList’te eleman silme veya araya eleman ekleme durumlarında kaydırma işlemi yapılmaz
       // Her eleman önceki ve sonraki elemanını işaret edecek şekilde iki yönlü bir ilişki kurulmuştur.
        //LinkedList, hem List interface'inden hem Queue (Kuyruk) interface'inden miras alan bir sınıftır.
        //Listenin ben başına hem sonuna eleman eklenip çıkarılabilir,

        //Collections.frequency() bir ögenin kac kez gectigini belirler

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println(Collections.frequency(list,1));
   

        //VECTORS
        /*
        * Klasik programlama eyleminde array (dizi) çok önemli bir rol oynar.
        *  Ancak, array’in uzunluğu; yani bileşenlerinin sayısı array bildiriminde belirleniyor ve bu uzunluk daha sonra değiştirilemiyordu.
        * Bazı uygulamalarda, bu özelik ciddi bir handikap oluşturur.
        * Java 2, bu sorunu çözmek için Vector sınıfını ve benzer işi yapan ArrayList sınıfını ortaya koydu.
        *  Her iki sınıfta, diziye yeni öğeler eklenir ya da varolan öğeler silinirse, dizinin uzunluğu kendiliğinden değişir. Tabii, bu değişimin bellek kullanımı ve zaman açısından bir bedeli (karmaşa – complexity) vardır. Ama, java programcısı bu işleri yapan yordamları kendisi yazmak zorunda değildir.
        * Vector ya da ArrayList sınıfına ait nesneler bu işleri kendiliğinden yaparlar.
        * ArrayListlerle aynı ancak arrayListler daha hızlıdır.
        * */

        //QueueLinkedList
        /*
        Ortaya çıkış nedeniyle, Queue bir FIFO (first-in-first-out, ilk giren ilk çıkar) yapısıdır.
        Ancak, Queue ve Collection arayüzündeki metotlar kullanılarak, FIFO yapısı LIFO (last-input-first-output, son giren ilk çıkar) yapısı gibi kullanılabilir.
        *element() : Kuyruğun başındaki öğeyi verir, ama onu kuyruktan atmaz.
        *add(eleman): Parametrede verilen elemanı kuyruğa ekler. İşlemin başarısız olması durumunda hata fırlatır.
        *offer(eleman): Parametrede verilen elemanı kuyruğa ekler. İşlemin başarısız olması durumunda null döner.
        *poll(): Kuyruğun başındaki elemanı kuyruktan çıkartır.
        *peek(): Kuyrukta sıradaki elemana ulaşmak için kullanılır.
         */

        //Queue<String> queue = new LinkedList<>(); //Polimorfizm //FIFO

        //KUYRUK YAPISINI LIFO OLARAK KULLANMAK
        Queue<String> queue2 = Collections.asLifoQueue(new LinkedList<>());
        queue2.add("Ali");
        queue2.add("Ali2");
        queue2.add("Ali3");
        System.out.println(queue2.element());


        //PRIORITY QUEUE
        /*
        * Bir queue kullanırken FIFO mantıgını ezmek istiyorsan kullanılır.
        * LinkedListten farklari kendi iclerinde Comparator alarak siralama yapabiliyor olmalarıdır.
        * Null oge konulamaz.
        * Doğal sırasında olan bir PriorityQueue kuyruğuna, kendi öğeleriyle bağdaşmayan (mukayese edilemeyen) bir nesne konulamaz. Böyle yapılırsa derleyiciden ClassCastException hatası alınır.
        * PriorityQueue kuyruğunun başı (head), kullanılan sıralamaya göre en küçük olan öğedir.
        * PriorityQueue kuyruğunun uzunluğu için bir sınır yoktur; ama yeni öğeler eklendikçe kendi kendine uzunluğunu değiştirebilir; yani kuyruğun sığası otomatik olarak artar.
         * */

        PriorityQueue<String> priortiyQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });

        priortiyQueue.add("Mustafa");
        priortiyQueue.add("Alihan");
        priortiyQueue.add("Çetindağ");
        priortiyQueue.add("Damla");

        for (String s : priortiyQueue){
            System.out.println(s);
        }

        System.out.println(priortiyQueue.element());


        //MAPS
        /*
        * Sıralama garantisi vermez.
        * 1 key 1 valueyi gösterir.
        * Iterator yoktur, cunku Iterable interfacesinden kalıtım almaz.
        * Map Interface’i kullanan sınıflar aşağıdaki metodlara sahiptir;
        * clear: Map içinde bulunan bütün değerleri siler.
        * containsKey (Object key): Belli bir anahtar daha önceden girilmiş mi sorgular.
        * containsValue (Object value):Belli bir obje daha önceden girilmiş mi sorgular.
        * get (Object key): Anahtara karşılık gelen objeyi döndürür.
        * put (Object key, Object value): Anahtar — değer ikilisini kayıt eder.
        * remove (Object key):Belli bir anahtara karşılık gelen değeri siler.
        * size: O zaman kadar kayıt edilmiş anahtar — değer ikili sayısını verir.
        * */

        Map<String,String> country = new HashMap<>();

        country.put("TR","Türkiye");
        country.put("TR","TürkiyeYeni"); //İlk ekleneni ezer ve aynı keyde mükerrer kayıt tutmaz
        country.put("GE","Almanya");
        country.put("EN","İngiltere");

        System.out.println(country.get("TR"));
        country.remove("EN");

        for (String countryKey : country.keySet()){
            System.out.println(countryKey);
        }

        System.out.println("######");

        for (String countryValue : country.values()){
            System.out.println(countryValue);
        }

        //LinkedHashMap && TreeMap
        //LinkedHashMap sırayı garanti eder.
       //TreeMap de comparator ile sıralama yapar.

        LinkedHashMap<Integer,Student> student = new LinkedHashMap<>();
        student.put(102,new Student("Yasin",100));
        student.put(103,new Student("Melih",90));
        student.put(104,new Student("Kerem",80));

        for (Student s : student.values()){
         System.out.println(s.getName());
        }

        System.out.println("####");

     TreeMap<Integer,Student> studentes = new TreeMap<>(new OrderByNoComparator());
     studentes.put(106,new Student("Yasin2",100));
     studentes.put(107,new Student("Melih2",90));
     studentes.put(108,new Student("Kerem2",80));

     for (Student s : studentes.values()){
      System.out.println(s.getName());
     }

     // I/O (Stream) VERİ AKISLARI
     //Veri akımları 2 ana gruba ayrılır
     //  1. => Byte Akımları = Bir dosyadaki verileri byte (8 bit) byte okumayı sağlar.
     // Tüm byte akıs sınıfları abstract sınıflardır.
     //Tüm byte akışı sınıfları, InputStream ve OutputStream soyut (abstract) sınıflardan türetilir.
     //  2. => Karakter Akımları = char char okuyarak gider

     //FILES
 /*    File file = new File("patika.txt");

     try{
      boolean isCreated = file.createNewFile(); //olusturma
      boolean isDeleted = file.delete(); //silme

      //dizin olusturma
      File file2 = new File("patika/test");
      boolean value = file.mkdir();

      if(isCreated){
       System.out.println("File created");
      } else{
       System.out.println("File is already created");
      }
     } catch (IOException e) {
      e.getStackTrace();
     }

     //Dosyadaki elemanları listeleme

     String[] fileList = file.list();
     for (String s: fileList){
      System.out.println(s);
     }
*/
     //InputStream
     /*
     * InputStream sınıfı byte akışını temsil eden bir abstract sınıftır ve Java.io paketinden gelmektedir.
       InputStream abstract bir sınıf olduğu için kendi başına kullanışlı değildir o yüzden InputStream'a ait alt sınıflar veri okumak için kullanılır.
       InputStream alt sınıfları : FileInputStream, ByteArrayInputStream, ObjectInputStream

     //FileInputStream
     Java.io paketinin FileInputStream sınıfı, dosyalardan verileri (bayt cinsinden) okumak için kullanılır.
     InputStream soyut (Abstract) sınıfını miras alır.
     read() : Dosyadan tek baytlık veri okur.
     read(byte[] array) : dosyadan verileri bayt cinsinde okur ve belirtilen dizide depolar.
     * available() : okunabilir bayt sayısını verir.
     * skip() : belirtilen değer kadar byte atlar.
     * FileInputStream input = new FileInputStream(stringPath); Dosya Yolu kullanma
     * FileInputStream input = new FileInputStream(stringPath); Nesne kullanma
     * */
/*
     try { FileInputStream input = new FileInputStream("input.txt");
      // available () => Kullanılabilir bayt sayısını verir System.out.println("Kullanılabilir bayt sayısı : " + input.available());
      // 5 byte atlanacaktır input.skip(5); System.out.println("5 bytelık veri atlandı : ");
      System.out.println("Dosyadaki veriler: ");

       // İlk baytı okur
       int i = input.read();

      while (i != -1) { // Byte to char System.out.print((char) i); // Dosyadan sonraki baytı okur
       i = input.read();
      }

      input.close();

     }
     catch (Exception e) {
          e.getStackTrace();
       }
*/

     //FileOutputStream
     /*
     * Java.io paketinin FileOutputStream sınıfı, dosyalara veri (bayt cinsinden) yazmak için kullanılabilir.
     * OutputStream soyut sınıfını genişletir.
     * // Including the boolean parameter FileOutputStream output = new FileOutputStream(String path, boolean value);
        // Not including the boolean parameter FileOutputStream output = new FileOutputStream(String path);
        * steğe bağlı bir boolean parametresi gönderilir.
        * Bu parametre True olarak ayarlanırsa, yeni veriler dosyadaki mevcut verilerin sonuna eklenecektir. Aksi takdirde, yeni veriler dosyadaki mevcut verilerin üzerine yazar.
        * FileOutputStream output = new FileOutputStream(File fileObject);
     * */

     /*
     * String data = "Patika ile Java Öğreniyorum !!";
     *  try { FileOutputStream output = new FileOutputStream("output.txt");
     *  byte[] array = data.getBytes();
     * output.write(array);
     * output.close();
    */


     //ByteArrayInputStream
     /*
     * byte türündeki array girdilerini okuyan bir stream sağlar.
     * */
/*
     byte[] array = {1,2,3,4,54,64};
     ByteArrayInputStream inputStream = new ByteArrayInputStream(array);
     // ByteArrayInputStream inputStream = new ByteArrayInputStream(array,2,4); // 2 den basla 4 eleman getir.
     System.out.println("Kullanilabilir byte sayısı : "  + inputStream.available());
     inputStream.skip(2);
     int i = inputStream.read();
     while(i!=-1){
      System.out.println(i);
       i = inputStream.read();
     }
     try {
      inputStream.close();
     } catch (IOException e) {
      throw new RuntimeException(e);
     }
*/
/*
      //ByteArrayOutputStream
      String data = "Java 102 Lectures";
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      byte [] dataByteArray =  data.getBytes();
     try {
      output.write(dataByteArray);
     } catch (IOException e) {
      throw new RuntimeException(e);
     }
*/
     //Serialization
     /*
     * Bir nesneyi dosyaya atıp dosyadan okuma yaparken attıgımız nesneyi dosyadan geri okurken,
     *  nesnenin türünü bilemiyor dolayısıyla serialization kullanilir.
     * Bunlar ObjectIput ve Output Streamler ile yapılır.
     * */
/*
     Car c1 = new Car("Audi","A6");

     //YAZMA
     try {
      FileOutputStream outputFile = new FileOutputStream("car.txt"); //dosyaya atılacagı icin dosyayi belirttik.
      ObjectOutputStream out = new ObjectOutputStream(outputFile); //dosyayı aktardik
      out.writeObject(c1); //dosyaya yazdık
      out.close();
     } catch (IOException e) {
      throw new RuntimeException(e);
     }

 */

/*
     //OKUMA
     try {
      FileInputStream inp = new FileInputStream("car.txt");
      ObjectInputStream inpStream = new ObjectInputStream(inp);
      Car readenCar = (Car) inpStream.readObject();
      System.out.println(readenCar.getBrand() + readenCar.getModel());
      inp.close();
      inpStream.close();
     } catch (Exception e) {
      e.printStackTrace();
     }

*/
     //BufferedInput/Output Streams
     /*
      * Dosyadan cok fazla veri okuması yapılacagı zaman;
      * (byte cinsinden) daha verimli okuma icin
      * hafıza ve program arasına ara bellek ekleyerek tampon görevi görür,
      * ve okuma islemlerini hzilandırır.
      * Hafıza kullanımını azaltır.
      */
/*
     try {
      FileInputStream FileInput = new FileInputStream("patika.txt");
      BufferedInputStream buffInput = new BufferedInputStream(FileInput); //FileInputa destekleyici olarak olusturduk.
      int datas = buffInput.read();
      while(i != -1){
       System.out.println((char)i);
       i = buffInput.read();
      }

     } catch (Exception e) {
      throw new RuntimeException(e);
     }
*/

     //PrintStream
     /*
     * Diğer çıktı akışlarından farklı olarak, PrintStream ilkel verileri (tamsayı, karakter) bayt yerine metin biçimine dönüştürür.
     * Daha sonra bu biçimlendirilmiş verileri çıktı akışına yazar.
     * Ayrıca, PrintStream sınıfı herhangi bir girdi / çıktı istisnası (exception) atmaz.
     *  Bunun yerine, içindeki herhangi bir hatayı bulmak için checkError() metodunu kullanmamız gerekir
     * Direkt çıktı verme amaclı kullanılır.
     * */

      /*Java’daki String.valueOf() metodu, int, double, char gibi non-String değişkenleri
      veya nesneleri yeni oluşturulan bir String nesnesine dönüştürmek için kullanılır
      */

    /* try {
      PrintStream outputPrint = new PrintStream("car.txt");
      outputPrint.print("123"+123);
     } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
     }*/

     //Reader sınıfı ve InputStreamReader
     /*
     *Reader sınıfı, karakter akışları ile çalışmak için kullanılır.
     *Karakter akışları, metin verilerini okumak ve yazmak için kullanılır.
     * InputStreamReader sınıfı, bayt cinsinden verileri karakter cinsinden verilere dönüştürmek için kullanılabilir.
     * Soyut Reader sınıfını genişletir.
     * InputStreamReader sınıfı, diğer giriş akışlarıyla (Input Streams) çalışır.
     *  Bayt akışları ve karakter akışları arasında bir köprü olarak da bilinir.
     *  Bunun nedeni, InputStreamReader'ın giriş akışındaki baytları karakter olarak okumasıdır.
      * Giriş akımından byte okur, onları istenen charset'e dönüştürür.
      * */
     /*try {
      FileInputStream inputStreams = new FileInputStream("car.txt");

       InputStreamReader inputReader = new InputStreamReader(inputStreams, StandardCharsets.UTF_8);

      int ks= inputReader.read();

      while(ks != -1){
       System.out.println((char) i ); //okuma düzgün sekilde saglandi.
        //burada byte seklinde oldugu ve charset belirlenmedigi icin duzgun pokuma saglanmıyor ve reader sınıfı kullanıyoruz.
       i = inputReader.read();
      }
     } catch (Exception e) {
      throw new RuntimeException(e);
     }*/


     //OutputStreamWriter
     /*
     //WRITER SINIFI
     * Java.io paketinin Writer sınıfı, bir karakter akışını temsil eden soyut bir üst sınıftır.
     * Java.io paketinin OutputStreamWriter sınıfı,
     * karakter biçimindeki verileri bayt biçimindeki verilere dönüştürmek için kullanılabilir.
     * Writer soyut sınıfını genişletir.
     * */

     /*String data1 = "Aaaa";
     try {
      FileOutputStream fileOut = new FileOutputStream("out.txt");
      OutputStreamWriter fileWriter = new OutputStreamWriter(fileOut,StandardCharsets.UTF_8);
      fileWriter.write(data1);
      fileWriter.close();
      fileOut.close();
     } catch (Exception e) {
      throw new RuntimeException(e);
     }*/


     //FileReader ve FileWriter
     /*
     * FileReader : FileReader sınıfı, dosyalardan verileri (karakter olarak) okumak için kullanılabilir. InputStreamReader sınıfını genişletir.
     * FileWriter : FileWriter sınıfı, dosyalara (karakter olarak) veri yazmak için kullanılabilir. OutputStreamWriter sınıfını genişletir.
     * */


     //BufferedReader
     /*
     * BufferedReader, 8192 karakterlik bir dahili arabellek tutar.
     *  BufferedReader'daki okuma işlemi sırasında, diskten bir yığın karakter okunur ve dahili tamponda saklanır
     * ve dahili tampondan karakterler ayrı ayrı okunur.
     * Böylelikle diskle iletişim sayısı azalır.
     * BufferedReader kullanarak karakterleri okumak daha hızlı olmasının nedeni budur.

     * Örnek : FileReader file = new FileReader("input.txt"); BufferedReader input = new BufferedReader(file);
     * * */


     // THREADS
     /*
     * Java’da herhangi bir uygulamayı çalıştırdığımızda varsayılan olarak ana (main) bir iş parçacığı (Thread) ayağa kaldırılır.
     *  Bu ana iş parçacığına ek olarak yazılımcılarda alt iş parçacıkları çalıştıralabilir. Bundan zaten bahsetmiştik.
     * Java’da iş parçacığı oluşturmak için “Thread” isminde bir sınıf bulunmaktadır. Böylece, basit anlamda iş parçacığı açmış oluruz. Tabi, unutmamak lazım Thread açmak sisteme maliyeti olan bir iştir.
     * Sürekli Thread üretmek kaynak kullanımını olumsuz etkiler. Bu nedenle bu sorunu çözmek Thread Pooling kavramı vardır.
     * Bu maliyetli nesneler ilk başta belli bir miktarda yaratılır ve hazır durumda olacak şekilde havuza konulur.
     * Thread ihtiyacı olanlar bu havuzdan bir Thread’i kullanır ve sisteme geri iade eder. Böylece, performans kazancı yanı sıra kaynak kullanımı da iyi bir hale getirilir.
     * Thread sınıfı ya da Runnable interfacesi kullanarak threadler olusturulabilir.
     * Thread.currentThread() ile o anda aktif olarak çalışan iş parçacığının referansını alabiliyoruz.
     * Burada aldığımız Thread nesnesi iş parçacığı içinde çalıştırılan kodu ifade eder.
     * Thread sınıfı, Runnable interfacesini implemente eder.
     * Threadi calıstırmak icin start metodu kullanılır.
     * */

    /* Counter c = new Counter("A Thread");
     Counter c2 = new Counter("B thread");
     c.start();
     c2.start();
 */
     CounterRunnable counterRunnable = new CounterRunnable("First Thread");
     CounterRunnable counterRunnable2 = new CounterRunnable("Second Thread");
     CounterRunnable counterRunnable3 = new CounterRunnable("Third Thread");

     Thread thread = new Thread(counterRunnable);
     Thread thread2 = new Thread(counterRunnable2);
     Thread thread3 = new Thread(counterRunnable3);
     thread.start();
     thread2.start();
     thread3.start();


    }

}
