
public class SlashMap<K, V> implements Mappable<K, V> {

	private Entry<K, V>[] buckets;
	
	public SlashMap() {
		buckets = new Entry[3];
	}
	
	@Override
	public void put(K key, V value) {
		int index = getIndexForKey(key);
		Entry<K, V> entry = buckets[index];
		//System.out.println(index);
		if(entry != null) {
			boolean complete = false;
			while(!complete) {
				if(key.equals(entry.getKey())) {
					entry.setValue(value);
					complete = true;
				} else if(entry.getNext() == null) {
					entry.setNext(new Entry<K, V>(key, value));
					complete = true;
				}
			}
		} else {
			buckets[index] = new Entry<K, V>(key, value);
		}
	}

	@Override
	public V get(K key) {
		int index = getIndexForKey(key);
		Entry<K, V> entry = buckets[index];
		while(entry != null && !key.equals(entry.getKey()))
			entry = entry.getNext();
		return entry != null ? entry.getValue() : null;
	}

	@Override
	public boolean containsKey(K key) {
		int index = getIndexForKey(key);
		Entry<K, V> entry = buckets[index];
		while(entry != null && !key.equals(entry.getKey()))
			entry = entry.getNext();
		return entry != null ? true : false;
	}

	@Override
	public void clear() {
		buckets = new Entry[256];
	}

	@Override
	public void removeValue(Object key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		
	}
	
	public int getIndexForKey(K key) {
		int bucketIndex = key.hashCode();
        return bucketIndex & (buckets.length - 1);
    }

}
