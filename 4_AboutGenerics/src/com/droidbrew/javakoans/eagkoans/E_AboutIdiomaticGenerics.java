package com.droidbrew.javakoans.eagkoans;

import static com.droidbrew.javakoans.eagkoans.base.Koan.___;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class E_AboutIdiomaticGenerics {
	
	// Fake Implementation of old library
	class ServletRequest{
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Map getParameterMap() {
			Map data = new HashMap();
			data.put("car_brands", new String[]{"audi", "volvo"});
			return data;
		}
		
	}
	
	static class NoWarn {
		public static Map<String, String[]> getParameterMap(ServletRequest r) 
		{
			// look how to get minimal code affection by @SuppressWarnings on declaration command
			@SuppressWarnings("unchecked") Map<String, String[]> result = r.getParameterMap();
			return result;
		}
	}
	
	@Test
	public void a_____prefer_generics_in_new_code_and_reduce_suppressing(){
		assertEquals(___, NoWarn.getParameterMap(new ServletRequest()).get("car_brands")[0]);
	}
	
	@Test
	public void b_____prefer_lists_to_arrays(){
		// Arrays are covariant but generics are invariant
		
		// Fails at runtime!
		Object[] objectArray = new Long[1];
		objectArray[0] = "I don't fit in"; // Throws ArrayStoreException - run the test and see
		
		// Won't compile! Uncomment the following lines
		// List<Object> ol = new ArrayList<Long>(); // Incompatible types
		// ol.add("I don't fit in");
		
	}
	
	class ClassCracker<T>{
		public String whichClass(){
			return this.getClass().getSimpleName();
		}
	}
	
	@Test
	public void c_____prefer_lists_to_arrays_2(){
		// Arrays are refied, generics implemented by erasure for compatibility with legacy code
		assertEquals(___, (new Integer[100]).getClass().getSimpleName());
		assertEquals(___, (new ClassCracker<Integer>()).whichClass());
	}
	
	
	// Returns the maximum value in a list - uses recursive type parameter
	public static <T extends Comparable<T>> T max(List<T> list) {
		Iterator<T> i = list.iterator();
		T result = i.next();
		while (i.hasNext()) {
			T t = i.next();
			if (t.compareTo(result) > 0)
				result = t;
		}
		return result;
	}
	
	@Test
	public void d_____complex_case_with_recursive_parameter(){
		List<Integer> l = new ArrayList<>();
		l.add(10); l.add(1); l.add(101);
		assertEquals(___, max(l));
	}
	
	
	public class Stack<E> {
		private List<E> container;

		public Stack(){
			container = new LinkedList<E>();
		}

		public void push(E e){
			container.add(0, e);
		}

		public E pop(){
			return container.remove(0);
		}

		public boolean isEmpty(){
			return container.isEmpty();
		}
		
		// Wildcard type for parameter that serves as an E producer
		public Stack<E> pushAll(Iterable<? extends E> src) {
			for (E e : src)
				push(e);
			return this;
		}
		
		// Wildcard type for parameter that serves as an E consumer
		public void popAll(Collection<? super E> dst) {
			while (!isEmpty())
				dst.add(pop());
		}
	}
	
	
	@Test
	public void e_____use_bounded_wildcards_to_increase_API_flexibility(){
		// Here is a mnemonic to help you remember which wildcard type to use:
		// PECS stands for producer-extends, consumer-super
		Stack<Number> stack = new Stack<>();
		List<Integer> source = new LinkedList<>();
		source.add(10); source.add(5); source.add(101);
		List<Object> target = new LinkedList<>();
		stack.pushAll(source).popAll(target);
		assertEquals(___, target);
	}
	
	// Typesafe heterogeneous container pattern - implementation
	public class Favorites {
		private Map<Class<?>, Object> favorites =
				new HashMap<Class<?>, Object>();
		public <T> void putFavorite(Class<T> type, T instance) {
			if (type == null)
				throw new NullPointerException("Type is null");
			favorites.put(type, instance);
		}
		public <T> T getFavorite(Class<T> type) {
			return type.cast(favorites.get(type));
		}
	}
	
	@Test
	public void f_____inject_type_to_generic_container_as_a_method_or_constructor_parameter(){
		Favorites f = new Favorites();
		f.putFavorite(String.class, "Java");
		f.putFavorite(Integer.class, 0xcafebabe);
		f.putFavorite(Class.class, Favorites.class);
		String favoriteString = f.getFavorite(String.class);
		int favoriteInteger = f.getFavorite(Integer.class);
		Class<?> favoriteClass = f.getFavorite(Class.class);
		assertEquals(___, String.format("%s %x %s", favoriteString,
				favoriteInteger, favoriteClass.getSimpleName()));
	}
	
	
}
