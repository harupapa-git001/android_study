package ya.Sample;

import java.util.*;
import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Rensyu3 extends Activity
{
    static final int num = 50;
    SampleView sv;
    Bitmap bmp;
   
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      setContentView(ll);
      
      sv = new SampleView(this);
      
      bmp = BitmapFactory.decodeResource(getResources(), R.drawable.car);
      
      ll.addView(sv);
   }
   class SampleView extends View
   {
      ArrayList<Point> bl;
	   
      public SampleView(Context cn)
      {
         super(cn);
    	  
         bl = new ArrayList<Point>();
   	  
    	 Random rn = new Random();
   	  
   	     for (int i=0; i<num; i++)
   	     {
   	        Point b = new Point();
   		  
            b.x = rn.nextInt(500);
	        b.y = rn.nextInt(1000);
            bl.add(b);
         }
      }
      protected void onDraw(Canvas cs)
      {
   	     super.onDraw(cs);
 	  
     	 Paint p = new Paint();
     	  
         for(int i=0; i<num; i++)
         {
            Point b =   bl.get(i);

            cs.drawBitmap(bmp, b.x,b.y, p); 
         }
      }
   }
}
