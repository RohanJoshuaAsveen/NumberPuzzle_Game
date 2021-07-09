import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		int buttonClickedId=0;
		for(Button b: buttons)
		{
			if(b==buttonClicked)
				break;
			buttonClickedId++;
		}
		
		if(Math.abs(buttonClickedId-emptyCellId)==1 || Math.abs(buttonClickedId-emptyCellId)==4)
		{
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId=buttonClickedId;
		}					
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		int index=0,ct=0;
		
		while(ct<15) {
			int a = getRandomNumber();
			a=(int) (Math.ceil(a*0.14)+1);
			boolean contains = false;
			
			for(int i=0;i<ct;i++){
				if(a==arr[i]) {
					contains = true;	
				}
			}
			
			if(!contains)
			{
				arr[index]=a;
				ct++;
				index++;
			}	
		}
		
		return arr;
		
		
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		int[] buttonsIds = getIntegerArrayOfButtonIds(buttons);
		
		
		for(int i=0;i<buttonsIds.length-1;i++) {
			if(buttonsIds[i]>buttonsIds[i+1])
				winner = false;
		}

		return winner;
	}
}