package seccareccir1.com.whowon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the recycler view
        RecyclerView awardList = findViewById(R.id.award_list);
        awardList.setHasFixedSize(true);

        // Create the linear layout manager for the recycler view
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        awardList.setLayoutManager(llm);

        // Set the adapter to the recycler view
        AwardViewAdapter awardViewAdapter = new AwardViewAdapter(getAwardList());
        awardList.setAdapter(awardViewAdapter);
        awardList.setItemAnimator(new DefaultItemAnimator());
    }

    private ArrayList<Award> getAwardList() {
        ArrayList<Award> awardList = new ArrayList<>();
        awardList.add(new Award("Year","Category","Nominee"));
        InputStream is = getResources().openRawResource(R.raw.awards);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8));
        String line = "";
        try {
            while ((line =reader.readLine()) != null) {
                String[] tokens = line.split(",");
                awardList.add(new Award(tokens[0],tokens[1],tokens[2]));
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return awardList;
    }

}
