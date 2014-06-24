package wobniar7.aibiki2;

import wobniar7.scoreviewer.*;
import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class TopMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top);
		
		if (savedInstanceState == null) {
			FragmentManager manager = getFragmentManager();
			FragmentTransaction transaction = manager.beginTransaction();
			TopMenuFragment tFragment = new TopMenuFragment();
			transaction.add(R.id.container, tFragment);
			
			transaction.commit();
		}
		else {
			Toast.makeText(this, "savedDataExist", Toast.LENGTH_SHORT).show();
		}
		
	}

	public static class TopMenuFragment extends Fragment implements OnClickListener {

		public TopMenuFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_top, container, false);
			final int[] butId = {R.id.newButton, R.id.openButton, R.id.settingButton, R.id.closeButton};
			for (int i = 0; i < butId.length; i++) {
				RelativeLayout rL = (RelativeLayout) rootView.findViewById(butId[i]);
				if (rL != null)
					rL.setOnClickListener(this);
				if (i==1)
					rL.setEnabled(false);
			}
			return rootView;
		}

		@Override
		public void onClick(View v) {
			final int id = v.getId();
			switch(id) {
				case R.id.newButton:
					//メイン画面起動
					Intent intent = new Intent(getActivity(), MainActivity.class);
					startActivity(intent);
					Log.v("new", "file!");
					break;
				case R.id.openButton:
					Log.v("open", "file!");
					break;
				case R.id.settingButton:
					Intent intentP = new Intent(getActivity(), PrefActivity.class);
					startActivity(intentP);
					Log.v("setting", "!");
					break;
				case R.id.closeButton:
					getActivity().finish();
					Log.v("see", "you!");
				default:
			}
		}
	}
}
