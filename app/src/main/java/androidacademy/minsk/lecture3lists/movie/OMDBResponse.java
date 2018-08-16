package androidacademy.minsk.lecture3lists.movie;

import java.util.List;

public class OMDBResponse {

    private List<Movie> Search;

    public List<Movie> getSearch() {
        return Search;
    }

    public void setSearch(List<Movie> search) {
        Search = search;
    }
}
