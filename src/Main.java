
public class Main {

	public static void main(String[] args) {
		SlashMap<String, Integer> map = new SlashMap<String, Integer>();
		
		map.put("Harvey", 23);
		map.put("Matt", 50);
		map.put("Peter", 33);
		
		System.out.println(map.get("Harvey"));
		System.out.println(map.get("Matt"));
		System.out.println(map.get("Peter"));
		System.out.println(map.get("John"));
	}
	
}
