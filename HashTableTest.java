import java.util.Random;

public class HashTableTest {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(10000));
            Student value = new Student("Student " + i);
            table.put(key, value);
        }

        for (int i = 0; i < table.chainArray.length; i++) {
            int count = 0;
            MyHashTable<MyTestingClass, Student>.HashNode<MyTestingClass, Student> node = table.chainArray[i];
            while (node != null) {
                count++;
                node = node.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }
}
