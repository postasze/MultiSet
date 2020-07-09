package multiSet;

import java.util.*;

public class MultiSet<T> {
	private HashMap<T, Integer> hm;
	
	public MultiSet(){
		hm = new HashMap<T, Integer>();
	}

	public MultiSet(T[] elements){
		hm = new HashMap<T, Integer>();
		for(int i = 0; i < elements.length; i++) this.add(elements[i]);
	}
	
	boolean isEmpty(){
		return hm.isEmpty();
	}
	
	void add(T e){
		Integer x = hm.get(e);
		if (x == null) hm.put(e, 1);
		else {
			hm.remove(e);
			hm.put(e, x+1);
		}
	}
	
	boolean contains (T e){
		return hm.containsKey(e);
	}
	
	boolean del(T e){
		if (!this.contains(e)) return false;
		Integer x = hm.get(e);
		hm.remove(e);
		if (x-1 > 0) hm.put(e, x-1);
		return true;
	}
	
	void union(MultiSet<T> s){
		Set<T> elements = s.hm.keySet();
		for (T e : elements){
			Integer x = this.hm.get(e);
			if (x != null) this.hm.remove(e);
			else x = 0;
			this.hm.put(e, s.hm.get(e) + x);
		}
	}
	
	void intersection(MultiSet<T> s){
		Set<T> elements = this.hm.keySet();
		HashMap<T, Integer> hm1 = new HashMap<T, Integer>();
		for(T e : elements){
			Integer x = s.hm.get(e);
			if (x!=null){
				if (x > this.hm.get(e)) x = this.hm.get(e);
				hm1.put(e, x);
			}
		}
		this.hm = hm1;
	}
	
	void difference(MultiSet<T> s){
		Set<T> elements = s.hm.keySet();
		for(T e : elements){
			Integer x = this.hm.get(e);
			if(x!= null){
				Integer sx = s.hm.get(e);
				this.hm.remove(e);
				if(x - sx > 0) this.hm.put(e, x - sx);
			}
		}
	}
	
	@Override public String toString(){
		Set<T> elements = this.hm.keySet();
		String res = "[ ";
		for(T e : elements){
			for(int i = 1; i <= this.hm.get(e); i++){
				res += e + " ";
			}
		}
		return res + "]\n";
	}
}

