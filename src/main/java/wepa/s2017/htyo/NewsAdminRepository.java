
package wepa.s2017.htyo;

import org.springframework.data.jpa.repository.JpaRepository;
import wepa.s2017.htyo.domain.EditorUser;

/**
 *
 * @author THyyppä
 */

public interface NewsAdminRepository extends JpaRepository<EditorUser, Long> {
}
