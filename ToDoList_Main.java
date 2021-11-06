package ToDoList;


import javafx.application.Application;
import javafx.stage.Stage;

public class ToDoList_Main extends Application {
	
	private ToDoList_Model model;
	private ToDoList_View view;
	private ToDoList_Controller controller;
	
	
	public static void main(String[] args) {
		launch();
	}

@Override
public void start(Stage stage) throws Exception {
	
	model = new ToDoList_Model();
	view = new ToDoList_View(stage, model);
	controller = new ToDoList_Controller(view, model);
	view.start();

	
	}

}
