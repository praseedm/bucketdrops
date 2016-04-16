package praseed.p6c.bucketdrops.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.RealmResults;
import praseed.p6c.bucketdrops.R;
import praseed.p6c.bucketdrops.pojo.Drop;

/**
 * Created by praseedm on 4/16/2016.
 */
public class AdapterDrops extends RecyclerView.Adapter<AdapterDrops.DropHolder>{
    //Variables
    private LayoutInflater mInflater;
    private RealmResults<Drop> mItems;
    private String TAG = "check";


    public AdapterDrops(Context context,RealmResults<Drop> results){
        mInflater =LayoutInflater.from(context);
        update(results);
    }

    public void  update (RealmResults<Drop> results){
         mItems = results;
        notifyDataSetChanged();
    }

    @Override
    public DropHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = mInflater.inflate(R.layout.single_drop,parent,false);
        DropHolder holder = new DropHolder(mView);
        Log.d(TAG, "onCreateViewHolder: ");
        return holder;
    }


    @Override
    public void onBindViewHolder(DropHolder holder, int position) {
            Drop drop = mItems.get(position);
            holder.mGoal.setText(drop.getGoal());
        Log.d(TAG, "onBindViewHolder: "+position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class DropHolder extends RecyclerView.ViewHolder{
        private TextView mGoal;
        public DropHolder(View itemView) {
            super(itemView);
            mGoal = (TextView) itemView.findViewById(R.id.goal);
        }
    }
}
