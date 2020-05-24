import java.util.Map.Entry;

public class MyMap<K, V> {

	private Entry<K, V>[] buckets;
	private static final int INITIAL_CAPACITY = 16;

	private int size = 0;

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public MyMap() {
		this(INITIAL_CAPACITY);
	}

	public MyMap(int capacity) {
		this.buckets = new Entry[capacity];
	}

	public V put(K key, V value) {
		Entry<K, V> entry = new Entry<K, V>(key, value, null);
		int hashcode = getHashCode(key);
		int index = hashcode % INITIAL_CAPACITY;

		Entry<K, V> existing = this.buckets[index];

		if (existing == null) {
			// if there's no existing value at index
			this.buckets[index] = entry;
			size++;

		} else {
			// if value found at index
			while (existing.next != null) {
				if (key.equals(existing.key)) {
					existing.value = entry.value;
					return entry.value;
				}
				existing = existing.next;
			}
			if (key.equals(existing.key)) {
				existing.value = entry.value;
				return entry.value;
			} else {
				existing.next = entry;
				size++;
			}
		}

		return null;
	}

	public Object get(K key) {
		int hashcode = getHashCode(key);
		int index = hashcode % INITIAL_CAPACITY;

		Entry<K, V> bucket = this.buckets[index];
		while (bucket != null) {
			if (key.equals(bucket.key)) {
				return bucket.value;
			}
			bucket = bucket.next;
		}
		return null;
	}

	private int getHashCode(K key) {
		return key.hashCode();
	}

	public void display() {

		for (Entry<K, V> entrySet : this.buckets) {
			while (entrySet != null) {
				System.out.println("{" + entrySet.key + "=" + entrySet.value + "} ");
				entrySet = entrySet.next;
			}
		}
	}
}
