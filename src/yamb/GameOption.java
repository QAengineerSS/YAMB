package yamb;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class GameOption 
{
	private Scene scene;
	
	private CheckBox cb1 = new CheckBox("FROM TOP");
	private CheckBox cb2 = new CheckBox("FREE");
	private CheckBox cb3 = new CheckBox("FROM BOTTOM");
	private CheckBox cb4 = new CheckBox("FROM MIDDLE TO TOP AND BOTTOM");
	private CheckBox cb5 = new CheckBox("FROM TOP AND BOTTOM TO MIDDLE");
	private CheckBox cb6 = new CheckBox("N - ANNOUNCEMENT - nije zavrseno");
	private CheckBox cb7 = new CheckBox("H - HAND");
	private CheckBox cb8 = new CheckBox("M - MAX");
	 
	private RadioButton rb1 = new RadioButton("BLACK");
	private RadioButton rb2 = new RadioButton("RED");
	private RadioButton rb3 = new RadioButton("GREEN");
	private RadioButton rb4 = new RadioButton("PURPLE");
	private RadioButton rb5 = new RadioButton("YELLOW");
	private RadioButton rb6 = new RadioButton("PINK");
	private RadioButton rb7 = new RadioButton("BLUE");
	private RadioButton rb8 = new RadioButton("CYAN");
	private RadioButton rb9 = new RadioButton("GOLD");
	private RadioButton rb10 = new RadioButton("DEEP PINK");
	
	private ToggleGroup tg = new ToggleGroup();
	
	private Button ok = new Button("OK");
	private Button selectAll = new Button("SELECT ALL");
	
	public GameOption ()
	{
		GridPane gp = new GridPane();
		gp.setVgap(5);
		gp.setHgap(5);
		gp.setPadding(new Insets(3, 5, 3, 5));
		
		Label label1 = new Label("PICK COLUMN");
		Label label2 = new Label("SELECT COLOR OF DICE");
		
		rb1.setUserData("black");
		rb2.setUserData("red");
		rb3.setUserData("green");
		rb4.setUserData("purple");
		rb5.setUserData("yellow");
		rb6.setUserData("pink");
		rb7.setUserData("blue");
		rb8.setUserData("cyan");
		rb9.setUserData("gold");
		rb10.setUserData("deeppink");
		
		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		rb3.setToggleGroup(tg);
		rb4.setToggleGroup(tg);
		rb5.setToggleGroup(tg);
		rb6.setToggleGroup(tg);
		rb7.setToggleGroup(tg);
		rb8.setToggleGroup(tg);
		rb9.setToggleGroup(tg);
		rb10.setToggleGroup(tg);
		
		gp.add(label1, 0, 0);
		
		gp.add(cb1, 0, 1);
		gp.add(cb2, 0, 2);
		gp.add(cb3, 0, 3);
		gp.add(cb4, 0, 4);
		gp.add(cb5, 0, 5);
		//gp.add(cb6, 0, 6);
		gp.add(cb7, 0, 6);
		gp.add(cb8, 0, 7);
		
		gp.add(label2, 1, 0);
		
		gp.add(rb1, 1, 1);
		gp.add(rb2, 1, 2);
		gp.add(rb3, 1, 3);
		gp.add(rb4, 1, 4);
		gp.add(rb5, 1, 5);
		gp.add(rb6, 1, 6);
		gp.add(rb7, 1, 7);
		gp.add(rb8, 1, 8);
		gp.add(rb9, 1, 9);
		gp.add(rb10, 1, 10);
		
		selectAll.setAlignment(Pos.CENTER);
		selectAll.setPrefSize(90, 30);
		
		selectAll.setOnAction(e -> {
			cb1.setSelected(true);
			cb2.setSelected(true);
			cb3.setSelected(true);
			cb4.setSelected(true);
			cb5.setSelected(true);
			cb7.setSelected(true);
			cb8.setSelected(true);
			
		});
		gp.add(selectAll, 0, 9);
		
		ok.setAlignment(Pos.CENTER);
		ok.setPrefSize(80, 50);
		GridPane.setMargin(ok, new Insets(5, 5, 5, 150));
		gp.add(ok, 0, 11);
		GridPane.setColumnSpan(ok, 2);
		
		scene = new Scene(gp, 400, 550);
	}

	public Scene getScene() {return scene;}
	public CheckBox getCb1() {return cb1;}
	public CheckBox getCb2() {return cb2;}
	public CheckBox getCb3() {return cb3;}
	public CheckBox getCb4() {return cb4;}
	public CheckBox getCb5() {return cb5;}
	public CheckBox getCb6() {return cb6;}
	public CheckBox getCb7() {return cb7;}
	public CheckBox getCb8() {return cb8;}
	public RadioButton getRb1() {return rb1;}
	public RadioButton getRb2() {return rb2;}
	public RadioButton getRb3() {return rb3;}
	public RadioButton getRb4() {return rb4;}
	public Button getOk() {return ok;}
	public ToggleGroup getTg() {return tg;}
}
