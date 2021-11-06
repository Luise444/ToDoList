package ToDoList;




public class ToDo{

	
	protected enum Category{ Private, Work, School, Hapiness,};
	protected enum Importance{ Alarm, Next, Timeleft};
	private String newToDo;
	private Category category;
	private Importance importance;
	

public ToDo(String newToDo, Category category, Importance importance) {
	this.newToDo = newToDo;
	this.category = category;
	this.importance = importance;
	
	
}



public Category getCategory() {
	return category;
}


public void setCategory(Category category) {
	this.category = category;
}


public Importance getImportance() {
	return importance;
}


public void setImportance(Importance importance) {
	this.importance = importance;
}


public String getNewToDo() {
	return newToDo;
}


public void setNewToDo(String newToDo) {
	this.newToDo = newToDo;
}
public String toString() {
	return newToDo + "  :"+importance;
	
}

}