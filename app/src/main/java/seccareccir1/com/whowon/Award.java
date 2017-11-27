package seccareccir1.com.whowon;

/**
 * Created by RobertSeccareccia on 11/26/17.
 */

public class Award {
    private String mYear;

    private String mName;

    private String mWinner;

    public Award (String year,String name, String winner) {
        mYear = year;
        mName = name;
        mWinner = winner;
    }

    public String getYear(){
        return mYear;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getWinner() {
        return mWinner;
    }

    public void setWinner(String winner) {
        mWinner = winner;
    }

}
