package exercise;

public interface SimpleList<T extends Comparable<T>> extends Iterable<T> {

	void add(T entry);

	void set(int index, T entry);

	void remove(T entry);

	T get(int index);

	int size();

}
