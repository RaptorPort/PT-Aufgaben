package PT_4;

import java.lang.reflect.*;
import java.util.Scanner;

public class Aufgabe1 
{

	private String nameclass;
	static public Scanner sc;
	
	public static void main(String[] args) 
	{
		Aufgabe1 a  = new Aufgabe1();
		try
		{
			Class<?> c  = Class.forName(a.nameclass);
			System.out.println("Klassenname:\n" + a.nameclass + "\n");
			System.out.println("Superklassen:\n" + a.superklasse(c));
			System.out.println("Konstruktor :\n" + a.constructor(c));
			System.out.println("Methoden:\n"+ a.methoden(c));
			System.out.println("Felder:\n" + a.feld(c));
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}

	public Aufgabe1()
	{
		System.out.println("Name der Klasse eingeben:");
		sc = new Scanner(System.in);
		nameclass = sc.nextLine();
	}
	
	public String name(Class<?> c)
	{
		return c.getName();
		
	}

	public String superklasse(Class<?>c)
	{
		StringBuilder a = new StringBuilder();
		Class <?> sc = c.getSuperclass();
		while(sc != null)
		{
			a = a.append((sc.getName()+ "\n"));
			sc = sc.getSuperclass();
		}
		return a.toString();
	}
	
	private String constructor(Class<?> c) 
	{
		StringBuilder a = new StringBuilder();
		Constructor<?>[] c1 ;
		try
		{
			c1 = c.getDeclaredConstructors();
			for(Constructor<?> i: c1)
			{
				a.append((i.toGenericString()+"\n"));
			}
			return a.toString();
		}
		catch(SecurityException e)
		{
			e.printStackTrace();
			return null;

		}
	}
	
	public String methoden(Class<?> c)
	{
		Method[] m;
		StringBuilder a = new StringBuilder();
		try
		{
			m = c.getDeclaredMethods();
			for(Method i : m)
			{
				a.append((i.toGenericString()+"\n"));
			}
			return a.toString();
		}
		catch(SecurityException e)
		{
			return null;
		}
	}
	
	public String feld(Class<?> c)
	{
		StringBuilder a = new StringBuilder();
		Field[] f;
		try
		{
			f = c.getDeclaredFields();
			for(Field i : f)
			{
				a.append((i.toGenericString()+"\n"));
			}
			return a.toString();
		}
		catch(SecurityException e)
		{
			return null;
		}
	}
}
