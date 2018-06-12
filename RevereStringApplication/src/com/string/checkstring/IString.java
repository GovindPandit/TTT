package com.string.checkstring;

public class IString
{
	StringBuffer string=new StringBuffer();
	
	public IString(String string)
	{
		this.string.append(string);
		this.string=this.string.reverse();
	}

	@Override
	public boolean equals(Object obj) 
	{
		IString string2=(IString)obj;
		boolean status=false;
		for(int i=0;i<this.string.length();i++)
		{
			int j=i+1;
			if(j%2!=0)
			{
				if(this.string.charAt(i)==string2.string.charAt(i))
				{
					System.out.println(this.string.charAt(i));
					System.out.println(string2.string.charAt(i));
					status=true;
				}
				else
				{
					System.out.println(this.string.charAt(i));
					System.out.println(string2.string.charAt(i));
					status=false;
					break;
				}
			}
		}
		return status;
	}
}
