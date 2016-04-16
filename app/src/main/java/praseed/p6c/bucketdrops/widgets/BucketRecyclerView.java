package praseed.p6c.bucketdrops.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import praseed.p6c.bucketdrops.extras.MyUtils;

/**
 * Created by praseedm on 4/16/2016.
 */
public class BucketRecyclerView extends RecyclerView {

    private List<View> mNonEmptyViews = Collections.emptyList();
    private List<View> mEmptyViews = Collections.emptyList();
    private AdapterDataObserver mObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            toggleViews();

        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            toggleViews();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            toggleViews();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            toggleViews();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            toggleViews();
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            toggleViews();
        }
    };

    private void toggleViews() {
        if(getAdapter() != null && !mEmptyViews.isEmpty() && !mNonEmptyViews.isEmpty()){
            if(getAdapter().getItemCount()==0){
                //show All
                MyUtils.showViews(mEmptyViews);
                //Hide RecyclerView
                setVisibility(View.GONE);
                //hideAll
                MyUtils.hideViews(mNonEmptyViews);

            }else {
                //hide All
                MyUtils.hideViews(mEmptyViews);
                //Show RecyclerView
                setVisibility(View.VISIBLE);
                //ShowAll
               MyUtils.showViews(mNonEmptyViews);
            }
        }
    }

    public BucketRecyclerView(Context context) {
        super(context);
    }

    public BucketRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BucketRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        if(adapter != null){
            adapter.registerAdapterDataObserver(mObserver);
        }
        mObserver.onChanged();
    }

    public void hideIsEmpty(View ...views) {
        mNonEmptyViews = Arrays.asList(views);
    }

    public void showIsEmpty(View ...mEnptyViews) {
        mNonEmptyViews = Arrays.asList(mEnptyViews);
    }
}
