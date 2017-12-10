
package wepa.s2017.htyo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import wepa.s2017.htyo.domain.NewsGenre;
/**
 *
 * @author THy
 */

public interface NewsGenreRepository extends JpaRepository<NewsGenre, Long> {
    List<NewsGenre> findByHeader(String header);
//    //@Query("SELECT * FROM NewsGenreList ORDER BY latest DESC")
//    @Query("SELECT * FROM NewsGenreList")
//    NewsGenre findNewsInOrder();
}
