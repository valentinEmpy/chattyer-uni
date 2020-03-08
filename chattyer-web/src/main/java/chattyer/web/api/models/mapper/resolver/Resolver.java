package chattyer.web.api.models.mapper.resolver;

public interface Resolver<T, R> {

    R resolve(T t);

}
