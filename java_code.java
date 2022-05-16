 /*<applet code="selectionsortingapplet" width="1000" height="1000">
</applet>*/
import java.applet.*;
import java.awt.*;
public class selectionsortingapplet extends Applet implements Runnable
{
	Thread t;
	int ar[]={9, 22, 19, 14, 7, 6, 12, 25, 4, 11, 23, 16, 15, 8, 24, 13, 1, 5, 20, 17, 10, 21, 2, 3, 18};
	int ipos=0,jpos=0,min=0;
		
	
	public void init()
	{
		t=new Thread(this);
	}
	public void start()
	{
		t.start();
	}
	public void paint(Graphics g)
	{
		int x=0;
		for (int i=0;i<=24;i++)
		{
			if (min==i)
			{
				g.setColor(Color.blue);
			}
			else if (ipos==i)
			{
				g.setColor(Color.red);
			}
			else if (jpos==i)
			{
				g.setColor(Color.green);
				
			}
			else
			{
				g.setColor(Color.black);
			}
		    g.fillRect(100+x,100,20,10*ar[i]);
			x+=30;
		
		}
		
	}
	public void run()
	{
		for (int i=0;i<=23;i++)
		{
			min=i;
			for (int j=i+1;j<=24;j++)
			{
				if (ar[min]>ar[j])
				{
					min=j;
					
				}
				ipos=i;
				jpos=j;
				repaint();
				try
				{	
					t.sleep(1000);
				}
				catch(Exception e){}	
			}
			int temp=ar[i];
				ar[i]=ar[min];
				ar[min]=temp;
		}
		ipos=-1;
		jpos=-1;
		min=-1;
		repaint();
		
	}
	
}
