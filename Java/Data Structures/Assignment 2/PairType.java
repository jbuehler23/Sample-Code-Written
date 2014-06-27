
public class PairType<E1, E2> implements stack.java<E>
{
	
    private stack<E1> data1;
    private stack<E2> data2;
    
    public PairType(stack<E1> E1 , stack<E2> E2) {
        this.data1 = E1;
        this.data2 = E2;
    }

    public stack<E1> getFirst() {
        return data1;
    }

    public void setFirst(stack<E1> E1) {
        this.data1 = E1;
    }

    public stack<E2> getSecond() {
        return data2;
    }

    public void setSecond(stack<E2> E2) {
        this.data2 = E2;
    }
    
    
}
