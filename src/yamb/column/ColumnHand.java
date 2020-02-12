package yamb.column;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import yamb.DiceCanvas;
import yamb.YambForm;

public class ColumnHand extends Column 
{

	public ColumnHand(ArrayList<DiceCanvas> dicesCanvas, Button roll, ArrayList<CheckBox> chk) 
	{
		super(dicesCanvas, roll, chk);
		this.setImageForColumn("Kockice/ColumnHand.png", "H");
	}
	
	//nakon prvog bacanja kockice polja u koloni hand postavljamo na true. Pozivamo prilikom bacanja kockica
	public void ruleForHand()
	{
		if (YambForm.getBrojPokusaja() > 0)
			for (Button button : nizButtona) 
				button.setDisable(true);
	}
		
	//pri prvom bacanju vracamo polja u koloni hand koja su prazna na enable. Pozivamo prilikom bacanja kockica
	public void ruleForHandResetEmptyField()
	{
		if (YambForm.getBrojPokusaja() == 0)
			for (Button button : nizButtona)
				if (button.getText() == "" )
					button.setDisable(false);
	}

}
