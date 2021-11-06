package ToDoList;



import ToDoList.ToDo.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ToDoList_Model {
	protected final ObservableList<ToDo> toDoList = FXCollections.observableArrayList();
	protected final ObservableList<ToDo> toDoListPrivate = FXCollections.observableArrayList();
	protected final ObservableList<ToDo> toDoListWork = FXCollections.observableArrayList();
	protected final ObservableList<ToDo> toDoListSchool = FXCollections.observableArrayList();
	protected final ObservableList<ToDo> toDoListHapiness = FXCollections.observableArrayList();
	

	


	public void deleteToDo(ToDo newtodo) {
		toDoList.remove(newtodo);
		toDoListPrivate.remove(newtodo);
		toDoListWork.remove(newtodo);
		toDoListSchool.remove(newtodo);
		toDoListHapiness.remove(newtodo);
	}

	public void addToDo(ToDo newtodo) {
		toDoList.addAll(newtodo);
		
		
		
		Category temp = newtodo.getCategory();
		
		if (temp.equals(ToDoList.ToDo.Category.Work) && temp != null) {
				toDoListWork.addAll(newtodo);
		if (temp.equals(ToDoList.ToDo.Category.Private) && temp != null) 
				toDoListPrivate.addAll(newtodo);
		if (temp.equals(ToDoList.ToDo.Category.School) && temp != null)
				toDoListSchool.addAll(newtodo);
		if (temp.equals(ToDoList.ToDo.Category.Hapiness) && temp != null)
				toDoListHapiness.addAll(newtodo);
		
	}
		}	
	
	

	public ObservableList<ToDo> getToDoList() {
		return toDoList;
	}

	public ObservableList<ToDo> getToDoListPrivate() {
		return toDoListPrivate;
	}

	public ObservableList<ToDo> getToDoListWork() {
		return toDoListWork;
	}

	public ObservableList<ToDo> getToDoListSchool() {
		return toDoListSchool;
	}

	public ObservableList<ToDo> getToDoListHapiness() {
		return toDoListHapiness;
	
	}

}