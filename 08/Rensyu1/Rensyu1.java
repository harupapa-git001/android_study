package ya.Sample;

import android.app.*;
import android.content.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.provider.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Rensyu1 extends Activity
{
   public static int SAMPLE_APP = 1;
   Button bt1, bt2;
   MediaPlayer mp;
   
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);

      bt1 = new Button(this);
      bt2 = new Button(this);
      
      bt1.setText("ò^âπ");
      bt2.setText("çƒê∂");
      
 	  mp = new MediaPlayer();      
 	  
      ll.addView(bt1);
      ll.addView(bt2);
      
      bt1.setOnClickListener(new SampleClickListener());
      bt2.setOnClickListener(new SampleClickListener());
   }
   public void onActivityResult(int reqcode, int result, Intent it)
   {
      if(reqcode == SAMPLE_APP && result == RESULT_OK)
      {
    	 bt1.setEnabled(true);
    	 bt2.setEnabled(true);
    	 
    	 Uri uri = it.getData();
    	 try
         {
    		mp.reset(); 
            mp.setDataSource(this, uri);
            mp.prepare();
         }
    	 catch(Exception e){} 
      }
   }
   class SampleClickListener implements OnClickListener
   {
      public void onClick(View v)
      {
         if(v == bt1) 
         {
            Intent it = new Intent();
            it.setAction(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
        
            startActivityForResult(it,SAMPLE_APP);
         }
         else if(v == bt2)
         {
            try
            {
                mp.start();
            }
            catch(Exception e){}
        }
      }
   }  
}

