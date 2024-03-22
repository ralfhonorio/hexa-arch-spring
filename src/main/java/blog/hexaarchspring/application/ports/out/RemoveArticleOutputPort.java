package blog.hexaarchspring.application.ports.out;

import java.util.UUID;

public interface RemoveArticleOutputPort {
    
    void deleteArticle(UUID id);
}
