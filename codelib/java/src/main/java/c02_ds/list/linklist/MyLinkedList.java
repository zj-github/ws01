package c02_ds.list.linklist;
/**
 * ����
 * @author oatt1
 *
 * @param <T>
 */
public class MyLinkedList<T> {

	private Node<T> first;
	
	/**
	 * ����ڵ㣺���뵽��ǰ��
	 */
	public void addFirst(T data){
		//1������һ���ڵ�
		//2��ֻ�轫nextָ��first����
		//3��node���Ϊ�����ͷ
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
