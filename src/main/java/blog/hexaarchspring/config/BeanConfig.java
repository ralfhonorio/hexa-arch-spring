package blog.hexaarchspring.config;

import blog.hexaarchspring.application.core.usecase.*;
import blog.hexaarchspring.application.ports.out.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
    @Bean
    public CreateArticleUseCase createArticleUseCase(PostArticleOutputPort postArticleOutputPort) {
        return new CreateArticleUseCase(postArticleOutputPort);
    }

    @Bean
    public FindArticleUseCase findArticleUseCase(FindArticleOutputPort findArticleOutputPort) {
        return new FindArticleUseCase(findArticleOutputPort);
    }

    @Bean
    public RemoveArticleUseCase removeArticleUseCase(RemoveArticleOutputPort removeArticleOutputPort) {
        return new RemoveArticleUseCase(removeArticleOutputPort);
    }

    @Bean
    public UpdateArticleUseCase updateArticleUseCase(UpdateArticleOutputPort updateArticleOutputPort) {
        return new UpdateArticleUseCase(updateArticleOutputPort);
    }
}

