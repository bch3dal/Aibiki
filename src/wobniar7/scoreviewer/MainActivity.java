package wobniar7.scoreviewer;

import wobniar7.aibiki2.*;
import wobniar7.aibiki2.R.*;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;

public class MainActivity extends Activity {

	//display status
	static final private int DISPMODE_KEN_1 = 0;
	static final private int DISPMODE_KEN_2 = 1;
	static final private int DISPMODE_BUN_1 = 2;
	static final private int DISPMODE_BUN_2 = 3;
	//最初は憲政会譜
	private int dismode = 0;
	
	//メイン画面
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//なんかしらsetしないとfragment呼べないっぽい
		//setContentView(R.layout.activity_main);
		//これは動的にやらないと積む
		setContentView(R.layout.ken_1line);
		
		Fragment1 f1 = new Fragment1();
		FragmentTransaction fTransaction = getFragmentManager().beginTransaction();
		fTransaction.replace(R.id.container_conPanel, f1, "conPanel");
		fTransaction.commit();
		/*
		if (savedInstanceState == null) {
			FragmentManager manager = getFragmentManager();
			FragmentTransaction transaction = manager.beginTransaction();
			transaction.add(R.id.container, new PlaceholderFragment());
			Fragment1 fragment1 = new Fragment1();
			//ここでオプションを設定すればよさそう
			fragment1.setArguments(null);
			transaction.add(R.id.container, new Fragment1());
			transaction.commit();
		}*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent intent = new Intent(MainActivity.this, PrefActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	
	//フラグメント編集
	public void re() {
		
	}
	
	
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_top, container, false);
			return rootView;
		}
	}

}
