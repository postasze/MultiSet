package multiSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws IOException{
		String wybor, wybor1, wybor2;
		String s;
		
		BufferedReader wejscie = new BufferedReader(new InputStreamReader(System.in));
		Integer [] tablica1 = {1, 2, 2, 3, 5, 6, 6, 6, 8 };
		Integer [] tablica2 = {4, 3, 7, 2, 2, 2, 6, 7, 6, 5, 9 };
		String [] tablica3 = {"abc", "bcd", "bcd", "ghi", "ghi", "ghi", "xyz" };
		String [] tablica4 = {"abc", "bcd", "def", "def", "ghi", "jkl", "jkl", "jkl", "rst" };
		Double [] tablica5 = {4.5, 3.4, 3.4, 2.8, 34.56, 3.78, 3.2, 3.2, 3.2, 6.7, 8.4 };
		Double [] tablica6 = {1.8, 12.56, 25.7, 8.6, 4.5, 3.4, 3.2, 6.7, 8.4, 6.5 };		
		
		MultiSet<Integer> A1 = new MultiSet<Integer>(tablica1);
		MultiSet<String> A2 = new MultiSet<String>(tablica3);
		MultiSet<Double> A3 = new MultiSet<Double>(tablica5);
		MultiSet<Integer> B1 = new MultiSet<Integer>(tablica2);
		MultiSet<String> B2 = new MultiSet<String>(tablica4);
		MultiSet<Double> B3 = new MultiSet<Double>(tablica6);
		
		System.out.println("Program - multizbior");
		System.out.println("Wybierz jakiego typu maja byc elementy zbioru");
		System.out.println("1 ................ Integer");
		System.out.println("2 ................ String");
		System.out.println("3 ................ Double");
		wybor2 = wejscie.readLine();

		do
		{
			System.out.println("Testowanie metod. Nacisnij przycisk 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 lub 11");
			System.out.println("1 ................ Stworz zbior A");
			System.out.println("2 ................ Stworz zbior B");
			System.out.println("3 ................ dodaj element do zbioru A"); // add(E e)
			System.out.println("4 ................ odejmij element od zbioru A"); //  del(E e)
			System.out.println("5 ................ suma zbiorow A i B"); // union(S s)
			System.out.println("6 ................ czesc wspolna zbiorow A i B"); // intersection(S s)
			System.out.println("7 ................ odejmij zbior B od zbioru A"); // difference(S s)
			System.out.println("8 ................ sprawdz czy zbior A zawiera element wczytany z klawiatury"); // contains(E e)
			System.out.println("9 ................ sprawdz czy zbiory A i B sa puste");	// isEmpty(S s)
			System.out.println("10 ............... Wypisz zbiory A i B"); // toString(S s) 
			System.out.println("11 ............... koniec");	
			wybor = wejscie.readLine();
			switch (wybor)
			{	
			case "1" : 
				System.out.println("Nacisnij przycisk 1 lub 2");
				System.out.println("1 ................ Stworz pusty zbior A"); 
				System.out.println("2 ................ Wczytaj gotowy zbior do zbioru A");
				wybor1 = wejscie.readLine();
				switch (wybor1)
				{	
				case "1" :
					if (wybor2.compareTo("1") == 0) A1 = new MultiSet<Integer>(); 
					if (wybor2.compareTo("2") == 0) A2 = new MultiSet<String>(); 
					if (wybor2.compareTo("3") == 0) A3 = new MultiSet<Double>(); 
				break;
				case "2" :
					if (wybor2.compareTo("1") == 0)A1 = new MultiSet<Integer>(tablica1); // na wszelki wypadek tablica zostala wczytana juz wczesniej (w linijkach 25-30) zeby kompilator nie zglosil bledu
					if (wybor2.compareTo("2") == 0) A2 = new MultiSet<String>(tablica3); 
					if (wybor2.compareTo("3") == 0) A3 = new MultiSet<Double>(tablica5); 
				break;
				} break;
			case "2" : 
				System.out.println("Nacisnij przycisk 1 lub 2");
				System.out.println("1 ................ Stworz pusty zbior B"); 
				System.out.println("2 ................ Wczytaj gotowy zbior do zbioru B");
				wybor1 = wejscie.readLine();
				switch (wybor1)
				{	
				case "1" :
					if (wybor2.compareTo("1") == 0) B1 = new MultiSet<Integer>(); 
					if (wybor2.compareTo("2") == 0) B2 = new MultiSet<String>(); 
					if (wybor2.compareTo("3") == 0) B3 = new MultiSet<Double>(); 
				break;
				case "2" :
					if (wybor2.compareTo("1") == 0) B1 = new MultiSet<Integer>(tablica2); // na wszelki wypadek tablica zostala wczytana juz wczesniej (w linijkach 25-30) zeby kompilator nie zglosil bledu
					if (wybor2.compareTo("2") == 0) B2 = new MultiSet<String>(tablica4); 
					if (wybor2.compareTo("3") == 0) B3 = new MultiSet<Double>(tablica6); 
				break;
				} break;
			case "3" : 
				System.out.println("Wpisz element jaki chcesz dodac do zbioru A"); 
				s = wejscie.readLine();
				if (wybor2.compareTo("1") == 0) A1.add(Integer.parseInt(s));
				if (wybor2.compareTo("2") == 0) A2.add(s);
				if (wybor2.compareTo("3") == 0) A3.add(Double.parseDouble(s)); 
				break;
			case "4" : 
				System.out.println("Wpisz element jaki chcesz odjac od zbioru A"); 
				s = wejscie.readLine();
				if (wybor2.compareTo("1") == 0) if(!A1.del(Integer.parseInt(s))) System.out.println("W danym multizbiorze nie ma takiego elementu");
				if (wybor2.compareTo("2") == 0) if(!A2.del(s)) System.out.println("W danym multizbiorze nie ma takiego elementu");
				if (wybor2.compareTo("3") == 0) if(!A3.del(Double.parseDouble(s))) System.out.println("W danym multizbiorze nie ma takiego elementu");
				break;
			case "5" : 
				System.out.println("Suma zbiorow A i B"); 
				if (wybor2.compareTo("1") == 0) {
					A1.union(B1);
					System.out.println(A1);
				}
				if (wybor2.compareTo("2") == 0) {
					A2.union(B2);
					System.out.println(A2);
				}
				if (wybor2.compareTo("3") == 0) {
					A3.union(B3);
					System.out.println(A3);
				}
				break;
			case "6" : 
				System.out.println("Czesc wspolna zbiorow A i B"); 
				if (wybor2.compareTo("1") == 0) {
					A1.intersection(B1);
					System.out.println(A1);
				}
				if (wybor2.compareTo("2") == 0) {
					A2.intersection(B2);
					System.out.println(A2);
				}
				if (wybor2.compareTo("3") == 0) {
					A3.intersection(B3);
					System.out.println(A3);
				}
				break;
			case "7" : 
				System.out.println("Odjecie zbioru B od zbioru A"); 
				if (wybor2.compareTo("1") == 0) {
					A1.difference(B1);
					System.out.println(A1);
				}
				if (wybor2.compareTo("2") == 0) {
					A2.difference(B2);
					System.out.println(A2);
				}
				if (wybor2.compareTo("3") == 0) {
					A3.difference(B3);
					System.out.println(A3);
				}
				break;
			case "8" : 
				System.out.println("Wpisz element ktorego obecnosc w zbiorze A chcesz sprawdzic"); 
				s = wejscie.readLine();
				if (wybor2.compareTo("1") == 0) if(A1.contains(Integer.parseInt(s))) 
					System.out.println("Element znajduje sie w danym multizbiorze");
				else System.out.println("W danym multizbiorze nie ma takiego elementu");
				if (wybor2.compareTo("2") == 0) if(A2.contains(s))
					System.out.println("Element znajduje sie w danym multizbiorze");
				else System.out.println("W danym multizbiorze nie ma takiego elementu");
				if (wybor2.compareTo("3") == 0) if(A3.contains(Double.parseDouble(s)))
					System.out.println("Element znajduje sie w danym multizbiorze");
				else System.out.println("W danym multizbiorze nie ma takiego elementu");
				break;
			case "9" : 
				if (wybor2.compareTo("1") == 0) {
					if (A1.isEmpty()) System.out.println("Zbior A jest pusty"); 
					if (B1.isEmpty()) System.out.println("Zbior B jest pusty"); 
					if (!A1.isEmpty() && !B1.isEmpty()) System.out.println("Zaden ze zbiorow nie jest pusty"); 
				}
				if (wybor2.compareTo("2") == 0) {
					if (A2.isEmpty()) System.out.println("Zbior A jest pusty"); 
					if (B2.isEmpty()) System.out.println("Zbior B jest pusty"); 
					if (!A2.isEmpty() && !B2.isEmpty()) System.out.println("Zaden ze zbiorow nie jest pusty"); 
				}
				if (wybor2.compareTo("3") == 0) {
					if (A3.isEmpty()) System.out.println("Zbior A jest pusty"); 
					if (B3.isEmpty()) System.out.println("Zbior B jest pusty"); 
					if (!A3.isEmpty() && !B3.isEmpty()) System.out.println("Zaden ze zbiorow nie jest pusty"); 
				}
				break;	
			case "10" : 
				if (wybor2.compareTo("1") == 0) {
					System.out.println(A1); 
					System.out.println(B1); 
				}
				if (wybor2.compareTo("2") == 0) {
					System.out.println(A2); 
					System.out.println(B2); 
				}
				if (wybor2.compareTo("3") == 0) {
					System.out.println(A3); 
					System.out.println(B3); 
				}
				break;	
			}
		}
		while (wybor.compareTo("11") != 0); 

	}
}
