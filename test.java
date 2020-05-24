
public class test {
	public static void main(String[] args) {
		MyMap<Integer, String> map = new MyMap<Integer, String>(); 
		map.put(1, "Santosh");
		map.put(2,"Vaibhav");
//		map.display();
		System.out.println(map.get(1));
	}
}
