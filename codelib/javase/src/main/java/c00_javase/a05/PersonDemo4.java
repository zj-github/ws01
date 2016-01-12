package c00_javase.a05;
/*
this语句 :用于构造函数之间进行互相调用。

this语句只能定义在构造函数的第一行。因为初始化要先执行。
*/



class PersonDemo4 {
	public static void main(String[] args) {
		new Person();
		// Person p = new Person("lisi",30);
		// Person p1 = new Person("lisi2",36);

	}
}
