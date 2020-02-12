package yamb.column;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import yamb.CheckResult;
import yamb.DiceCanvas;

public class ColumnMax extends Column 
{
	
	public ColumnMax(ArrayList<DiceCanvas> dicesCanvas, Button roll, ArrayList<CheckBox> chk) 
	{
		super(dicesCanvas, roll, chk);
		this.setImageForColumn("Kockice/ColumnMax.png", "M");
		
		b1.setOnMouseClicked(e -> {
			if (CheckResult.checkNumber(dicesCanvas, 1) != 5)
				b1.setText("0");
		});
		
		b2.setOnMouseClicked(e -> {
			if (CheckResult.checkNumber(dicesCanvas, 2) != 10)
				b2.setText("0");
		});
		
		b3.setOnMouseClicked(e -> {
			if (CheckResult.checkNumber(dicesCanvas, 3) != 15)
				b3.setText("0");
		});
		
		b4.setOnMouseClicked(e -> {
			if (CheckResult.checkNumber(dicesCanvas, 4) != 20)
				b4.setText("0");
		});
		
		b5.setOnMouseClicked(e -> {
			if (CheckResult.checkNumber(dicesCanvas, 5) != 25)
				b5.setText("0");
		});
		
		b6.setOnMouseClicked(e -> {
			if (CheckResult.checkNumber(dicesCanvas, 6) != 30)
				b6.setText("0");
		});
		
		kenta.setOnMouseClicked(e -> {
			if (kenta.getText().equalsIgnoreCase("56") || kenta.getText().equalsIgnoreCase("46"))
				kenta.setText("0");
		});
		
		triling.setOnMouseClicked(e -> {
			if (CheckResult.checkTriling(dicesCanvas) != 38)
				triling.setText("0");
		});
		
		full.setOnMouseClicked(e -> {
			if (CheckResult.checkFull(dicesCanvas) != 58)
				full.setText("0");
		});
		
		poker.setOnMouseClicked(e -> {
			if (CheckResult.checkPoker(dicesCanvas) != 64)
				poker.setText("0");
		});
		
		yamb.setOnMouseClicked(e -> {
			if (CheckResult.checkYamb(dicesCanvas) != 80)
				yamb.setText("0");
		});
		
		max.setOnMouseClicked(e -> {
			if (max.getText().equalsIgnoreCase("30") == false)
				max.setText("0");
		});
		
		min.setOnMouseClicked(e -> {
			if (min.getText().equals("5") == false)
				min.setText("0");
		});
	}
}
