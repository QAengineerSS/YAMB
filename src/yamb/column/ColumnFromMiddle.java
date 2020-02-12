package yamb.column;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import yamb.DiceCanvas;

public class ColumnFromMiddle extends Column 
{

	public ColumnFromMiddle(ArrayList<DiceCanvas> dicesCanvas, Button roll, ArrayList<CheckBox> chk) 
	{
		super(dicesCanvas, roll, chk);
		this.setImageForColumn("Kockice/ColumnFromMiddle.png", "FM");
		Platform.runLater(() -> ruleFromTop(7, 12));
		Platform.runLater(() -> ruleFromBottom(6, 0));
	}

}
