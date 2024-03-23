package livraria;

public class TesteVarArgs {
	public static String[] recebeStrings(String...palavras) {
		return palavras;
	}
	public static void main(String[] args) {
		String[] palavras = recebeStrings("oi", "ola", "hehe", "haha", "jjj", "jhhs");
		for(String p:palavras) {
			System.out.println(p);
		}
	}
}
