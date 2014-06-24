package wobniar7.aibiki2;

import java.util.*;

import android.content.*;
import android.os.*;
import android.preference.*;
import android.preference.Preference.OnPreferenceChangeListener;

public class PrefFragment extends PreferenceFragment {
	//設定画面(詳細)
	
	
	//display status
	static final private int DISPMODE_KEN_1 = 0;
	static final private int DISPMODE_KEN_2 = 1;
	static final private int DISPMODE_BUN_1 = 2;
	static final private int DISPMODE_BUN_2 = 3;
	//最初は憲政会譜
	private int dismode = 0;
	
	private OnPreferenceChangeListener listPrefOnPreferenceChangeListener =
			new OnPreferenceChangeListener(){
		@Override
		public boolean onPreferenceChange(Preference preference, Object newValue) {
			return listPrefOnPreferenceChange(preference, newValue);
			}};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.pref_child_fragment);
		//リスナの登録
		CharSequence cs = getText(R.string.pKey_displayStyle);
		ListPreference pref = (ListPreference)findPreference(cs);
		SharedPreferences sPreferences = getPreferenceManager().getSharedPreferences();
		Map<String, ?> mp = sPreferences.getAll();
		Set<String> s = mp.keySet();
		pref.setSummary(String.format("現在の設定：%s", pref.getEntry()));
		pref.setOnPreferenceChangeListener(listPrefOnPreferenceChangeListener);
	}
	
	private boolean listPrefOnPreferenceChange(Preference preference, Object newValue){
		ListPreference listpref =(ListPreference)preference;
		int eIndex = listpref.findIndexOfValue((String)newValue);
		String newEntry = listpref.getEntries()[eIndex].toString();
		String summary = String.format("現在の設定：%s", newEntry);
		preference.setSummary(summary);
		return true;
	}
	
}

