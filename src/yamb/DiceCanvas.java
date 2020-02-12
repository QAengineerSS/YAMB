package yamb;

import java.util.Random;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DiceCanvas extends Canvas
{
	private int number;
	private String color;
	private GraphicsContext gc;
	private boolean selected;
	
	public DiceCanvas(String color)
	{
		super(70, 70);
		this.number = rollDice();
		this.color = color;
		gc = this.getGraphicsContext2D();
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		gc.strokeRect(0, 0, 70, 70);
		gc.setFill(Color.valueOf(color));
	}
	
	public void drawDice (int number)
	{
		if (number == 0)
		{
			gc.clearRect(2, 2, 67, 67);	
		}
		
		else if (number == 1)
		{
			gc.fillOval(30, 30, 10, 10);
		}
		
		else if (number == 2)
		{
			gc.fillOval(5, 5, 10, 10);
			gc.fillOval(55, 55, 10, 10);
		}
		
		else if (number == 3)
		{
			gc.fillOval(5, 5, 10, 10);
			gc.fillOval(55, 55, 10, 10);
			gc.fillOval(30, 30, 10, 10);
		}
		
		else if (number == 4)
		{
			gc.fillOval(5, 5, 10, 10);
			gc.fillOval(55, 5, 10, 10);
			gc.fillOval(5, 55, 10, 10);
			gc.fillOval(55, 55, 10, 10);
		}
		
		else if (number == 5)
		{
			gc.fillOval(5, 5, 10, 10);
			gc.fillOval(55, 5, 10, 10);
			gc.fillOval(5, 55, 10, 10);
			gc.fillOval(55, 55, 10, 10);
			gc.fillOval(30, 30, 10, 10);
		}
		
		else if (number == 6)
		{
			gc.fillOval(5, 5, 10, 10);
			gc.fillOval(55, 5, 10, 10);
			gc.fillOval(5, 55, 10, 10);
			gc.fillOval(55, 55, 10, 10);
			gc.fillOval(5, 30, 10, 10);
			gc.fillOval(55, 30, 10, 10);
		}
	}
	
	public int rollDice()
	{
		number = new Random().nextInt(6) + 1;
		return number;
	}
	
	public void showDice (DiceCanvas canvas)
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
					
			        Platform.runLater(() -> {
			        	drawDice(0);
			        	drawDice(numberRoll);
			        });
			        
			        try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			    }
			    
				//Postavljamo konacnu vrednost kockice
				Platform.runLater(() -> drawDice(0));
		        Platform.runLater(() -> drawDice(number));
		       
				return null;
			}
		};
		Thread th = new Thread(task);
		th.start();
		
	}

	public int getNumber() {return number;}
	public void setNumber(int number) {this.number = number;}
	public String getColor() {return color;}
	public void setColor(String color) {this.color = color;}
	public boolean isSelected() {return selected;}
	public void setSelected(boolean selected) {this.selected = selected;}
	
}
