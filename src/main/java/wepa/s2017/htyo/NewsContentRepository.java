
package wepa.s2017.htyo;

import org.springframework.data.jpa.repository.JpaRepository;
import wepa.s2017.htyo.domain.PieceOfNewsContent;
//
/**
 *
 * @author THyyppä
 */
public interface NewsContentRepository extends JpaRepository<PieceOfNewsContent, Long> {
}