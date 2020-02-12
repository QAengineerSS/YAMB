package yamb;

import java.util.Random;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
////////NE KORISTI SE VISE
public class Dice extends Button 
{
	private int number;
	private Pane pane;
	private String colorOfDice;
	private boolean selected;
	
	public Dice(Pane pane, String colorOfDice) 
	{
		this.setPrefSize(70, 70);
		this.setMaxSize(70, 70);
		this.setFont(new Font(20));
		this.setText("");
		this.setDisable(true);
		this.pane = pane;
		this.colorOfDice = colorOfDice;
		this.selected = false;
		this.number = 0;
	}
	
	//dodeljujemo random broj kockici
	public void rollDice()
	{
		number = new Random().nextInt(6) + 1;
	}
	
	//prikazujemo graficki kockicu
	public void showDice (Dice dice)
	{
		int randomRoll = new Random().nextInt(5) + 10;
		
		//Kockica se vrti...
		Task<Void> task = new Task<Void>() 
		{
			@Override
			protected Void call() throws Exception 
			{
				for (int i = 0; i < randomRoll; i++) 
				{
					int numberRoll = new Random().nextInt(6) + 1;
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					String diceImageString = "Kockice/Kockica" + numberRoll + colorOfDice + ".png";
					Image diceImage = new Image(diceImageString);
					BackgroundImage backgroundImage = new BackgroundImage(diceImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			        Background background = new Background(backgroundImage);
			        Platform.runLater(() -> dice.setBackground(background));
				}
			    
				//Postavljamo konacnu vrednost kockice
			    String diceImageString = "Kockice/Kockica" + number + colorOfDice + ".png";
			    Image diceImage = new Image(diceImageString);
			    BackgroundImage backgroundImage = new BackgroundImage(diceImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		        Background background = new Background(backgroundImage);
		        Platform.runLater(() -> dice.setBackground(background));
		       
				return null;
			}
		};
		Thread th = new Thread(task);
		th.start();
	}

	public int getNumber() {return number;}
	public void setNumber(int number) {this.number = number;}
	public String getColorOfDice() {return colorOfDice;}
	public Pane getPane() {return pane;}
	public boolean isSelected() {return selected;}
	public void setSelected(boolean selected) {this.selected = selected;}
}
