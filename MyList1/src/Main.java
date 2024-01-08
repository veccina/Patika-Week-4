public class Main {
    public static void main(String[] args) {
        MyList<Integer> liste = new MyList<>(); // Integer türünde bir MyList örneği oluşturun
        System.out.println("Dizinin Kapasitesi: " + liste.getCapacity()); // Dizinin kapasitesini yazdırın
        System.out.println("Dizideki Eleman Sayısı: " + liste.size()); // Dizideki eleman sayısını yazdırın
        liste.add(10); // Liste öğelerini ekleyin
        liste.add(20);
        liste.add(30);
        liste.add(40);
        System.out.println("Dizideki Eleman Sayısı: " + liste.size()); // Güncellenmiş eleman sayısını yazdırın
        System.out.println("Dizinin Kapasitesi: " + liste.getCapacity()); // Güncellenmiş dizi kapasitesini yazdırın
        liste.add(50);
        liste.add(60);
        liste.add(70);
        liste.add(80);
        liste.add(90);
        liste.add(100);
        liste.add(110);
        System.out.println("Dizideki Eleman Sayısı: " + liste.size()); // Güncellenmiş eleman sayısını yazdırın
        System.out.println("Dizinin Kapasitesi: " + liste.getCapacity()); // Güncellenmiş dizi kapasitesini yazdırın

        System.out.println("2. indisteki değer: " + liste.get(2)); // İndeks 2'deki değeri alın ve yazdırın
        liste.remove(2); // İndeks 2'deki bir öğeyi kaldırın
        liste.add(40); // Değeri 40 olan bir öğe ekleyin
        liste.set(0, 100); // İndeks 0'daki değeri 100 olarak ayarlayın
        System.out.println("2. indisteki değer: " + liste.get(2)); // Güncellenmiş değeri alın ve yazdırın
        System.out.println(liste.toString()); // Listenin içeriğini yazdırın

        System.out.println("İndeks: " + liste.indexOf(20)); // 20 değerinin indeksini bulun ve yazdırın
        System.out.println("İndeks: " + liste.indexOf(100)); // 100 değerinin indeksini bulun ve yazdırın
        System.out.println("Son İndeks: " + liste.lastIndexOf(20)); // 20 değerinin son indeksini bulun ve yazdırın
        Object[] dizi = liste.toArray(); // Listeyi bir diziye dönüştürün
        System.out.println("Object dizisinin ilk elemanı: " + dizi[0]); // Object dizisinin ilk öğesini yazdırın

        MyList<Integer> altListem = liste.sublist(0, 3); // İndeks 0'dan 3'e kadar olan bir alt liste oluşturun
        System.out.println(altListem.toString()); // Alt liste içeriğini yazdırın

        System.out.println("Listemde 20 değeri: " + liste.contains(20)); // Liste 20 değerini içeriyor mu kontrol edin ve yazdırın
        System.out.println("Listemde 120 değeri: " + liste.contains(120)); // Liste 120 değerini içeriyor mu kontrol edin ve yazdırın

        liste.clear(); // Listeyi temizleyin
        System.out.println(liste.toString()); // Temizlenmiş listenin içeriğini yazdırın
    }
}
