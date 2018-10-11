public class MySet<E> {
	private MyLinkedList<E> l = new MyLinkedList(); 
	public Boolean IsEmpty(){
		return l.isEmpty();
	}

	public Boolean IsMember(E o){
		return l.isMember((E) o);
	}

	public void Insert(E o){
		if (!this.IsMember((E) o)) 
		{
			this.l.insertLast((E) o);
		}
	}
	public void InsertAtFront(E o){
		if (!this.IsMember((E) o)) 
		{
			this.l.insertFirst((E) o);
		}
	}

	public int size()
	{
		return this.l.size();
	}

	public E Delete(E o)
	{
		return (this.l.removeData((E)o));
	}

	public String printSet()
	{
		return this.l.printL();
	}


	public MySet<E> Union(MySet<E> a)
	{
		MySet<E> c = new MySet<E>();
		c.l = this.l.unionof2l(a.getList());
		return c;
	}

	public MySet<E> Intersection(MySet<E> a)
	{
		MySet<E> c = new MySet<E>();
		c.l = this.l.intersectionof2l(a.getList());
		return c;		
	}

	public MyLinkedList<E> getList()
	{
		return this.l;
	}

	public void setList(MyLinkedList a)
	{
		MyLinkedList a2 = a;
		this.l = a2;
	}

}