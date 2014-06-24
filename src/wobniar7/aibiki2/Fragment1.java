package wobniar7.aibiki2;

import android.app.*;
import android.os.*;
import android.view.*;

public class Fragment1 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
		Bundle savedInstanceState) {
		if (container == null) 
			return null;
		
		View v = inflater.inflate(R.layout.fragment1,  container, false);
		//argsの設定とか
		return v;
	}

}