package blog.hexaarchspring.application.core.usecase;

import blog.hexaarchspring.application.ports.in.RemoveArticleInputPort;
import blog.hexaarchspring.application.ports.out.RemoveArticleOutputPort;

import java.util.UUID;

public class RemoveArticleUseCase implements RemoveArticleInputPort {
    private final RemoveArticleOutputPort removeArticleOutputPort;

    public RemoveArticleUseCase(RemoveArticleOutputPort removeArticleOutputPort) {
        this.removeArticleOutputPort = removeArticleOutputPort;
    }
    
    @Override
    public void deleteArticle(UUID id) {
        removeArticleOutputPort.deleteArticle(id);
    }
}
