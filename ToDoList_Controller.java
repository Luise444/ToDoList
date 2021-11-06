package ToDoList;


import ToDoList.ToDo.Category;
import ToDoList.ToDo.Importance;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class ToDoList_Controller {

	private ToDoList_View view;
	private ToDoList_Model model;
	private String description;
	private Category category;
	private Importance importance;
	

	public ToDoList_Controller(ToDoList_View view, ToDoList_Model model) {
		this.view  = view;
		this.model = model;
		
		
		
		
		view.btnDelete.setOnAction(this :: delete);
		
		view.newtxt.setOnAction(e -> {
	        add(description);
	    });
		
		
		view.cmbImportance.setOnAction( e ->{
			
			view.newtxt.getStyleClass().remove("Alarm");
			view.newtxt.getStyleClass().remove("Next");
			
		Importance importance = view.cmbImportance.getValue();
		if (importance == Importance.Alarm) view.newtxt.getStyleClass().add("Alarm");
		if (importance== Importance.Next) view.newtxt.getStyleClass().add("Next");
		});	
		}
		
	

	private void add(String description ) {
		
		
		description = view.newtxt.getText();
		Category category = view.cmbCategory.getValue();	
		Importance importance = view.cmbImportance.getValue();
		
		ToDo temp = new ToDo(description, category, importance);
		
		if (description != null && category != null && importance != null) {
		model.addToDo(temp);
		
		view.newtxt.setText( " " );
		}
	}
		
	
	private void delete(ActionEvent e) {
		ObservableList<ToDo> temp2 = view.listView.getSelectionModel().getSelectedItems();
		int i;

		for ( i = temp2.size()-1; i >= 0; i--) {
		ToDo temp = temp2.get(i);
		model.deleteToDo(temp);
		}
		temp2.removeAll();

	}
	
}	


