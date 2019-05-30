package LQBMONI;

public class NO4 {

	static void print(int n) 
	{
		String s = "";
		for (int i = 0; i < n - 1; ++i) {
			for (int j = 0; j <= n + i - 1; ++j) {
				if (j==n-i-1) {
					s += "*";
				} else if (j == n + i - 1) {
					s += "*";
				} else {
					s += " ";
				}
			}
			s += "\n";
		}
		for (int i = 0; i < n * 2 - 1; ++i) {
			s += "*";
		}
		System.out.println(s);
	}
	public static void main(String[] args) {
		for (int i = 1; i <= 16; i *= 2) {
			print(i);
		}
	}
}
