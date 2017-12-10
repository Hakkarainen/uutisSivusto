
package wepa.s2017.htyo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wepa.s2017.htyo.domain.PieceOfNewsHeader;
import wepa.s2017.htyo.domain.NewsGenre;
//
/**
 *
 * @author THyyppä
 */
public interface NewsLiRepository extends JpaRepository<PieceOfNewsHeader, Long> {
}