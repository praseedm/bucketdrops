package praseed.p6c.bucketdrops.pojo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by praseedm on 4/16/2016.
 */
public class Drop extends RealmObject {
    private String goal;
    @PrimaryKey
    private long addedtTime;
    private long dewTime;
    private boolean flag;

    public Drop() {
    }

    public Drop(String goal, long addedtTime, long dewTime, boolean flag) {
        this.goal = goal;
        this.addedtTime = addedtTime;
        this.dewTime = dewTime;
        this.flag = flag;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public long getAddedtTime() {
        return addedtTime;
    }

    public void setAddedtTime(long addedtTime) {
        this.addedtTime = addedtTime;
    }

    public long getDewTime() {
        return dewTime;
    }

    public void setDewTime(long dewTime) {
        this.dewTime = dewTime;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
