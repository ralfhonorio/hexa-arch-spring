package blog.hexaarchspring.application.ports.in;

import java.util.UUID;

public interface RemoveArticleInputPort {
    
    void deleteArticle(UUID id);
}
