package a29_ds.list.linklist;

/**
 * ����Ľڵ�
 * 
 * @author oatt1
 *
 */
public class Node<T> {
	public T data;// ������
	public Node<T> next;// ָ����

	public Node(T data) {
		this.data = data;
	}
	public String toString() {
		String string = data.toString();
		System.out.println(string);
		return string;
	}
}
