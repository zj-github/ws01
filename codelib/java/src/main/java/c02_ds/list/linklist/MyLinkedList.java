package c02_ds.list.linklist;
/**
 * 链表
 * @author oatt1
 *
 * @param <T>
 */
public class MyLinkedList<T> {

	private Node<T> first;
	
	/**
	 * 插入节点：插入到最前面
	 */
	public void addFirst(T data){
		//1、创建一个节点
		//2、只需将next指向first即可
		//3、node标记为链表的头
		Node<T> node = new Node<T>(data);
		node.next = first;
		first = node;
	}
	
	public String toString(){
		Node<T> cur = first;
		while(cur!=null){
			cur.toString();
			cur = cur.next;
		}
		return "";
	}
	public void find(){
		
	}
	public static void main(String[] args) {
		MyLinkedList<String> l = new MyLinkedList<>();
		l.addFirst("1");
		l.addFirst("2");
		l.addFirst("3");
		l.toString();
	}
}
