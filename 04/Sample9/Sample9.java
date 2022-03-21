package ya.Sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;

public class Sample9 extends Activity
{
   TextView tv;
   GridView gv;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      tv = new TextView(this);
      tv.setText("��������Ⴂ�܂��B");
            
      gv = new GridView(this);
      String[] str = {"��p��","�g���b�N","�I�[�v���J�[",
    		          "�^�N�V�[","�X�|�[�c�J�[","�~�j�J�[",
    		          "���]��","�O�֎�","�o�C�N",
    		          "��s�@","�w���R�v�^�[","���P�b�g"};
      ArrayAdapter<String> ad = new ArrayAdapter<String>
           (this, android.R.layout.simple_list_item_1, str);
      gv.setAdapter(ad);
      gv.setNumColumns(3);
      
      ll.addView(tv);
      ll.addView(gv);
      
      gv.setOnItemClickListener(new SampleItemClickListener());
   }
   class SampleItemClickListener implements OnItemClickListener
   {
      public void onItemClick(AdapterView<?>v, View iv, int pos, long id)
      {
         TextView tmp = (TextView) iv;
         tv.setText(tmp.getText() + "�ł��ˁB");
      }
   }  
}
