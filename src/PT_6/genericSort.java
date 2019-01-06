package PT_6;

public class genericSort {
	
	public <T extends Comparable<T>> void sort(T[] l) {
		for (int n = l.length; n>1; --n){
			for (int i = 0; i<n-1; ++i){
				if (l[i].compareTo(l[i+1]) >= 1){ //l[i] > l[i+1]
					swap(l, i, i+1);
				}
			}
		}
	}
	
	private <T> void swap(T[] a, int i, int j) {
        if (i != j) {
            T temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
	
	public <T> String arrayToString(T[] l) {
		String out = "";
		for (T i : l)
			out += i.toString() +", ";
		return out;
	}
	
	public <T extends Comparable<T>> void printSortprint(T[] l) {
		System.out.println(arrayToString(l));
		sort(l);
		System.out.println(arrayToString(l));
	}
}
