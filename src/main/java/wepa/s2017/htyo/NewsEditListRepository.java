
package wepa.s2017.htyo;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import wepa.s2017.htyo.domain.PieceOfNewsContent;

/**
 *
 * @author THyyppä
 */
public interface NewsEditListRepository extends JpaRepository<PieceOfNewsContent, Long> {
    List<PieceOfNewsContent> findByEditor(String editor);
//    @Query("SELECT * FROM News_List ORDER BY latest DESC")
//    PieceOfNewsContent findNewsContentInOrder();
}
