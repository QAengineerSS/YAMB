package yamb.column;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import yamb.DiceCanvas;

public class ColumnFree extends Column 
{

	public ColumnFree(ArrayList<DiceCanvas> dicesCanvas, Button roll, ArrayList<CheckBox> chk) 
	{
		super(dicesCanvas, roll, chk);
		this.setImageForColumn("Kockice/ColumnFree.png", "F");
	}

}
