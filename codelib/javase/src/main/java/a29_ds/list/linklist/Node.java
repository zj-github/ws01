package a29_ds.list.linklist;

/**
 * 链表的节点
 * 
 * @author oatt1
 *
 */
public class Node<T> {
	public T data;// 数据域
	public Node<T> next;// 指针域

	public Node(T data) {
		this.data = data;
	}
	public String toString() {
		String string = data.toString();
		System.out.println(string);
		return string;
	}
}
