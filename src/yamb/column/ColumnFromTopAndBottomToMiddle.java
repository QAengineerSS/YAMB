package yamb.column;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import yamb.DiceCanvas;

public class ColumnFromTopAndBottomToMiddle extends Column
{

	public ColumnFromTopAndBottomToMiddle(ArrayList<DiceCanvas> dicesCanvas, Button roll, ArrayList<CheckBox> chk) 
	{
		super(dicesCanvas, roll, chk);
		this.setImageForColumn("Kockice/ColumnToMiddle.png", "TM");
		Platform.runLater(() -> ruleFromTop(0, 6));
		Platform.runLater(() -> ruleFromBottom(12, 7));
	}

}
