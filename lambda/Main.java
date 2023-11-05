package lambda;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        //LAMBDA EXPRESSIONS
        /*
         * Lambda ifadesi ilk kez Java 8'de tanıtıldı
         * Functional interface’ler, lambda expression’ların kullanılabilmesi için tanımlanırlar.
         * Function interface, içerisinde sadece bir tane abstract metodu olan interface’dir.
         * Eğer ilgili interface’in türetildiği interface’de abstract metot varsa bu durumda da functional interface olur.
         * İçinde bir tane abstract metot olan interfaceler functional interface olarak gecer.
         * functional interface tarafından tanımlanan bir yöntemi implement etmek için kullanılır.
         * */

        // Java 8'den öncesi
     /*Runnable runnable1 = new Runnable() {
      @Override
      public void run() {

       System.out.println("Before 1.8");
      }
     };
     runnable1.run();

     // Java 8'den sonrası
     Runnable runnable2 = () -> System.out.println("1.8");
     runnable2.run();
    }
    */

        //ESKİ KULLANIM
        //Anonim class ornegidir.
        // Ornekte, Maths bir interface ve siz bu interface’i uygulayan anonim bir sınıf oluşturuyoruz.
        // Bu anonim sınıfın transaction metodunu aşırı yükleyerek (override) kendi işleminizi tanımlıyoruz.

        Maths toplama = new Maths() {
            @Override
            public int transaction(int a, int b) {
                return a+b;
            }
        };

        //LAMBDA
        Maths maths = (int a, int b) -> a + b;

        //STREAM API
        /*
        * JDK 8 ile lambda ifadelerinin Java’ya eklenmesi üzerine, yine bununla ilintili olarak Stream API yazılmıştır.
        * Basitçe söylemek gerekirse, koleksiyonlar üzerinde lambda ifadeleri kullanarak işlem yapmamızı sağlayan metotlar eklemiştir.
        * Java.io ile alakası yoktur.
        * Akışlar, verinin nasıl depolanacağıyla ilgilenmez, yalnızca veriyi bir yerden bir yere transfer eder.
         * */

        ArrayList<Integer> list = new ArrayList<>();
        list.add(18);
        list.add(22);
        list.add(39);
        list.add(41);
        list.add(54);
        list.add(63);
        list.add(72);
        list.add(66);

        //Foreach ile kullanım
        //Stream Api ile kullanım
        list.stream().forEach(i-> System.out.println(i));

        list.forEach(i-> System.out.println(i)); //Bu sekilde de olur.

        //Filter ile kullanım
        /*
        * Bu metodu kullanarak akışın elemanlarını filtreleyebiliriz. Predicate turunde bir paramete alır.
        * */
        list.stream().filter(num -> num > 60).forEach(num-> System.out.println(num));

        //distinct() metodu
        /*
        * Bu metot ile akış içinde elemanların en fazla 1 kez yer alması sağlanır. Akıs icinde eleman varsa, ikinci kez yer almaz.
        * */
        list.stream().distinct().forEach(i-> System.out.println(i));


        //sorted() metodu
        /*
        * Bu metot ile akış içindeki elemanlar sıralanır. Sıralama için Comparator türünde bir parametre de alabilir,defaultu kücükten buyuge siralamadir.
        * */
        list.stream().sorted().forEach(i-> System.out.println(i));
        list.stream().sorted(Comparator.reverseOrder()).forEach(i-> System.out.println(i)); //Sıralama için Comparator türünde bir parametre de alabilir ornek

        //limit() metodu
        /*
        * Bu metot ile akış içindeki eleman sayısı sınırlandırılır. Long turunde bir sayi parametre alir.
        * */
        list.stream().limit(3).forEach(i-> System.out.println(i));

        //skip() metodu
        /*
        * Bu metot ile belirli sayida eleman atlanir. Long turunde bir sayi parametre alir.
        * */
        list.stream().skip(3).forEach(i-> System.out.println(i));

        //count() metodu
        /*
        * Akıştaki eleman sayısını döndürür. Akışı sonlandırır, bu metottan sonra baska bir islem yapilamaz,Long turunde bir sayi dondurur.
        * */
        System.out.println(list.stream().count());

        // anyMatch() metodu
        /*
        * Predicate turunde bir parametre alır. Akış içindeki elemanlardan herhangi biri bu koşulu sağlıyorsa true döner.
        * Akışı sonlandırır, bundan sonra bir işlem yapılamaz.
        * */
        System.out.println(list.stream().anyMatch(i->i>60));

        //allMatch() metodu
        /*
        * Burda da tüm elemanları kontrol eder, hepsi koşulu sağlıyorsa true döner.
        * */
        System.out.println(list.stream().allMatch(i->i>60));

        //noneMatch() metodu
        /*
        * Burda da tüm elemanları kontrol eder, hiçbiri koşulu sağlamıyorsa true döner.
        * */

        //map() metodu
        /*
        * Akışın elemanlarını belirli bir fonksiyona göre değiştirmemizi sağlar. Function<T,R> türünde bir parametre alır.
        * */
        list.stream().map(i->i*2).forEach(i-> System.out.println(i)); //Her elemanı 2 ile carpıp yazdırdık.


    }
}
