package blog.hexaarchspring.application.core.usecase;

import blog.hexaarchspring.application.core.domain.Article;
import blog.hexaarchspring.application.ports.in.FindArticleInputPort;
import blog.hexaarchspring.application.ports.out.FindArticleOutputPort;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FindArticleUseCase implements FindArticleInputPort {

    private final FindArticleOutputPort findArticleOutputPort;

    public FindArticleUseCase(FindArticleOutputPort findArticleOutputPort) {
        this.findArticleOutputPort = findArticleOutputPort;
    }

    @Override
    public Optional<Article> findById(UUID id) {
        return findArticleOutputPort.findById(id);
    }

    @Override
    public List<Article> findAll() {
        return findArticleOutputPort.findAll();
    }
}
