package yamb;

import java.util.ArrayList;

import javafx.scene.control.Button;

public class SumResult 
{
	public static int sumNumber(Button b1, Button b2, Button b3, Button b4, Button b5, Button b6) 
	{
		int sum = 0;
		if (b1.getText() != "" && b2.getText() != "" && b3.getText() != "" && b4.getText() != "" && b5.getText() != "" && b6.getText() != "")
			sum = Integer.valueOf(b1.getText()) + Integer.valueOf(b2.getText()) + Integer.valueOf(b3.getText()) + Integer.valueOf(b4.getText()) + Integer.valueOf(b5.getText()) + Integer.valueOf(b6.getText());
		
		if (sum >= 60)
			sum += 30;
		return sum;
	}
	
	public static int sumMaxMin(Button max, Button min, Button b1) 
	{
		int sum = 0;
		if (max.getText() != "" && min.getText() != "" && b1.getText() != "")
			sum = (Integer.valueOf(max.getText()) - Integer.valueOf(min.getText())) * Integer.valueOf(b1.getText());
		return sum;
	}
	
	public static int sumKentaYamb(Button kenta, Button triling, Button full, Button poker, Button yamb) 
	{
		int sum = 0;
		if (kenta.getText() != "" && triling.getText() != "" && full.getText() != "" && poker.getText() != "" && yamb.getText() != "")
			sum = Integer.valueOf(kenta.getText()) + Integer.valueOf(triling.getText()) + Integer.valueOf(full.getText()) + Integer.valueOf(poker.getText()) + Integer.valueOf(yamb.getText());
		return sum;
	}
	
	//za zbir svih kolona i za konacan zbir. Pozivamo kasnije kod racunanje zbira svih z16 ili zMaxMin ili zKentaYamb i za kocanac zbir
	public static int sumColumn(int...s)
	{
		int sum = 0;
			for (int i : s) 
			{
				sum += i;
			}
		return sum;
	}

	//sabira kockice koje su selektovane da bi se upisalo u polje max ili min
	public static int sumMaxMinDice(ArrayList<DiceCanvas> dicesCanvas, int numberOfSelectedDices)
	{
		int sum = 0;
		if (numberOfSelectedDices == 5)
			for (DiceCanvas diceCanvas : dicesCanvas) 
				if (diceCanvas.isSelected() == true)
					sum += diceCanvas.getNumber();
		return sum;
	}
	
}
