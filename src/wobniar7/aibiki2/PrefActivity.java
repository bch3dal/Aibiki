package wobniar7.aibiki2;

import java.util.*;

import android.os.*;
import android.preference.*;

public class PrefActivity extends PreferenceActivity {
	//設定画面
	
	//display status
	static final private int DISPMODE_KEN_1 = 0;
	static final private int DISPMODE_KEN_2 = 1;
	static final private int DISPMODE_BUN_1 = 2;
	static final private int DISPMODE_BUN_2 = 3;
	//最初は憲政会譜
	private int dismode = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onBuildHeaders(List<Header> target) {
		super.onBuildHeaders(target);
		loadHeadersFromResource(R.xml.pref_fragment, target);
	}
}
