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
		return tamanyo == 0;				//igual a 	if(tamanyo == 0) return true;
											//			return false;
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

	public boolean remove(Object o) {
		//Nodo inicial
		Nodo n = this.inicio;
		
		//busca el elemento a eliminar
		while(n != null && !n.elemento.equals(o)) {
			n = n.siguiente;
		}
		
		//si no existe devuelve falso
		if (n == null ) return false;
		
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
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(Collection<? extends Object> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, Collection<? extends Object> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
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
		
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		

		System.out.println(l.size());
		
		l.add(a);
		System.out.println(l.size());
		l.add(b);
		System.out.println(l.size());
		l.add(c);
		System.out.println(l.size());
		
		l.remove(a);
		System.out.println(l.size());
		l.remove(b);
		System.out.println(l.size());
		l.remove(c);
		System.out.println(l.size());
		
	}
}
