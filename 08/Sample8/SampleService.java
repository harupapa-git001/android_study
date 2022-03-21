package ya.Sample;

import java.util.*;
import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;

public class SampleService extends Service
{
	NotificationManager nm;
	Random r;
 	String[] str = {"こんにちは", "ありがとう", "さようなら", "またね",
		            "ごちそうさま", "元気でね", "よろしくね", "たのしいね"};
	
   public IBinder onBind(Intent it)
   {
      return null; 
   }
   public void onCreate()
   {
   	  nm = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
   	  
   	  r = new Random();
   }
   public void onStart(Intent it, int id)
   {
      Notification nf = new Notification(R.drawable.icon, "サンプル",System.currentTimeMillis());
      Intent i = new Intent(this, Sample8.class);
      PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
      nf.setLatestEventInfo(getApplicationContext(), "サンプル", "設定画面に移動します。", pi);
      nm.notify(0, nf);
      
      int m  = r.nextInt(str.length);
     
      Toast.makeText(this, str[m], Toast.LENGTH_LONG).show();
   }
   public void onDestroy()
   {
      nm.cancel(0);
   }  
}