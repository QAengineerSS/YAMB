package yamb;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import yamb.column.Column;
import yamb.column.ColumnFieldName;
import yamb.column.ColumnFree;
import yamb.column.ColumnFromBottom;
import yamb.column.ColumnFromMiddle;
import yamb.column.ColumnFromTop;
import yamb.column.ColumnFromTopAndBottomToMiddle;
import yamb.column.ColumnHand;
import yamb.column.ColumnMax;
import yamb.column.ColumnSum;

public class YambForm 
{

	private Scene scene;
	private ArrayList<CheckBox> chk = new ArrayList<>();
	private static int brojPokusaja = 0;
	private ArrayList<DiceCanvas> dicesCanvas = new ArrayList<>();
		
	private Button roll = new Button("ROLL");
	private ColumnFieldName columnFieldName = new ColumnFieldName();
	private ColumnFromTop columnFromTop = new ColumnFromTop(dicesCanvas, roll, chk);
	private ColumnFree columnFree = new ColumnFree(dicesCanvas, roll, chk);
	private ColumnFromBottom columnFromBottom = new ColumnFromBottom(dicesCanvas, roll, chk);
	private ColumnFromMiddle columnFromMiddle = new ColumnFromMiddle(dicesCanvas, roll, chk);
	private ColumnFromTopAndBottomToMiddle columnFromTopAndBottomToMiddle = new ColumnFromTopAndBottomToMiddle(dicesCanvas, roll, chk);
	private ColumnHand columnHand = new ColumnHand(dicesCanvas, roll, chk);
	private ColumnMax columnMax = new ColumnMax(dicesCanvas, roll, chk);
	private ColumnSum columnSum = new ColumnSum();
	
	private ArrayList<Column> listCheckedColumn = new ArrayList<>();
	
	private int selectedDiceNumber;
	public static int remaningMoves;
	public static Button remaningMovesButton = new Button();
	
	public YambForm(GameOption go) 
	{
		Platform.runLater(() -> checkThisDice());
		
		// GLAVNO
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(5, 5, 5, 5));
		
		// GP ZA KOCKICE I CHECK
		GridPane gp1 = new GridPane();
		gp1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		gp1.setVgap(10);
		gp1.setHgap(10);
		gp1.setPadding(new Insets(5, 10, 5, 50));
		
		//pakujemo kockice i check boxove
		for (int i = 0; i < 6; i++) 
		{
			if (go.getTg().getSelectedToggle() != null) 
			{
//				Dice dice = new Dice(gp1, go.getTg().getSelectedToggle().getUserData().toString());
//				gp1.add(dice, i, 2);
//				dices.add(dice);
				
				DiceCanvas diceCanvas = new DiceCanvas(go.getTg().getSelectedToggle().getUserData().toString());
				gp1.add(diceCanvas, i, 0);
				dicesCanvas.add(diceCanvas);
			} 
			else 
			{
				DiceCanvas diceCanvas = new DiceCanvas("black");
				gp1.add(diceCanvas, i, 0);
				dicesCanvas.add(diceCanvas);
			}

			CheckBox check = new CheckBox();
			GridPane.setMargin(check, new Insets(0, 0, 0, 25));
			gp1.add(check, i, 1);
			chk.add(check);
		}
		vbox.getChildren().add(gp1);

		// BUTTON ZAVRTI
		roll.setMinWidth(200);
		roll.setMinHeight(30);
		VBox.setMargin(roll, new Insets(5, 0, 20, 185));

		roll.setOnAction((ActionEvent event) -> {
			checkForHandColumn();
			calculateResult();
			
			if (brojPokusaja <= 2)
			{
				brojPokusaja++;
				for (int i = 0; i < dicesCanvas.size(); i++) 
				{
					if (chk.get(i).isSelected() == false) 
					{
						dicesCanvas.get(i).setNumber(dicesCanvas.get(i).rollDice());
						dicesCanvas.get(i).showDice(dicesCanvas.get(i));
					}
				}
			}

			if (brojPokusaja >= 3)
				roll.setDisable(true);
			
		});

		vbox.getChildren().add(roll);
		
		//Za pakovanje kolona
		GridPane gpColumn = new GridPane();
		
		gpColumn.add(columnFieldName.getVb(), 0, 0);
		
		if (go.getCb1().isSelected())
		{
			gpColumn.add(columnFromTop.getVb(), 1, 0);
			listCheckedColumn.add(columnFromTop);
		}
		
		if (go.getCb2().isSelected())
		{
			gpColumn.add(columnFree.getVb(), 2, 0);
			listCheckedColumn.add(columnFree);
		}
		
		if (go.getCb3().isSelected())
		{
			gpColumn.add(columnFromBottom.getVb(), 3, 0);
			listCheckedColumn.add(columnFromBottom);
		}
		
		if (go.getCb4().isSelected())
		{
			gpColumn.add(columnFromMiddle.getVb(), 4, 0);
			listCheckedColumn.add(columnFromMiddle);
		}
		
		if (go.getCb5().isSelected())
		{
			gpColumn.add(columnFromTopAndBottomToMiddle.getVb(), 5, 0);
			listCheckedColumn.add(columnFromTopAndBottomToMiddle);
		}
		
		if (go.getCb7().isSelected())
		{
			gpColumn.add(columnHand.getVb(), 6, 0);
			listCheckedColumn.add(columnHand);
		}
		
		if (go.getCb8().isSelected())
		{
			gpColumn.add(columnMax.getVb(), 7, 0);
			listCheckedColumn.add(columnMax);
		}
		
		gpColumn.add(columnSum.getVb(), 8, 0);
		gpColumn.setAlignment(Pos.CENTER);
		
		vbox.getChildren().add(gpColumn);
		
		remaningMoves = listCheckedColumn.size() * 13;
		remaningMovesButton.setDisable(true);
		remaningMovesButton.setPrefWidth(50);
		remaningMovesButton.setText(String.valueOf(remaningMoves));
		
		HBox boxResult = new HBox(10);
		boxResult.getChildren().add(remaningMovesButton);
		boxResult.setAlignment(Pos.CENTER);
		
		vbox.getChildren().add(boxResult);
		
		scene = new Scene(vbox, 400, 400);
	}
	
	//pravi listu sa obelezenim kockicama
	public static void pickDices (ArrayList<DiceCanvas> dicesCanvas, ArrayList<CheckBox> chk) 
	{
		for (DiceCanvas dice : dicesCanvas) 
		{
			dice.setSelected(false);
		}
		for (int i = 0; i < dicesCanvas.size(); i ++)
		{
			if (chk.get(i).isSelected() == true)
				dicesCanvas.get(i).setSelected(true);
		}
	}
	//racuna konacni rezultat
	private void calculateResult()
	{
		int sumZ16 = 0;
		int sumZMaxMin = 0;
		int sumZKentaYamb = 0;
		
		//sabiramo sume za kolone i prikazujemo
		for (Column c : listCheckedColumn) 
		{
			if (c.getZ16().getText() != "")
				sumZ16 += Integer.valueOf(c.getZ16().getText());
			c.getZ16().setText(String.valueOf(SumResult.sumNumber(c.getB1(), c.getB2(), c.getB3(), c.getB4(), c.getB5(), c.getB6())));
			
			if (c.getzMaxMin().getText() != "")
				sumZMaxMin += Integer.valueOf(c.getzMaxMin().getText());
			c.getzMaxMin().setText(String.valueOf(SumResult.sumMaxMin(c.getMax(), c.getMin(), c.getB1())));
			
			if (c.getzKentaYamb().getText() != "")
				sumZKentaYamb += Integer.valueOf(c.getzKentaYamb().getText());
			c.getzKentaYamb().setText(String.valueOf(SumResult.sumKentaYamb(c.getKenta(), c.getTriling(), c.getFull(), c.getPoker(), c.getYamb())));
		}
		//sabiramo sumu za red sumZ16, sumZMaxMin i sumZKentaYamb
		columnSum.getNizButtona().get(7).setText(String.valueOf(sumZ16));
		columnSum.getNizButtona().get(10).setText(String.valueOf(sumZMaxMin));
		columnSum.getNizButtona().get(16).setText(String.valueOf(sumZKentaYamb));
		
		//sabiramo i ispisujemo konacan rezultat
		if (columnSum.getNizButtona().get(7).getText() != "" && columnSum.getNizButtona().get(10).getText() != "" && columnSum.getNizButtona().get(16).getText() != "")
		{
			int sum = Integer.valueOf(columnSum.getNizButtona().get(7).getText()) + Integer.valueOf(columnSum.getNizButtona().get(10).getText()) + Integer.valueOf(columnSum.getNizButtona().get(16).getText());
			columnSum.getNizButtona().get(17).setText(String.valueOf(sum));
		}
	}
	
	//kada se klikne na neku kockicu stiklira sve kockice sa istom vrednoscu a ostale kockice odstiklira
	private void checkThisDice() 
	{
		for (DiceCanvas d : dicesCanvas) 
		{
			d.setOnMousePressed(e -> {
				selectedDiceNumber = d.getNumber();
				for (int i = 0; i < dicesCanvas.size(); i++) 
				{
					if (dicesCanvas.get(i).getNumber() == selectedDiceNumber)
						chk.get(i).setSelected(true);
					else
						chk.get(i).setSelected(false);
				}
			});
		}
	}
	//ako sva polja osim u rucnoj budu popunjena nakon prvog bacanja kockice disablovati novo bacanje kockice da bi korisnik mogao da popuni polje u hand koloni
	public void checkForHandColumn()
	{
		columnHand.ruleForHand();
		columnHand.ruleForHandResetEmptyField();
		int brojacPrazniPolja = 0;
		//cim nadje prvo prazno polje koje nije u koloni hand prekida pretragu
		for (int i = 0; i < listCheckedColumn.size() && brojacPrazniPolja == 0; i++)
		{
			for(ButtonField button : listCheckedColumn.get(i).getNizButtona())
			{
				if (button.getText().equalsIgnoreCase("") && (listCheckedColumn.get(i) instanceof ColumnHand) == false)
					brojacPrazniPolja++;
			}
		}
		if (brojacPrazniPolja == 0)
			roll.setDisable(true);
	}
	
	public Scene getScene() {return scene;}
	public static int getBrojPokusaja() {return brojPokusaja;}
	public static void setBrojPokusaja(int brojPokusaja) {YambForm.brojPokusaja = brojPokusaja;}
	
}
