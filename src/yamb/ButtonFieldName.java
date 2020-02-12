package yamb;

import javafx.scene.control.Button;

public class ButtonFieldName extends Button 
{
	public ButtonFieldName (String s)
	{
		this.setText(s);
		this.setPrefWidth(60);
		this.setDisable(true);
		this.setStyle("-fx-background-color: white");
	}
}
