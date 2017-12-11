
package wepa.s2017.htyo;

import org.springframework.data.jpa.repository.JpaRepository;
import wepa.s2017.htyo.domain.EditorUser;

/**
 *
 * @author THyyppä
 */

public interface UserRepository extends JpaRepository<EditorUser, Long> {
    EditorUser findByUserName(String userName);
}