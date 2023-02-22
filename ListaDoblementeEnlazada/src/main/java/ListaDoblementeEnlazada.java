import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListaDoblementeEnlazada implements List<Object> {

	private int tamanyo;
	private Nodo inicio;
	private Nodo fin;
	
	class Nodo{
		Object elemento;
		Nodo siguiente;
		Nodo anterior;
	}
	
	
	public ListaDoblementeEnlazada() {
		tamanyo = 0;
	}
	
	public int size() {
		return this.tamanyo;
	}

	public boolean isEmpty() {
		return tamanyo == 0;				
	}

	public boolean contains(Object o) {
		Nodo aux = inicio;
		while (aux != null) {
			if (aux.elemento.equals(o)) return true;
			aux = aux.siguiente;
		}
		return false;
	}

	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(Object e) {
		Nodo n = new Nodo();
		n.elemento = e;
		
		if(tamanyo == 0) {
			this.fin = n;
		} else {
			n.siguiente = this.inicio;
			this.inicio.anterior = n;
		}
		this.inicio = n;
		tamanyo ++;
		
		return false;
	}
	
	public void add(int index, Object element) {
		if(index > this.tamanyo || index < 0) throw new IndexOutOfBoundsException();
		
		if(index == 0) {this.add(element);}
		else if (index == tamanyo) {
			Nodo nuevo = new Nodo();
			
			nuevo.elemento = element;
			
			nuevo.anterior = this.fin;
			this.fin.siguiente = nuevo;
			this.fin = nuevo;
			
			this.tamanyo++;
		}
		else {
			Nodo nuevo = new Nodo();
			nuevo.elemento = element;
			
			

		}
		
	}

	public boolean remove(Object o) {
		//Nodo inicial
		Nodo n = this.inicio;
		
		//busca el elemento a eliminar
		while(n != null && !n.elemento.equals(o)) {
			n = n.siguiente;
		}
		
		//si no existe devuelve falso
		if (n == null) return false;
		
		//si el elemento es el primero
		if(n.anterior == null) {
			this.inicio = n.siguiente;
			if(n.siguiente != null)
				n.siguiente.anterior = null;
		}
		else n.anterior.siguiente = n.siguiente;
		
		//si el elemento es el ultimo
		if(n.siguiente == null) {
			this.fin = n.anterior;
			if(n.anterior != null)
				n.anterior.siguiente = null;
		}
		else n.siguiente.anterior = n.anterior;
		
		//si el elemento esta en medio, los else´s se encargan de ello
		tamanyo --;
		return true;
	}

	public boolean containsAll(Collection<?> c) {
		for(Object element: c) {
			if(!this.contains(element)) return false;
		}
		return false;
	}

	public boolean addAll(Collection<? extends Object> c) {
		for(Object element: c) {
			this.add(element);
		}
		return false;
	}

	public boolean addAll(int index, Collection<? extends Object> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		for (Object object : c) {
			remove(object);
		}
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		Nodo n = this.inicio;
		boolean result = false;
		
		while(n.siguiente != null) {
			if(!c.contains(n.elemento))		this.remove(n.elemento);
			n = n.siguiente;
			result = true;
		}
		return result;
	}

	public void clear() {
		Nodo n = this.inicio;
		
		while(n != null) {
			System.out.println(this.remove(n));
			n = n.siguiente;
		}
		
		this.inicio = null;
		this.fin = null;
		//this.tamanyo = 0;
	}

	public Object get(int index) {
		if(index < 0 || index >= tamanyo) throw new IndexOutOfBoundsException();
		
		Nodo n = this.inicio;

		for(int i = 0; i<index; i++) {
			n = n.siguiente;
		}
		
		return n.elemento;
	}

	public Object set(int index, Object element) {
		return null;
	}

	

	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator<Object> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator<Object> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		ListaDoblementeEnlazada l = new ListaDoblementeEnlazada();
		
		String a = "a";
		String b = "b"; 
		String c = "c"; 
		
		System.out.println(l.size());
		
		l.add(a);
		l.add(b);
		l.add(c);

		System.out.println(l.size());
		
		System.out.println(l.get(0));
		
	}
}
