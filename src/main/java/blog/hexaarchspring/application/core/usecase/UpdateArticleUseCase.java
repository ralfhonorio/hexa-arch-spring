package blog.hexaarchspring.application.core.usecase;

import blog.hexaarchspring.application.core.domain.Article;
import blog.hexaarchspring.application.ports.in.UpdateArticleInputPort;
import blog.hexaarchspring.application.ports.out.UpdateArticleOutputPort;

public class UpdateArticleUseCase implements UpdateArticleInputPort {

    private final UpdateArticleOutputPort updateArticleOutputPort;

    public UpdateArticleUseCase(UpdateArticleOutputPort updateArticleOutputPort) {
        this.updateArticleOutputPort = updateArticleOutputPort;
    }

    @Override
    public Article updateArticle(Article article) {
        return updateArticleOutputPort.updateArticle(article);
    }
}
