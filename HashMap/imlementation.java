package HashMap;
import java.util.LinkedList;

public class imlementation {
    static class HashMap<K, V> { // Fixed generic type parameters (K, V are standard for key-value)
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // Current number of elements in the hash map
        private LinkedList<Node>[] bucketArray;

        @SuppressWarnings("unchecked")
        public HashMap() {
            bucketArray = new LinkedList[4]; // Initial capacity set to 4
            for (int i = 0; i < bucketArray.length; i++) {
                bucketArray[i] = new LinkedList<>();
            }
            size = 0; // Size starts at 0, not 4
        }

        public void put(K key, V value) {
            int bucketIndex = getBucketIndex(key);
            LinkedList<Node> bucket = bucketArray[bucketIndex];
            Node node = getNode(key, bucketIndex);

            if (node == null) {
                bucket.addLast(new Node(key, value));
                size++;
            } else {
                node.value = value; // Update value if key already exists
            }
        }

        public V get(K key) {
            int bucketIndex = getBucketIndex(key);
            Node node = getNode(key, bucketIndex);

            if (node == null) {
                return null; // Return null if key does not exist
            }
            return node.value;
        }

        public V remove(K key) {
            int bucketIndex = getBucketIndex(key);
            LinkedList<Node> bucket = bucketArray[bucketIndex];
            Node node = getNode(key, bucketIndex);

            if (node == null) {
                return null; // Return null if key does not exist
            }

            V value = node.value;
            bucket.remove(node); // Remove the node from the bucket
            size--;
            return value;
        }

        public boolean containsKey(K key) {
            int bucketIndex = getBucketIndex(key);
            Node node = getNode(key, bucketIndex);
            return node != null; // Key exists if node is not null
        }

        private int getBucketIndex(K key) {
            int hashCode = key.hashCode(); // Get the hash code of the key
            return Math.abs(hashCode) % bucketArray.length; // Calculate the bucket index
        }

        private Node getNode(K key, int bucketIndex) {
            LinkedList<Node> bucket = bucketArray[bucketIndex];

            for (Node node : bucket) { // Iterate over the bucket
                if (node.key.equals(key)) { // Use equals() for proper comparison
                    return node;
                }
            }
            return null;
        }

        public static void main(String[] args) {
            // Testing the HashMap
            HashMap<String, Integer> map = new HashMap<>();
            map.put("apple", 1);
            map.put("banana", 2);
            map.put("cherry", 3);

            System.out.println("apple: " + map.get("apple"));
            System.out.println("Contains 'banana': " + map.containsKey("banana"));
            System.out.println("Removed 'cherry': " + map.remove("cherry"));
            System.out.println("Size: " + map.size); // Direct access to size for testing
        }
    }
}
