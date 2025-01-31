public class HashTables {
    private int m;
    private int n = 0;
    public LinkedLists[] arr;
    private int[] keys;
    public HashTables(int size) {
        m = size;
        arr = new LinkedLists[size];
        keys = new int[size];
        for (int i = 0; i < m; i++) {
            arr[i] = new LinkedLists();
        }
    }

    public void insert(int x) {  // Instance method
        insertRec(x, hash(x), hash2(x), 0);
    }
    // public void insert(int x) {  // Instance method
    //     // if ((n / (double) m) >= 0.6) {
    //     //     tableDoubling();
    //     // }
    //     insertRec(x, hash(x), 0);
    // }

    public void display() {
        for (int i = 0; i < m; i++) {  // Join elements with a space and print
            if (arr[i] == null || arr[i].head == null ) {
                continue;
            }
            System.out.print("Vertex: " + arr[i].head.data + " Neighbours: ");
            arr[i].display();
            System.out.println();
        }
    }

    // insert at key
    public void insertAtKey(int key, int x){
        int idx = searchKey(key);
        if(idx != -1) {
            arr[idx].append(x);
        }
        // arr[idx].append(x);
    }

    // search for key at first node in linked list
    public int searchKey(int x) {
        return searchRec(x, hash(x), hash2(x), 0);
    }
    // searchRec
    public int searchRec(int x, int h, int h2, int counter) {
        int key = (h + counter * h2) % m;
        boolean found = false;
        if (key < 0) {
            key += m; // Ensure the index is within bounds
        }
        if (arr[key].size == 0) {
            
            return -1;
        } else {
            // Check if the element is already present in the linked list
            // Node current = arr[key].head;
            // System.out.println("data at first:" +(arr[key].head.data==x));
            if (arr[key].head.data == x){
                // System.out.println("checked");
                // found = true;
                return key;
            }
            if (!found) {
                return searchRec(x, h,h2, counter + 1);
            }
        }
        return -1;
        // return false;
    }


    private int hash2(int x) {  // Secondary hash function for double hashing
        int Index = ((5323498 * x + 389670451) % 2147483629) % m;
        // int Index = 7 - (x%7);
        if (Index <= 0) {
            Index = Index + m; // Ensure h2 is positive
        }
        return Index;
    }
    private void insertRec(int x, int h, int h2,  int counter) {  // Instance method
        int key = (h + counter * h2) % m;
        
        if (key < 0) {
            key += m; // Ensure the index is within bounds
        }
        // Debug statement: 
        // System.out.printf("Trying to insert: "+x+" at index %d (counter=%d)\n", key, counter);
        if (n >= m) {
            System.out.println("Array is full");
            return;
        }
        if (arr[key].size == 0) {
            arr[key].append(x);
            keys[n] = x;
            n++;
        } else {
            // Check if the element is already present in the linked list
            boolean found = false;
            Node current = arr[key].head;
            while (current != null) {
                if (current.data == x) {
                    found = true;
                    break;
                }
                current = current.next;
            }
            if (!found) {
                insertRec(x, h,h2, counter + 1);
            }
        }
    }

    private int hash(int x) {  // Instance method
        int Index = ((782349 * x + 983670457) % 1294967291) % m;
        if (Index < 0){
            Index +=m;
        }
        return Index;
    }

    private int hashnum(int x) {  // Instance method
        return ((3 * x + 37) % 53) % m;
    }

    public LinkedLists accessByKey(int key) {
        return arr[key];
    }

    

    public static void main(String[] args) {
        HashTables HT = new HashTables(10);
        HT.insert(2334);
        HT.insert(35235);
        HT.insert(6474);
        HT.insert(74);
        HT.insert(6);
        HT.insert(298);
        HT.insert(468);
        HT.insert(2986);
        HT.insert(3924124);
        HT.insertAtKey(74, 100);
        HT.insertAtKey(3924124, 7);
        HT.insertAtKey(74, 34);
        HT.insertAtKey(74, 0);
        HT.insertAtKey(6, 80);
        HT.display();
        // HT.displayKeys();
        System.out.println(HT.searchKey(468));

        // System.out.println(HT.n);
        // System.out.println(HT.accessByKey(23));  // Note: This will throw an ArrayIndexOutOfBoundsException if m < 49.
    }
}