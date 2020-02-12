package yamb.column;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import yamb.DiceCanvas;

public class ColumnFromBottom extends Column 
{

	public ColumnFromBottom(ArrayList<DiceCanvas> dicesCanvas, Button roll, ArrayList<CheckBox> chk) 
	{
		super(dicesCanvas, roll, chk);
		this.setImageForColumn("Kockice/ColumnFromBottom.png", "FB");
		Platform.runLater(() -> ruleFromBottom(12, 0));
	}
}
