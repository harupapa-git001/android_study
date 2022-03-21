package ya.Sample;

import java.util.*;

import android.appwidget.*;
import android.content.*;
import android.graphics.*;
import android.widget.*;

public class Rensyu2 extends AppWidgetProvider
{
   public void onUpdate(Context cn, AppWidgetManager am, int[] ids)
   {
      RemoteViews rv = new RemoteViews(cn.getPackageName(), R.layout.widget);

      Calendar cl = Calendar.getInstance();
      cl.setTime(new Date());
      int h = cl.get(Calendar.HOUR_OF_DAY);
      
      String str = "��������";      

      if(6 <= h && h <= 10)
      {
    	  str = "���͂悤";      
      }
      else if(11 <= h && h <= 15)
      { 
    	  str = "����ɂ���"; 
      }
      else if(16 <= h && h <= 20)
      {
    	  str = "�܂�����"; 
      }
      else if(21 <= h && h <= 24)
      {
    	  str = "���₷��"; 
      }
      else if(0 <= h && h <= 5)
      {
    	  str = "ZZZ..."; 
      }      
      
      rv.setTextViewText(R.id.SampleTextView, str);
      rv.setTextColor(R.id.SampleTextView, Color.BLACK);
      am.updateAppWidget(ids, rv);
      
   }
}
