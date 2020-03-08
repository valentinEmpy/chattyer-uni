package chattyer.common.immutables;

import org.immutables.value.Value;

import java.lang.annotation.Annotation;

@Value.Style(
        add = "*",
        defaults = @Value.Immutable(copy = false),
        depluralize = true,
        jdkOnly = true,
        put = "*",
        visibility = Value.Style.ImplementationVisibility.PUBLIC
)
public @interface ChattyerImmutablesStyle {

    Class<? extends Annotation>[] passAnnotations() default {};

}
