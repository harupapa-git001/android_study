package ya.Sample;

import java.util.*;
import android.app.*;
import android.os.*;
import android.speech.tts.*;
import android.speech.tts.TextToSpeech.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Rensyu2 extends Activity
{
   EditText et;
   ImageButton bt;
   TextToSpeech tts;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);

      et = new EditText(this);

      bt = new ImageButton(this);
      bt.setImageResource(android.R.drawable.ic_media_play);
      
      ll.addView(et);
      ll.addView(bt);
      
      tts = new TextToSpeech(getApplicationContext(), new SampleInitListener());
      tts.setLanguage(Locale.ENGLISH);
      
      bt.setOnClickListener(new SampleClickListener());
   }
   class SampleClickListener implements OnClickListener
   {
      public void onClick(View v)
      {
         String str  = et.getText().toString();
         if(str != null)
         {
            tts.speak(str, TextToSpeech.QUEUE_FLUSH, null);
         }
      }
   }  
   class SampleInitListener implements OnInitListener
   {
      public void onInit(int status){}
   }  
}
