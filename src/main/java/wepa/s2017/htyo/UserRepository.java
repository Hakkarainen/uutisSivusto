
package wepa.s2017.htyo;

import org.springframework.data.jpa.repository.JpaRepository;
import wepa.s2017.htyo.domain.User;

/**
 *
 * @author THyyppä
 */

public interface UserRepository extends JpaRepository<User, Long> {
}