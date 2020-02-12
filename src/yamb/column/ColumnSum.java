package yamb.column;

import java.util.ArrayList;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import yamb.ButtonField;

public class ColumnSum 
{
	private VBox vb = new VBox();
	private ArrayList<ButtonField> nizButtona = new ArrayList<>();
	
	public ColumnSum ()
	{
		vb.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		
		for (int i = 0; i < 18; i++)
		{
			ButtonField b = new ButtonField("");
			b.setDisable(true);
			b.setVisible(false);
			nizButtona.add(b);
			vb.getChildren().add(b);
		}
		nizButtona.get(0).setText("SUM");
		nizButtona.get(0).setVisible(true);
		nizButtona.get(0).setPrefSize(60, 50);
		nizButtona.get(7).setVisible(true);
		nizButtona.get(7).setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		nizButtona.get(10).setVisible(true);
		nizButtona.get(10).setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		nizButtona.get(16).setVisible(true);
		nizButtona.get(16).setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		nizButtona.get(17).setVisible(true);
		nizButtona.get(17).setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
	}

	public VBox getVb() {return vb;}
	public ArrayList<ButtonField> getNizButtona() {return nizButtona;}
	
}
