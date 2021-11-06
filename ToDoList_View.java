package ToDoList;





import ToDoList.ToDo.Category;
import ToDoList.ToDo.Importance;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ToDoList_View {
	private  Stage stage;
	private  ToDoList_Model model;
	
	
	protected Button btnDelete = new Button("Delete");
	
	ListView<ToDo> listView;
	ListView<ToDo> listViewPrivate;
	ListView<ToDo> listViewWork;
	ListView<ToDo> listViewSchool;	
	ListView<ToDo> listViewHapiness;
	ComboBox<Category> cmbCategory = new ComboBox<>();
	ComboBox<Importance> cmbImportance = new ComboBox<>();
	
	TextField newtxt = new TextField();
	Label work = new Label("work");
	Label private_ = new Label("private");
	Label school = new Label("school");
	Label hapiness = new Label("hapiness");
	

	
	
	public ToDoList_View(Stage stage, ToDoList_Model model) {
		this.model = model;
		this.stage = stage;


		listView = new ListView<>(model.getToDoList());
		
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		

		

		listViewPrivate = new ListView<>(model.getToDoListPrivate());
		
		listViewWork = new ListView<>(model.getToDoListWork());
		
		listViewSchool = new ListView<>(model.getToDoListSchool());
		
		listViewHapiness = new ListView<>(model.getToDoListHapiness());
		
		
	    
	   
		
		HBox root = new HBox();
		
		HBox.setHgrow(listView,Priority.ALWAYS);
		
		root.getChildren().addAll(listView);
		root.getChildren().add(createDataEntryPane());
		root.getChildren().add(listPane());
		

		Scene scene = new Scene(root);
		
		scene.getStylesheets().add(
				getClass().getResource("ToDo.css").toExternalForm());
		stage.setTitle("ToDo Liste");
		stage.setScene(scene);
	}
					
	public void start() {
		stage.show();
	}
	
	private Pane listPane() { 
		GridPane pane = new GridPane();	
		pane.add(private_,0,0);				pane.add(work, 1, 0);
		pane.add(listViewPrivate, 0, 1);	pane.add(listViewWork, 1, 1);
		pane.add(school, 0, 2);				pane.add(hapiness, 1, 2);
		pane.add(listViewSchool, 0, 3);		pane.add(listViewHapiness, 1, 3);
		
	return pane;
	}
	
	private Pane createDataEntryPane() {
	GridPane pane = new GridPane();
	pane.setId("dataEntry");

	Label lbltodo = new Label("ToDo");
	Label lblcatego = new Label("Category");
	Label lblimpo = new Label("Importance");
	
	
	cmbCategory.getItems().addAll(ToDo.Category.values());
	cmbImportance.getItems().addAll(ToDo.Importance.values());
	


	pane.add(lblcatego, 0, 0); 		pane.add(cmbCategory, 1, 0);
	pane.add(lblimpo, 0, 1);		pane.add(cmbImportance, 1, 1);	
	pane.add(lbltodo , 0, 2);		pane.add(newtxt, 1, 2);								
									pane.add(btnDelete, 1, 4);
									
	return pane;
	}

}
