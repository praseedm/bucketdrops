package praseed.p6c.bucketdrops.extras;

import android.view.View;

import java.util.List;

/**
 * Created by praseedm on 4/17/2016.
 */
public class MyUtils {

    public static  void showViews(List<View> views){
        for(View view: views){
            view.setVisibility(View.VISIBLE);
        }
    }

    public static  void hideViews(List<View> views){
        for(View view: views){
            view.setVisibility(View.GONE);
        }
    }
}

