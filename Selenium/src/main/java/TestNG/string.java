package TestNG;
import org.testng.annotations.Test;


import day5.DataProviders;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeGroups;
public class string {
	@Test
	public void method()
	{
		String s="Hello Man";
		String p="Hello";
		s.concat("world");
		String a=new String("Super");
		String b=new String("world");
		String t[]=s.split("lo");
		String i="10";
		int nk=Integer.parseInt(i);
		System.out.println(nk);
		System.out.println(s.indexOf('e'));
		System.out.println(s.indexOf(4));
		String k=a.concat(b);
		System.out.println(t[0]+"  t values");
		a.concat("world");
		System.out.println(a);
		StringBuffer n=new StringBuffer("hello");
		System.out.println(System.identityHashCode(n));
		n.append(s);
		System.out.println(n);
		System.out.println(System.identityHashCode(n));
		/*System.out.println(System.identityHashCode(s));
		System.out.println(System.identityHashCode(p));
		String k=new String("Hello");
		System.out.println(System.identityHashCode(k));*/
		char[] l={'h','e','l','l','o'};
			String m=new String(s);	
		}
	}

