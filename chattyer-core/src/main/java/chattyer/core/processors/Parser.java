package chattyer.core.processors;

public interface Parser<R> {

    R parse(String raw);

}
