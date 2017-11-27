package seccareccir1.com.whowon;

/**
 * Created by RobertSeccareccia on 11/26/17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AwardViewAdapter extends RecyclerView.Adapter<AwardViewAdapter.AwardViewHolder> {

    private List<Award> mAwardList;

    public AwardViewAdapter(List<Award> awardList) {
        mAwardList = awardList;
    }

    @Override
    public AwardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.award_row, parent, false);

        return new AwardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AwardViewHolder holder, int position) {
        Award awardAtPosition = mAwardList.get(position);
        holder.awardYear.setText(awardAtPosition.getYear());
        holder.awardName.setText(awardAtPosition.getName());
        holder.awardWinner.setText(awardAtPosition.getWinner());
    }

    @Override
    public int getItemCount() {
        return mAwardList.size();
    }

    /**
     * The view holder finds the views in the row layout that we want to modify in the view adapter
     * We find the id for the name and school text view in the row layout xml file, so we can set above in onBindViewHolder
     */
    public class AwardViewHolder extends RecyclerView.ViewHolder {
        protected TextView awardYear;
        protected TextView awardName;
        protected TextView awardWinner;

        public AwardViewHolder(View itemView) {
            super(itemView);
            awardYear = (TextView) itemView.findViewById(R.id.award_year_text_view);
            awardName = (TextView) itemView.findViewById(R.id.award_name_text_view);
            awardWinner = (TextView) itemView.findViewById(R.id.award_winner_text_view);
        }
    }
}