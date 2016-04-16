package praseed.p6c.bucketdrops;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import praseed.p6c.bucketdrops.adapters.AdapterDrops;

public class ActivityMain extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView Logo,bgImage;
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logo = (ImageView) findViewById(R.id.logo);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_id);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(new AdapterDrops(this));

        setSupportActionBar(mToolbar);
        initBGimage();
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
