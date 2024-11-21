package b_c_pilasYColas.PilasClase;

import java.util.Stack;

public class EjerciciosPilas 
{
	public EjerciciosPilas() {}

	public String invertir(String s)
	{
		Stack<Character> p = new Stack<Character>();
		String resultado = "";

		for(int i = 0; i < s.length(); i++) //n veces
		{
			p.push(s.charAt(i));
		}

		while (!p.isEmpty()) //n veces
		{
			char caracter = p.pop();
			resultado = resultado + caracter; //es un sumatorio de los caracteres -> O(n^2)
		}
		return resultado;
	}

	public String invertir2(String s)
	{
		Stack<Character> p = new Stack<Character>();
		char[] resultado = new char[s.length()];

		for(int i = 0; i < s.length(); i++)
		{
			p.push(s.charAt(i));
		}
		int cont = 0;

		while(!p.isEmpty())
		{
			resultado[cont] = p.pop();
			cont++;
		}
		return new String(resultado);
	}

	public boolean expCorrecta(String s)
	{
		Stack<Character> p = new Stack<Character>();
		boolean error = false;
		int i = 0;

		while (i < s.length() && !error) {
			char c = s.charAt(i);

			if(c == '[' || c == '(' || c == '{') {
				p.push(c);
			}
			else if (c == ']' || c == ')' || c == '}') {
				if (p.isEmpty()) {
					error = true;
				}
				else {
					char x = p.pop();
					if((x == '[' && c == ']') || (x == '{' && c == '}') || (x == '(' && c == ')')) 
					{}
					else {
						error = true;
					}
				}
			}
			i++;
		}
		if (error) {
			return false;
		}
		else if (!p.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}
}
