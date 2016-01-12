package javase.a29_ds.list;

public class MyArrayList<T> {
	private static final int DEFAULT_CAPACITY = 10;// DEFAULT_CAPACITY ���� 10
	private T[] items;
	private int listSize;

	public MyArrayList() {
		init(DEFAULT_CAPACITY);
	}

	public int size() {
		return listSize;
	}

	public T get(int idx) {
		return items[idx];
	}

	public void add(T t) {
		
		if(listSize==items.length){//�����˳���
			//1������һ��������
			@SuppressWarnings("unchecked")
			T[] newItems = (T [])new Object[listSize+DEFAULT_CAPACITY];
			//2���Ѿ������еĶ����ƶ���������
			System.arraycopy(items, 0, newItems, 0, listSize);
			items = newItems;
			newItems =null;
		}
		System.out.println(listSize+"  "+ items.length);
		items[listSize] = t;
		listSize++;
	}

	/**
	 * ��ʼ������
	 * @param initSize
	 */
	@SuppressWarnings("unchecked")
	public void init(int initSize) {
		if (initSize < listSize)
			return;
		items = (T[]) new Object[initSize]; // ����һ��������
	}

	public void remove(int idx) {
		// �Ѷ�Ӧ�Ǳ�����ֵ����ǰ��һλ
		for (int i = idx; i < listSize - 1; i++) {
			items[i] = items[i + 1];
		}
		listSize--;
	}

	public static void main(String[] args) {
		MyArrayList<String> a = new MyArrayList<>();
		for (int i = 0; i < 20; i++) {
			a.add("a"+i);
		}
	}
}