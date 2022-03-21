package ya.Sample;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample14 extends Activity
{
   TextView tv;
   Button bt;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      tv = new TextView(this);
      tv.setText("��������Ⴂ�܂��B");
      bt = new Button(this);
      bt.setText("�w��");

      ll.addView(tv);
      ll.addView(bt);
 
      bt.setOnClickListener(new SampleClickListener());
   }
   
   class SampleClickListener implements OnClickListener
   {
      public void onClick(View v)
      {
         AlertDialog.Builder db 
            = new AlertDialog.Builder(Sample14.this);
         db.setTitle("�m�F");
         db.setMessage("�{���ɍw�����܂����H");
         db.setPositiveButton("�͂�", new SampleDialogClickListener());
         db.setNegativeButton("������", null).show();
      }
      class SampleDialogClickListener implements DialogInterface.OnClickListener
      {
         public void onClick(DialogInterface d, int w)
         {
            new AlertDialog.Builder(Sample14.this)
                 .setTitle("�w��")
                 .setMessage("���肪�Ƃ��������܂��B")
                 .setPositiveButton("OK", null).show();
         } 
      }
   }  
}
