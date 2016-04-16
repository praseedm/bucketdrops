package praseed.p6c.bucketdrops.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import praseed.p6c.bucketdrops.R;

/**
 * Created by praseedm on 4/16/2016.
 */
public class AdapterDrops extends RecyclerView.Adapter<AdapterDrops.DropHolder>{
    //Variables
    private LayoutInflater mInflater;
    private ArrayList<String> mItems = new ArrayList<>();



    public AdapterDrops(Context context){
        mInflater =LayoutInflater.from(context);
        mItems = generateArray();
    }

    @Override
    public DropHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = mInflater.inflate(R.layout.single_drop,parent,false);
        DropHolder holder = new DropHolder(mView);
        return holder;
    }
    public static ArrayList<String> generateArray(){
        ArrayList<String> dummy = new ArrayList<>();
        for (int i=1;i<101;i++){
            dummy.add("Item "+i);
        }
        return dummy;
    }

    @Override
    public void onBindViewHolder(DropHolder holder, int position) {
            holder.mGoal.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public static class DropHolder extends RecyclerView.ViewHolder{
        private TextView mGoal;
        public DropHolder(View itemView) {
            super(itemView);
            mGoal = (TextView) itemView.findViewById(R.id.goal);
        }
    }
}
