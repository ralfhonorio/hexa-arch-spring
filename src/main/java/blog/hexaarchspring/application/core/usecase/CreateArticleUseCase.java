package blog.hexaarchspring.application.core.usecase;

import blog.hexaarchspring.application.core.domain.Article;
import blog.hexaarchspring.application.ports.in.PostArticleInputPort;
import blog.hexaarchspring.application.ports.out.PostArticleOutputPort;

public class CreateArticleUseCase implements PostArticleInputPort {
    private final PostArticleOutputPort postArticleOutputPort;

    public CreateArticleUseCase(PostArticleOutputPort postArticleOutputPort) {
        this.postArticleOutputPort = postArticleOutputPort;
    }

    @Override
    public Article createArticle(Article article) {
        return postArticleOutputPort.createArticle(article);
    }
}
