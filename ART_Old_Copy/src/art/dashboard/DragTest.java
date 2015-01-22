package art.dashboard;

import java.util.ArrayList;

import org.primefaces.event.DragDropEvent;

import art.datastructures.BOAttribute;

public class DragTest {
	private ArrayList<BOAttribute> names = new ArrayList<BOAttribute>();
	public ArrayList<BOAttribute> getNames() {
		return names;
	}

	public void setNames(ArrayList<BOAttribute> names) {
		this.names = names;
	}

	private ArrayList<BOAttribute> inputs = new ArrayList<BOAttribute>();
	public ArrayList<BOAttribute> getInputs() {
		return inputs;
	}

	public void setInputs(ArrayList<BOAttribute> inputs) {
		this.inputs = inputs;
	}

	private ArrayList<BOAttribute> trans = new ArrayList<BOAttribute>();
	
	public DragTest() {
		names.add(new BOAttribute(0, "test1,", null, null, null));
		names.add(new BOAttribute(1, "test2", null, null, null));
		names.add(new BOAttribute(2, "test3", null, null, null));
		// TODO Auto-generated constructor stub
	}
	
	public void onDrop(DragDropEvent  ddEvent) {
        BOAttribute car = ((BOAttribute) ddEvent.getData());
  
        inputs.add(car);
        names.remove(car);
    }
	
	public void onDrop2(DragDropEvent  ddEvent) {
        BOAttribute car = ((BOAttribute) ddEvent.getData());
  
        trans.add(car);
        names.remove(car);
    }

	public ArrayList<BOAttribute> getTrans() {
		return trans;
	}

	public void setTrans(ArrayList<BOAttribute> trans) {
		this.trans = trans;
	}
}
