package ya.Sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Sample7 extends Activity
{
   TextView tv;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      tv = new TextView(this);
      tv.setText("��������Ⴂ�܂��B");

      ll.addView(tv);
   }
   public boolean onKeyDown(int keycode, KeyEvent e)
   {
      String str;
      switch(keycode)
      {
         case KeyEvent.KEYCODE_DPAD_UP:
            str = "��"; break;
         case KeyEvent.KEYCODE_DPAD_DOWN:
            str = "��"; break;        	  
         case KeyEvent.KEYCODE_DPAD_LEFT:
            str = "��"; break;      
         case KeyEvent.KEYCODE_DPAD_RIGHT:
            str = "�E"; break;      
         case KeyEvent.KEYCODE_DPAD_CENTER:
            str = "����"; break;
         default:
            str = "���̃L�[";
      }
      tv.setText(str + "�ł��ˁB");
      
      return true;
   }
}
