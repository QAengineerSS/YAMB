package yamb.column;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import yamb.DiceCanvas;

public class ColumnFromTop extends Column 
{

	public ColumnFromTop(ArrayList<DiceCanvas> dicesCanvas, Button roll, ArrayList<CheckBox> chk) 
	{
		super(dicesCanvas, roll, chk);
		this.setImageForColumn("Kockice/ColumnFromTop.png", "FT");
		Platform.runLater(() -> ruleFromTop(0, 12));
	}

}
