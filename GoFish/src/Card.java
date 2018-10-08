import java.util.ArrayList;

public class Card
	{
		private int value;
		private String color;
		
		public Card(int v, String c)
		{
			value = v;
			color = c;
			
		}

		public int getValue()
			{
				return value;
			}

		public void setValue(int value)
			{
				this.value = value;
			}

		public String getColor()
			{
				return color;
			}

		public void setColor(String color)
			{
				this.color = color;
			}
		
		
		
		
	}
