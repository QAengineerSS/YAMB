package yamb.column;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import yamb.ButtonField;
import yamb.CheckResult;
import yamb.DiceCanvas;
import yamb.SumResult;
import yamb.YambForm;

public abstract class Column 
{
	private VBox vb = new VBox();
	
	protected ButtonField b = new ButtonField("");
	 
	protected ButtonField b1 = new ButtonField("");
	protected ButtonField b2 = new ButtonField("");
	protected ButtonField b3 = new ButtonField("");
	protected ButtonField b4 = new ButtonField("");
	protected ButtonField b5 = new ButtonField("");
	protected ButtonField b6 = new ButtonField("");
	 
	protected ButtonField z16 = new ButtonField("");
	 
	protected ButtonField max = new ButtonField("");
	protected ButtonField min = new ButtonField("");
	 
	protected ButtonField zMaxMin = new ButtonField("");
	 
	protected ButtonField kenta = new ButtonField("");
	protected ButtonField triling = new ButtonField("");
	protected ButtonField full = new ButtonField("");
	protected ButtonField poker = new ButtonField("");
	protected ButtonField yamb = new ButtonField("");
	 
	protected ButtonField zKentaYamb = new ButtonField("");
	
	protected ArrayList<ButtonField> nizButtona = new ArrayList<>();
		
	public Column (ArrayList<DiceCanvas> dicesCanvas, Button roll, ArrayList<CheckBox> chk)
	{
		//setujemo polja koja trebaju da budu disablovana
		b.setDisable(true);
		b.setPrefSize(60, 50);
		
		z16.setDisable(true);
		zMaxMin.setDisable(true);
		zKentaYamb.setDisable(true);
		
		kenta.setOnAction(e -> {
				YambForm.pickDices(dicesCanvas, chk);
				kenta.setText(String.valueOf(CheckResult.checkKenta(dicesCanvas, YambForm.getBrojPokusaja())));
				kenta.setDisable(true);
				resetAfter3roll(dicesCanvas, roll, chk);
		});
		
		triling.setOnAction(e -> {
				
				YambForm.pickDices(dicesCanvas, chk);
				triling.setText(String.valueOf(CheckResult.checkTriling(dicesCanvas)));
				triling.setDisable(true);
				resetAfter3roll(dicesCanvas, roll, chk);
		});
		
		full.setOnAction(e -> {
				YambForm.pickDices(dicesCanvas, chk);
				full.setText(String.valueOf(CheckResult.checkFull(dicesCanvas)));
				full.setDisable(true);
				resetAfter3roll(dicesCanvas, roll, chk);
		});
		
		poker.setOnAction(e -> {
				YambForm.pickDices(dicesCanvas, chk);
				poker.setText(String.valueOf(CheckResult.checkPoker(dicesCanvas)));
				poker.setDisable(true);
				resetAfter3roll(dicesCanvas, roll, chk);
		});
		
		yamb.setOnAction(e -> {
				YambForm.pickDices(dicesCanvas, chk);
				yamb.setText(String.valueOf(CheckResult.checkYamb(dicesCanvas)));
				yamb.setDisable(true);
				resetAfter3roll(dicesCanvas, roll, chk);
		});
		
		max.setOnAction(e -> {
			YambForm.pickDices(dicesCanvas, chk);
			if (numberOfSelectedDices(dicesCanvas) == 5)
			{
				max.setText(String.valueOf(SumResult.sumMaxMinDice(dicesCanvas, numberOfSelectedDices(dicesCanvas))));
				max.setDisable(true);
				resetAfter3roll(dicesCanvas, roll, chk);
			}
			else
			{
				YambForm.remaningMoves++;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText("You must select 5 dice");
				alert.showAndWait();
			}
		});
		
		min.setOnAction(e -> {
			YambForm.pickDices(dicesCanvas, chk);
			if (numberOfSelectedDices(dicesCanvas) == 5)
			{
				min.setText(String.valueOf(SumResult.sumMaxMinDice(dicesCanvas, numberOfSelectedDices(dicesCanvas))));
				min.setDisable(true);
				resetAfter3roll(dicesCanvas, roll, chk);
			}
			else
			{
				YambForm.remaningMoves++;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText("You must select 5 dice");
				alert.showAndWait();
			}
		});
		
		b1.setOnAction(e-> {
			YambForm.pickDices(dicesCanvas, chk);
			b1.setText(String.valueOf(CheckResult.checkNumber(dicesCanvas, 1)));
			b1.setDisable(true);
			resetAfter3roll(dicesCanvas, roll, chk);
		});
		
		b2.setOnAction(e-> {
			YambForm.pickDices(dicesCanvas, chk);
			b2.setText(String.valueOf(CheckResult.checkNumber(dicesCanvas, 2)));
			b2.setDisable(true);
			resetAfter3roll(dicesCanvas, roll, chk);
		});
		
		b3.setOnAction(e-> {
			YambForm.pickDices(dicesCanvas, chk);
			b3.setText(String.valueOf(CheckResult.checkNumber(dicesCanvas, 3)));
			b3.setDisable(true);
			resetAfter3roll(dicesCanvas, roll, chk);
		});
		
		b4.setOnAction(e-> {
			YambForm.pickDices(dicesCanvas, chk);
			b4.setText(String.valueOf(CheckResult.checkNumber(dicesCanvas, 4)));
			b4.setDisable(true);
			resetAfter3roll(dicesCanvas, roll, chk);
		});
		
		b5.setOnAction(e-> {
			YambForm.pickDices(dicesCanvas, chk);
			b5.setText(String.valueOf(CheckResult.checkNumber(dicesCanvas, 5)));
			b5.setDisable(true);
			resetAfter3roll(dicesCanvas, roll, chk);
		});
		
		b6.setOnAction(e-> {
			YambForm.pickDices(dicesCanvas, chk);
			b6.setText(String.valueOf(CheckResult.checkNumber(dicesCanvas, 6)));
			b6.setDisable(true);
			resetAfter3roll(dicesCanvas, roll, chk);
		});
		
		//ubacujemo u niz buttone da bi kasnije lakse mogli da definisemo rule za upis rezultata (preko for petlje) u suprotnom bi morali rucno da pisemo za svako polje
		nizButtona.add(b1);//0
		nizButtona.add(b2);
		nizButtona.add(b3);
		nizButtona.add(b4);
		nizButtona.add(b5);
		nizButtona.add(b6);
		nizButtona.add(max);//6
		nizButtona.add(min);//7
		nizButtona.add(kenta);
		nizButtona.add(triling);
		nizButtona.add(full);
		nizButtona.add(poker);
		nizButtona.add(yamb);//12
		
		//setujemo izgled polja za sumu
		z16.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		z16.setStyle("-fx-background-color: white");
		zMaxMin.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		zMaxMin.setStyle("-fx-background-color: white");
		zKentaYamb.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		zKentaYamb.setStyle("-fx-background-color: white");
		
		vb.getChildren().addAll(b, b1, b2, b3, b4, b5, b6, z16, max, min, zMaxMin, kenta, triling, full, poker, yamb, zKentaYamb);
	}
	
	//nakon 3 bacanja kockice i upisa rezultata bacanje je ponovo omoguceno i kockice su podesene na 0 kao i svi checkboxovi su odcekirani
	private void resetAfter3roll(ArrayList<DiceCanvas> dicesCanvas, Button roll, ArrayList<CheckBox> chk)
	{
		YambForm.setBrojPokusaja(0);
		roll.setDisable(false);
		
		for (DiceCanvas diceCanvas : dicesCanvas) 
		{
			Platform.runLater(() -> diceCanvas.setNumber(0));//pri svakom resetu setovane kockice na 0, u suprotnom bi mogli vise puta da upisujemo isti rezultat (jer ostaju upamcenje poslednje kockice)
			Platform.runLater(() -> diceCanvas.drawDice(0));//setujemo "praznu" kockicu
		}
		for (CheckBox c : chk)
		{
			Platform.runLater(() -> c.setSelected(false));
		}
	}
	//broj obelezenih kockica, potrebno je prilikom upisa max i min
	private int numberOfSelectedDices (ArrayList<DiceCanvas> dicesCanvas)
	{
		int b = 0;
		for (DiceCanvas d : dicesCanvas) 
		{
			if (d.isSelected() == true)
				b++;
		}
		return b;
	}
	
	//Klikom na b1 (prilikom unosa rezultata) b2 se prebacuje na enable. Koristi se kod kolona kod kojih imamo pravila za redosled unosa. Metode ruleFromTop i ruleFromBottom
	private void onButtonClickChangeOtherButtonDisable (Button b1, Button b2)
	{
		b1.setOnMouseClicked(e -> b2.setDisable(false));
	}
	
	//prvo polje je omoguceno a sva ostala ispod su onemogucene dokle god je prvo polje prazno. Kada se prvo polje popuni onda prvo sledece polje postaje omoguceno
	//polja idu od gore ka dole
	protected void ruleFromTop (int start, int end)
	{
		for (int i = start; i < end; i++)
		{
			if (nizButtona.get(i).getText() == "")
				nizButtona.get(i+1).setDisable(true);
			onButtonClickChangeOtherButtonDisable(nizButtona.get(i), nizButtona.get(i+1));
		}
	}
	
	//prvo polje je omoguceno a sva ostala ispod su onemogucene dokle god je prvo polje prazno. Kada se prvo polje popuni onda prvo sledece polje postaje omoguceno
	//polja idu od dole ka gore
	protected void ruleFromBottom (int start, int end)
	{
		for (int i = start; i > end; i--)
		{
			if (nizButtona.get(i).getText() == "")
				nizButtona.get(i-1).setDisable(true);
			onButtonClickChangeOtherButtonDisable(nizButtona.get(i), nizButtona.get(i - 1));
		}
	}
	//setovanje slike za kolonu
	protected void setImageForColumn (String image, String textIfimageNoExist)
	{
		try 
		{
			Image diceImage = new Image(image);
			BackgroundImage backgroundImage = new BackgroundImage(diceImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		    Background background = new Background(backgroundImage);
			b.setBackground(background);
		}
		catch (IllegalArgumentException e) 
		{
			b.setText(textIfimageNoExist);
			b.setFont(new Font(null, 23));
		}
	}
	
	public VBox getVb() {return vb;}
	public ButtonField getZ16() {return z16;}
	public ButtonField getzMaxMin() {return zMaxMin;}
	public ButtonField getzKentaYamb() {return zKentaYamb;}
	public ButtonField getB1() {return b1;}
	public ButtonField getB2() {return b2;}
	public ButtonField getB3() {return b3;}
	public ButtonField getB4() {return b4;}
	public ButtonField getB5() {return b5;}
	public ButtonField getB6() {return b6;}
	public ButtonField getMax() {return max;}
	public ButtonField getMin() {return min;}
	public ButtonField getKenta() {return kenta;}
	public ButtonField getTriling() {return triling;}
	public ButtonField getFull() {return full;}
	public ButtonField getPoker() {return poker;}
	public ButtonField getYamb() {return yamb;}
	public ArrayList<ButtonField> getNizButtona() {return nizButtona;}

	
}
