package pages;

public class IntegerPair
{
	private int first, second;
	
	public IntegerPair(int hrs, int min)
	{
		this.first = hrs;
		this.second = min;
	}
	
	public int get_hrs()
	{
		return first;
	}
	
	public int get_min()
	{
		return second;
	}
}
