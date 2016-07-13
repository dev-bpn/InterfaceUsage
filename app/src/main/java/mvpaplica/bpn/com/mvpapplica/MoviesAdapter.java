package mvpaplica.bpn.com.mvpapplica;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
 
    private List<mvpaplica.bpn.com.mvpapplica.Movie> moviesList;
    RecyclerItemClick recyclerItemClick;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title, year, genre;
 
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            recyclerItemClick.onItemClick(getAdapterPosition());

        }
    }
 
 
    public MoviesAdapter(List<mvpaplica.bpn.com.mvpapplica.Movie> moviesList , Context context) {
        this.moviesList = moviesList;
        recyclerItemClick = (RecyclerItemClick) context;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        mvpaplica.bpn.com.mvpapplica.Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }
 
    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}