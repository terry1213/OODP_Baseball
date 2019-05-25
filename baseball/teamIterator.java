import java.util.Iterator;

public class teamIterator implements Iterator{
	
	private team t;
	private int index; 
	
	public teamIterator(team t) {
		this.t = t;
		this.index = 0;
	}
	
	public boolean hasNext() {
		if(index<t.getLength()) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public Object next() {
		player p = t.getPlayerAt(index);
		index++;
		return p;

	}
}
