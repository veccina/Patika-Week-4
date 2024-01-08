import java.util.Arrays;

public class MyList<T> {
    private T[] array; // Generic dizi (array) veri yapısı
    private int size; // Dizideki eleman sayısı
    private static final int DEFAULT_CAPACITY = 10; // Varsayılan kapasite

    public MyList() {
        this(DEFAULT_CAPACITY); // Varsayılan kapasite ile liste oluşturma
    }

    public MyList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0"); // Kapasite 0 veya daha küçükse istisna fırlat
        }
        array = (T[]) new Object[capacity]; // Dizi oluşturma
        size = 0; // Eleman sayısını sıfırlama
    }

    public int size() {
        return size; // Eleman sayısını döndürme
    }

    public int getCapacity() {
        return array.length; // Listenin mevcut kapasitesini döndürme
    }

    public void add(T data) {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity); // Dizi kapasitesini iki katına çıkarma
        }
        array[size++] = data; // Veriyi dizinin sonuna ekleme
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null; // Geçersiz indis durumunda null döndürme
        }
        return array[index]; // Belirtilen indisteki elemanı alma
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null; // Geçersiz indis durumunda null döndürme
        }
        T removedData = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1]; // İlgili indisteki elemanı kaldırma ve diğer elemanları kaydırma
        }
        array[size - 1] = null;
        size--;
        return removedData;
    }

    public T set(int index, T data) {
        if (index < 0 || index >= size) {
            return null; // Geçersiz indis durumunda null döndürme
        }
        T oldData = array[index];
        array[index] = data; // Belirtilen indisteki elemanı güncelleme
        return oldData;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < size - 1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString(); // Listeyi dize (string) olarak temsil etme
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return i; // Verinin ilk bulunduğu indis numarasını döndürme
            }
        }
        return -1; // Veri bulunamazsa -1 döndürme
    }

    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(data)) {
                return i; // Verinin son bulunduğu indis numarasını döndürme
            }
        }
        return -1; // Veri bulunamazsa -1 döndürme
    }

    public boolean isEmpty() {
        return size == 0; // Liste boş mu kontrolü
    }

    public T[] toArray() {
        return Arrays.copyOf(array, size); // Listeyi bir dizi olarak döndürme
    }

    public void clear() {
        Arrays.fill(array, null); // Tüm elemanları temizleme
        size = 0; // Eleman sayısını sıfırlama
    }

    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || start >= size || finish < 0 || finish >= size || start > finish) {
            throw new IllegalArgumentException("Invalid start and finish indices"); // Geçersiz başlangıç ve bitiş indisleri için istisna fırlatma
        }
        MyList<T> sublist = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            sublist.add(array[i]); // Belirtilen aralıktaki elemanları içeren yeni bir alt liste oluşturma
        }
        return sublist;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1; // Belirtilen verinin listede bulunup bulunmadığını kontrol etme
    }
}