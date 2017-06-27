
public interface Mappable<K, V> {

	public void put(K key, V value);
	
	public V get(K key);
	
	public boolean containsKey(K key);
	
	public void clear();

	public void removeValue(K key);

	public void remove(K key);
	
	
}
