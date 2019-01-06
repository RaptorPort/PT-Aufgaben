package PT_4;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.Scanner;

public class KlassenbrowserMY {

	public static void main(String[] args) {
		//Scanner scan = new Scanner(System.in);
		//String s = scan.nextLine();
		try {
			Class<?> c = Class.forName("java.lang.String");
			System.out.println("class " + c.getName() + " {");

			for (Field f : c.getDeclaredFields()) {
				TypeVariable<?>[] typeParameters = c.getTypeParameters();
				if (typeParameters.length < 0) {
					System.out.print("<");
					int i = 0;
			        for (TypeVariable<?> typeParameter : typeParameters) {
			        	if (i != 0)
			        		System.out.print(", ");
			            System.out.print(typeParameter);
			        }
			        System.out.print(">");
				}				
				System.out.print(Modifier.toString(f.getModifiers()) + " " + f.getName());
				System.out.println(";");
				
				
			}
			System.out.println();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
