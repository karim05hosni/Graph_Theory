public class HashTable_chaining {
    private int size;
    private int n;
    public LinkedLists[] table;

    public HashTable_chaining(int size) {
        this.size = size;
        this.table = new LinkedLists[size];
        for (int i = 0; i < size; i++) {
            table[i] = null;
        }
    }
    // hash
    public int hash(int x){
        int index = ((782349 * x + 98367045) % 1294967291) % size;
        return index;
    }
    // insert
    public void insert(int value) {
        int index = hash(value);
        if (table[index] == null) {
            table[index] = new LinkedLists();
            table[index].append(value);
        } else {
            table[index].append(value);
        }
        n++;
    }
    // insert at key
    public void insertAtKey(int key, int value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedLists();
            table[index].append(value);
        } else {
            table[index].append(value);
        }
    }
    // lookup
    public boolean lookup(int value) {
        int index = hash(value);
        if (table[index] == null) {
            return false;
        } else {
            if (table[index].search(value) == value){
                return true;
            }
        }
        return false;
    }
    // display
    public void display() {
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.print("Slot " + i + ": ");
                table[i].display();
                System.out.println();
            } else {
                System.out.print("Slot " + i + ": Empty");
            }
        }
    }
    // display specific slot
    public void displaySlot(int slot) {
        if (table[slot] != null) {
            table[slot].display();
            System.out.println();
        } else {
            System.out.print("Empty");
        }
    }
    // access by key
    public void accessByKey(int k){
        int index = hash(k);
        if (table[index] != null) {
            System.out.println(k+"=>");
            table[index].display();
        }
    }
    public static void main(String[] args) {
        HashTable_chaining HT = new HashTable_chaining(10);
        HT.insert(23);HT.insert(66);HT.insert(99);HT.insert(234);
        HT.insert(99292);HT.insert(45657);HT.insert(24115);HT.insert(676585);
        HT.insert(78456);HT.insert(2354);HT.insert(911123122);HT.insert(2);
        HT.insert(965);HT.insert(0);
        HT.display();
        System.out.println(HT.lookup(234));
    }
}
