package blog.hexaarchspring.adapters.out.repository.database.jpa;

import blog.hexaarchspring.adapters.out.repository.database.jpa.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, UUID> {
}
