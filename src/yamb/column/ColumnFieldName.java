package yamb.column;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import yamb.ButtonFieldName;

public class ColumnFieldName 
{
	private VBox vb = new VBox();
	
	public ColumnFieldName ()
	{
		ButtonFieldName b = new ButtonFieldName("");
		b.setPrefSize(60, 50);
		
		ButtonFieldName b1 = new ButtonFieldName("1");
		ButtonFieldName b2 = new ButtonFieldName("2");
		ButtonFieldName b3 = new ButtonFieldName("3");
		ButtonFieldName b4 = new ButtonFieldName("4");
		ButtonFieldName b5 = new ButtonFieldName("5");
		ButtonFieldName b6 = new ButtonFieldName("6");
		
		ButtonFieldName z16 = new ButtonFieldName("SUM");
		
		ButtonFieldName max = new ButtonFieldName("MAX");
		ButtonFieldName min = new ButtonFieldName("MIN");
		
		ButtonFieldName zMaxMin = new ButtonFieldName("SUM");
		
		ButtonFieldName kenta = new ButtonFieldName("KENTA");
		ButtonFieldName triling = new ButtonFieldName("TRILING");
		ButtonFieldName full = new ButtonFieldName("FULL");
		ButtonFieldName poker = new ButtonFieldName("POKER");
		ButtonFieldName yamb = new ButtonFieldName("YAMB");
		
		ButtonFieldName zKentaYamb = new ButtonFieldName("SUM");
		
		z16.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		zMaxMin.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		zKentaYamb.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		
		vb.getChildren().addAll(b, b1, b2, b3, b4, b5, b6, z16, max, min, zMaxMin, kenta, triling, full, poker, yamb, zKentaYamb);
	}

	public VBox getVb() {return vb;}
	

}
