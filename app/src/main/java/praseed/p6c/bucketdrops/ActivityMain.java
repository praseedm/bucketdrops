package praseed.p6c.bucketdrops;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import praseed.p6c.bucketdrops.adapters.AdapterDrops;
import praseed.p6c.bucketdrops.pojo.Drop;
import praseed.p6c.bucketdrops.widgets.BucketRecyclerView;

public class ActivityMain extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView Logo,bgImage;
    BucketRecyclerView mRecyclerView;
    Realm mRealm;
    RealmResults<Drop> results;
    String TAG = "check";
    AdapterDrops mAdapter;
    View mEnptyView;

    private RealmChangeListener mRealmListener = new RealmChangeListener() {
        @Override
        public void onChange() {
            Log.d(TAG, "onChange: ");
            mAdapter.update(results);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logo = (ImageView) findViewById(R.id.logo);
        mRealm = Realm.getDefaultInstance();
        results = mRealm.where(Drop.class).findAllAsync();
        mToolbar = (Toolbar) findViewById(R.id.toolbar_id);
        mEnptyView = findViewById(R.id.layout_empty_drops);
        mRecyclerView = (BucketRecyclerView) findViewById(R.id.recyclerView);
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.hideIsEmpty(mToolbar);
        mRecyclerView.showIsEmpty(mEnptyView);
        mAdapter = new AdapterDrops(this,results);
        mRecyclerView.setAdapter(mAdapter);

        setSupportActionBar(mToolbar);
        initBGimage();
    }

    @Override
    protected void onStart() {
        super.onStart();
        results.addChangeListener(mRealmListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        results.removeChangeListener(mRealmListener);
    }

    private void initBGimage() {
        bgImage = (ImageView) findViewById(R.id.background_img);
        Glide.with(this)
                .load(R.drawable.new_bg).centerCrop().into(bgImage);
    }

    public void showDialog(View view) {
        showAddDrop();
    }

    private void showAddDrop() {
        AddDialog dialog = new AddDialog();
        dialog.show(getSupportFragmentManager(),"add a Drop");
    }
}
